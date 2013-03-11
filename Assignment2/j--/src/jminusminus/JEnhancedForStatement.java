package jminusminus;

public class JEnhancedForStatement extends JStatement {
	
	JFormalParameter param;
	JExpression expression;
	

	protected JEnhancedForStatement(int line, JFormalParameter param, JExpression expression)
	{
		super(line);
		this.param = param;
		this.expression = expression;
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
        p.printf("<JEnhancedForStatement line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<JFormalParameter>\n");
        p.indentRight();
        param.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JFormalParameter>\n");
        p.printf("<JExpressiont>\n");
        p.indentRight();
        expression.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JExpression>\n");
        p.indentLeft();
        p.printf("</JEnhancedForStatement>\n");

	}

}
