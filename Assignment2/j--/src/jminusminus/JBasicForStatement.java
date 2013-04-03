package jminusminus;

import static jminusminus.CLConstants.GOTO;

import java.util.ArrayList;

public class JBasicForStatement extends JStatement {
	
	ArrayList<JStatement> forInit;
	ArrayList<JStatement> forUpdate;
	JExpression expression;
	JStatement statement;
	JBlock block;
	

	protected JBasicForStatement(int line, ArrayList<JStatement> forInit, JExpression expression, ArrayList<JStatement> forUpdate, JStatement statement) 
	{
		super(line);
		
		
		this.forInit = forInit;
		this.forUpdate = forUpdate;
		this.statement = statement;
		this.expression = expression;
	}

	public JStatement analyze(Context context) {
		for(JStatement jstatement : forInit) {
			jstatement = (JStatement) jstatement.analyze(context);
		}
			
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
		String test = output.createLabel();
        String out = output.createLabel();
        
		for(JStatement jstatement: forInit)
			jstatement.codegen(output);
		
        
        output.addLabel(test);
        if (expression != null)
        	expression.codegen(output, out, false);
        
        statement.codegen(output);
        for(JStatement jstatement: forUpdate)
        	jstatement.codegen(output);
        
        output.addBranchInstruction(GOTO, test);
        output.addLabel(out);

	}

	public ArrayList<JStatement> getForInit() {
		return this.forInit;
	}
	public ArrayList<JStatement> getForUpdate() {
		return this.forUpdate;
	}
	
	public JExpression getExpression() {
		return this.expression;
	}
	
	public JStatement getStatement() {
		return this.statement;
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