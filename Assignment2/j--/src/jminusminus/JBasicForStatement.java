package jminusminus;

import java.util.ArrayList;

public class JBasicForStatement extends JStatement {
	
	ArrayList<JAST> forInit;
	ArrayList<JStatement> forUpdate;
	JExpression expression;
	JStatement statement;
	

	protected JBasicForStatement(int line, ArrayList<JAST> forInit, JExpression expression, ArrayList<JStatement> forUpdate, JStatement statement) 
	{
		super(line);
		this.forInit = forInit;
		this.forUpdate = forUpdate;
		this.statement = statement;
		this.expression = expression;
		// TODO Auto-generated constructor stub
	}

	@Override
	public JAST analyze(Context context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void codegen(CLEmitter output) {
		// TODO Auto-generated method stub

	}

	@Override
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