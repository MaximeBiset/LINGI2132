package jminusminus;

import static jminusminus.CLConstants.GOTO;

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
	}

	public JAST analyze(Context context) {
		for(JStatement jstatement : forInit) 
			jstatement = (JStatement) jstatement.analyze(context);
			
		if(expression != null) {
			expression = (JExpression) expression.analyze(context);
			expression.type().mustMatchExpected(line(), Type.BOOLEAN);
		}
		
		for(JStatement jstatement : forUpdate)
			jstatement = (JStatement) jstatement.analyze(context);
		
		
		statement = (JStatement) statement.analyze(context);
		return this;
	}

	
	public void codegen(CLEmitter output) {
		for(JStatement jstatement: forInit)
			jstatement.codegen(output);
		
        String test = output.createLabel();
        String out = output.createLabel();
        output.addLabel(test);
        if (expression != null)
        	expression.codegen(output, out, false);
        
        for(JStatement jstatement: forUpdate)
        	jstatement.codegen(output);
        
        statement.codegen(output);
        output.addBranchInstruction(GOTO, test);
        output.addLabel(out);

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