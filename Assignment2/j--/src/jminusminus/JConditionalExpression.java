package jminusminus;

import static jminusminus.CLConstants.GOTO;

public class JConditionalExpression extends JExpression {

	private JExpression condition;
	private JExpression thenPart;
	private JExpression elsePart;
	private String operator;
	protected JConditionalExpression(int line, JExpression condition, JExpression thenPart, JExpression elsePart) 
	{
		super(line);
		this.operator = "?";
		this.condition = condition;
		this.thenPart = thenPart;
		this.elsePart = elsePart;
	}

	public JExpression analyze(Context context) 
	{	
		condition = (JExpression)condition.analyze(context);
		thenPart = (JExpression)thenPart.analyze(context);
		elsePart = (JExpression)elsePart.analyze(context);
		condition.type().mustMatchExpected(line(), Type.BOOLEAN);
        thenPart.type().mustMatchExpected(line(),elsePart.type());
        type = thenPart.type();
		return this;
	}

	public void codegen(CLEmitter output) 
	{	
        String elseLabel = output.createLabel();
		String endLabel = output.createLabel();
		condition.codegen(output, elseLabel, false);
		thenPart.codegen(output);
		output.addBranchInstruction(GOTO, endLabel);
		output.addLabel(elseLabel);
		elsePart.codegen(output);
		output.addLabel(endLabel);
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
