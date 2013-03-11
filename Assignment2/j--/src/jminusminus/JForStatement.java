package jminusminus;

public class JForStatement extends JStatement {
	
	JForInitExpression init;
	JForUpdateExpression update;
	JExpression expression;
	JStatement statement;
	

	protected JForStatement(int line, JForInitExpression init, JExpression expression, JForUpdateExpression update, JStatement statement) 
	{
		super(line);
		this.init = init;
		this.update = update;
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
        init.writeToStdOut(p);
        p.printf("<JExpression>\n");
        p.indentRight();
        expression.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JExpression>\n");
        update.writeToStdOut(p);
        p.printf("<JStatement>\n");
        p.indentRight();
        statement.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JStatement>\n");
        p.indentLeft();
        p.printf("</JForStatement>\n");

	}

}

class JForInitExpression extends JExpression
{
	JStatement expression;

	protected JForInitExpression(int line, JStatement expression) 
	{
		super(line);
		this.expression = expression;
	}

	@Override
	public JExpression analyze(Context context) {
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
		p.printf("<JForInitExpression line=\"%d\">\n", line());
        p.indentRight();
        expression.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JForInitExpression\n");
		
	}
	
}

class JForUpdateExpression extends JExpression
{
	JStatement expression;
	
	protected JForUpdateExpression(int line, JStatement expression)
	{
		super(line);
		this.expression = expression;
	}

	@Override
	public JExpression analyze(Context context) {
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
		p.printf("<JForUpdateExpression line=\"%d\">\n", line());
        p.indentRight();
        expression.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JForUpdateExpression\n");		
	}
	
}