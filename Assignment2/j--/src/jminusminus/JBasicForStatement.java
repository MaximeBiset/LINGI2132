package jminusminus;

import java.util.ArrayList;

public class JBasicForStatement extends JStatement {
	
	ArrayList<JStatement> forInit;
	ArrayList<JStatement> forUpdate;
	JExpression expression;
	JStatement statement;
	

	protected JBasicForStatement(int line, ArrayList<JStatement> forInit, JExpression expression, ArrayList<JStatement> forUpdate, JStatement statement) 
	{
		super(line);
		this.forInit = forInit;
		this.forUpdate = forUpdate;
		this.statement = statement;
		this.expression = expression;
		// TODO Auto-generated constructor stub
	}

	public JAST analyze(Context context) {
		for (JStatement js : forInit)
			js.analyze(context);
		
		if (expression != null)
			expression.analyze(context);
		
		for (JStatement js : forUpdate) 
			js.analyze(context);
		
		statement.analyze(context);
		return this;
	}

	public void codegen(CLEmitter output) {
		

	}

	public void writeToStdOut(PrettyPrinter p)
	{
        p.printf("<JForStatement line=\"%d\">\n", line());
        p.indentRight();
        if (forInit.size() != 0) {
	        p.printf("<ForInit>\n");
	        p.indentRight();
	        for(JAST init : forInit)
	        	init.writeToStdOut(p);
	        p.indentLeft();
	        p.printf("</ForInit>\n");
        }
        if(expression != null ) {
	        p.printf("<JExpression>\n");
	        p.indentRight();
	        expression.writeToStdOut(p);
	        p.indentLeft();
	        p.printf("</JExpression>\n");
        }
        if (forInit.size() != 0)
        {
	        p.printf("<ForUpdate>\n");
	        p.indentRight();
	        for(JStatement update : forUpdate)
	        	update.writeToStdOut(p);
	        p.indentLeft();
	        p.printf("</ForUpdate>\n");
        }
        p.printf("<JStatement>\n");
        p.indentRight();
        statement.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JStatement>\n");
        p.indentLeft();
        p.printf("</JForStatement>\n");

	}

}