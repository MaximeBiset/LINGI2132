import java.lang.System;
import java.lang.Integer;

public class Primes
{
    // This methode behaves as follow :
    // First, it create a linked list containing the numbers between 2 and n.
    // Then, it look for multiples of its node inside it and remove it
    //
    // @param n : the upper value
    // @return ll : the linkedlist containing the primes numbers
    public static LinkedList getPrimes(int n)
    {
        LinkedList ll = new LinkedList(new Node(2));
        int p = 2;
        while(p < n) {
            p = p + 1;        
            ll.addNode(new Node(p));
        }
        p = 2;
        int value;
        while(p <= n) {
            value = 2 * p;
            while(value <= n) {
                ll.removeNode(new Node(value));
                value += p;
            }
            p += 1;
        }
        return ll;
    }
    
    public static void main(String[] args)
    {
        if(args.length > 1)
            System.out.println("Usage : java primes <n>");
        else if(args.length == 0)
            System.out.println("Usage : java primes <n>");
        else {
            int n = Integer.parseInt(args[0]);
            LinkedList ll = getPrimes(n);
            System.out.println("The primes number below "+n+" are :");
            System.out.println(ll.toString());
        }
    }
}

// A simple node (of a linked list) storing a integer value "value"
class Node 
{
    private int value;
    private Node next;

    public Node(int value)
    {
        this.value = value;
    }
    
    public void setNext(Node node)
    {
        this.next = node;
    }
    
    public Node getNext()
    {
        return this.next;
    }
    
    // return 0 if the node hasn't followers in the datastructur.
    // 1 elsewise 
    public int hasNext()
    {
        if((Object) next == null)
            return 0;
        else
            return 1;
    }
    
    public int getValue()
    {
        return this.value;
    }
    
    public void setValue(int value)
    {
        this.value = value;
    }
}

class LinkedList
{
    private Node first;
    private Node current; //We keep a reference to the last node of the list, to have O(1) insertion
    private int size;
    
    public LinkedList(Node node) 
    {
        this.first = node;
        this.current = node;
        this.size = 1;
    }
    
    //Insert a node at the end of the list
    
    public void addNode(Node node)
    {
        this.current.setNext(node);
        this.current = node;
        this.size += 1;
    }
    
    public Node getFirst()
    {
        return this.first;
    }   
    
    // @param : node, the node to remove
    // remove the first node n such that n.Value() == node.value()
    // If such a node is found and removed, the function returns 1. 0 elsewise

    public int removeNode(Node node)
    {
        if(this.first.getValue() == node.getValue()) {
            this.first = this.first.getNext();
            this.size = this.size - 1 ;
            return 1;
        }
        else {
            Node n1 = this.first;
            Node n2;
            while(n1.hasNext() == 1) {
                n2 = n1.getNext();
                if(n2.getValue() == node.getValue()) {
                    n1.setNext(n2.getNext());
                    this.size = this.size - 1;
                    return 1;
                }
                n1 = n1.getNext();
            }
            return 0;
        }
    }
    
    public int Size()
    {
        return this.size;
    }
    
    //return a String representation of the linked list
    
    public String toString()
    {   
        String string = new String();
        Node node = this.first;
        string += "[";
        string += node.getValue();
         while(node.hasNext() == 1) {
            node = node.getNext();
            string += ", ";
            string += node.getValue();
        }
        string += "]";
        return string;
    }
}    
