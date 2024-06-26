package ast.definitions;

import ast.Statement;
import ast.Type;
import ast.types.FunctionType;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDefinition extends AbstractDefinition {

    private FunctionType type;
    private String name;
    private List<Statement> funcBody;

    public FunctionDefinition(int line, int column, FunctionType type, String name, List<Statement> body) {
        super(line, column);
        this.type = type;
        this.name = name;
        this.funcBody = new ArrayList<Statement>(body);
    }

    public List<Statement> getFuncBody() {
        return this.funcBody;
    }

    @Override
    public FunctionType getType() {
        return this.type;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        String str = "FuncDefinition { type : " + this.type + " name: " + this.name;
        if (!this.funcBody.isEmpty()) {
            str += "\n\tstatements: " + this.funcBody.toString();
        }
        return str+=" }\n";
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}