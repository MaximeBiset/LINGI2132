package jminusminus;

import java.util.ArrayList;

public class JEnhancedForStatement extends JStatement {
	
	
	JFormalParameter param;
	JExpression expression;
	JStatement statement;
	
	
	JBasicForStatement basicForStatement;
	private int blah = 0;
	
	

	protected JEnhancedForStatement(int line, JFormalParameter param, JExpression expression, JStatement statement)
	{
		super(line);
		this.param = param;
		this.expression = expression;
		this.statement = statement;
		
		// casting enhanced one into basic one
		
		//ForInit (Iterator i + temporary variable  (...) = tab[i])
		ArrayList<JStatement> forInit = new ArrayList<JStatement>();
		JVariable index = new JVariable(line, "isefsefse");
		JVariable fparam = new JVariable(line, param.name());
		ArrayList<JVariableDeclarator> vars = new ArrayList<JVariableDeclarator>(2);
		vars.add(new JVariableDeclarator(line, index.name(), Type.INT, new JLiteralInt(line, "0"), index));
		vars.add(new JVariableDeclarator(line, param.name(), param.type(), null, fparam));
		forInit.add(new JVariableDeclaration(line, new ArrayList<String>(), vars));
		
		//Condition
		JExpression condition = new JLogicalNotOp(line, new JEqualOp(line, index, new JFieldSelection(line, expression, "length")));

		//forUpdate (Update iterator i & temporary variable )
		ArrayList<JStatement> forUpdate = new ArrayList<JStatement>();
		// incrementing i ...
		forUpdate.add(new JPreIncrementOp(line, index));
		((JExpression) forUpdate.get(0)).isStatementExpression = true;
		// assigning temporary variable
		forUpdate.add(new JAssignOp(line, fparam, new JArrayExpression(line, expression, index)));
		((JExpression) forUpdate.get(1)).isStatementExpression = true;
		
		this.basicForStatement = new JBasicForStatement(line,forInit , condition, forUpdate, statement);
		//blah += 1;
	}

	public JStatement analyze(Context context) {
		basicForStatement = (JBasicForStatement) basicForStatement.analyze(context);
		return this;
	}

	public void codegen(CLEmitter output) {
        basicForStatement.codegen(output);
	}

	public void writeToStdOut(PrettyPrinter p)
	{
        p.printf("<JEnhancedForStatement line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<JFormalParameter>\n");
        p.indentRight();
        param.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JFormalParameter>\n");
        p.printf("<JExpression>\n");
        p.indentRight();
        expression.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JExpression>\n");
        p.printf("<JStatement>\n");
        p.indentRight();
        statement.writeToStdOut(p);
        p.indentLeft();
        p.printf("</JStatement>\n");
        p.indentLeft();
        p.printf("</JEnhancedForStatement>\n");

	}

}
