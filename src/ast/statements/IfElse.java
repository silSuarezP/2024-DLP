package ast.statements;

import ast.AbstractStatement;
import ast.Expression;
import ast.Statement;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class IfElse extends AbstractStatement {

    private Expression condition;
    private List<Statement> ifBody = new ArrayList<Statement>();
    private List<Statement> elseBody = new ArrayList<Statement>();

    public IfElse(int line, int column, Expression expr, List<Statement> ifBody) {
        super(line, column);
        this.condition = expr;
        this.ifBody = new ArrayList<Statement>(ifBody);
    }

    public IfElse(int line, int column, Expression expr, List<Statement> ifBody, List<Statement> elseBody) {
        super(line, column);
        this.condition = expr;
        this.ifBody = new ArrayList<Statement>(ifBody);
        this.elseBody = new ArrayList<Statement>(elseBody);
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }

    public List<Statement> getIfBody() {
        return ifBody;
    }

    @Override
    public String toString() {
        return "If-Else{ condition:" + condition + "\nif-Body: " + ifBody + "\nelse-Body: " + elseBody + " }";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
