package ast.definitions;

import ast.Statement;
import ast.types.Type;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends AbstractDefinition {

    private Type type;
    private Type returnType;
    private String name;
    private List<Statement> funcBody;

    public FunctionDefinition(int line, int column, Type type, String name, List<Statement> body) {
        super(line, column);
        this.returnType = returnType;
        this.type = type;
        this.name = name;
        this.funcBody = new ArrayList<Statement>(body);
    }

    @Override
    public Type getType() {
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
            str += " statements: " + this.funcBody;
        }
        return str+=" }\n";
    }
}