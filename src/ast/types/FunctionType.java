package ast.types;

import ast.Type;
import ast.definitions.VarDefinition;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FunctionType extends AbstractType {

    private List<VarDefinition> vars;
    private Type returnType;

    private int bytesOfParams = 0;

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


    @Override
    public Type parenthesis(List<Type> argTypes, int line, int column) {
        if (argTypes.size() == getParams().size()) {
            for (int i = 0; i < argTypes.size(); i++) {
                if (!(argTypes.get(i).toString().equals(this.getParams().get(i).getType().toString()))) {
                    return new ErrorType(line, column, String.format(
                            "The types of %s do not match the parameters for invocation of function.", argTypes
                    ));
                }
            }
        }

        return this.returnType;
    }

    public void setBytesOfParams(int offset){
        this.bytesOfParams = offset;
    }

    public int getBytesOfParams(){
        return this.bytesOfParams;
    }

}
