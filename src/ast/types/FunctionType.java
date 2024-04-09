package ast.types;

import ast.Type;
import ast.definitions.VarDefinition;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType {

    private List<VarDefinition> vars;
    private Type returnType;

    public FunctionType(int line, int column, Type returnType, List<VarDefinition> vars) {
        super(line, column);
        this.returnType = returnType;
        if (vars == null)
            this.vars = new ArrayList<VarDefinition>();
        else
            this.vars = new ArrayList<VarDefinition>(vars);
    }

    public List<VarDefinition> getParams() {
        return this.vars;
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public String toString() {
        return "FunctionType { returnType: " + this.returnType + ", parameters:" + this.vars + " }";
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }


}
