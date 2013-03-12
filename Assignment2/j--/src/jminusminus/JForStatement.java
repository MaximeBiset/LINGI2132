package jminusminus;

import java.util.ArrayList;

public class JForStatement extends JStatement {
	
	ArrayList<JAST> forInit;
	ArrayList<JStatement> forUpdate;
	JExpression expression;
	JStatement statement;
	

	protected JForStatement(int line, ArrayList<JAST> forInit, JExpression expression, ArrayList<JStatement> forUpdate, JStatement statement) 
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
        p.printf("<ForInit>\n");
        p.indentRight();
        for(JAST init : forInit)
        	init.writeToStdOut(p);
        p.indentLeft();
        p.printf("</ForInit>\n");
        p.printf("<JExpression>\n");
        p.indentRight();
        expression.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JExpression>\n");
        p.printf("<ForUpdate>\n");
        p.indentRight();
        for(JStatement update : forUpdate)
        	update.writeToStdOut(p);
        p.printf("</ForUpdate>\n");
        p.indentLeft();
        p.printf("<JStatement>\n");
        p.indentRight();
        statement.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JStatement>\n");
        p.indentLeft();
        p.printf("</JForStatement>\n");

	}

}