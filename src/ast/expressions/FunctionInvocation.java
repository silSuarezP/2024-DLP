package ast.expressions;

import ast.*;
import semantic.Visitor;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

public class FunctionInvocation extends AbstractExpression implements Statement {

    private Variable function;
    private List<Expression> params;
    private Type returnType;

    public FunctionInvocation(int line, int column, String name, List<Expression> params) {
        super(line, column);

        this.function = new Variable(line, column, name);

        if (params != null)
            this.params = new ArrayList<Expression>(params);
        else
            this.params = new ArrayList<Expression>();
    }

    public Variable getFunction() {
        return this.function;
    }

    public List<Expression> getParams() {
        return this.params;
    }

    @Override
    public String toString() {
        return "FunctionInvocation { " + this.function.toString() + "(" + this.params + ") }\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public void setReturnType(Type type) {
        this.returnType = type;
    }

    @Override
    public Type getReturnType() {
        return returnType;
    }
}
