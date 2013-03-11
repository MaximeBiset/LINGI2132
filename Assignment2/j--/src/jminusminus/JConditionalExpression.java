package jminusminus;

public class JConditionalExpression extends JExpression {

	private JExpression condition;
	private JExpression thenPart;
	private JExpression elsePart;
	protected JConditionalExpression(int line, JExpression condition, JExpression thenPart, JExpression elsePart) 
	{
		super(line);
		this.condition = condition;
		this.thenPart = thenPart;
		this.elsePart = elsePart;
	}

	@Override
	public JExpression analyze(Context context) 
	{
		return this.analyze(context);
	}

	@Override
	public void codegen(CLEmitter output) 
	{
		this.codegen(output);

	}

	public void writeToStdOut(PrettyPrinter p)
	{	
        p.printf("<JConditionalExpression line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<TestExpression>\n");
        p.indentRight();
        condition.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TestExpression>\n");
        if (thenPart != null) {
	        p.printf("<ThenClause>\n");
	        p.indentRight();
	        thenPart.writeToStdOut(p);
	        p.indentLeft();
	        p.printf("</ThenClause>\n");
            p.printf("<ElseClause>\n");
            p.indentRight();
            elsePart.writeToStdOut(p);
            p.indentLeft();
            p.printf("</ElseClause>\n");
        }
        p.indentLeft();
        p.printf("</JConditionalExpression>\n");

	}

}
