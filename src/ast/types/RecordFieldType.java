package ast.types;

import ast.AbstractASTNode;

public class RecordFieldType extends AbstractType {

    private Type type;
    private String name;

    public RecordFieldType(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return "RecordField { type: " + this.type + ", name: " + this.name + " }" ;
    }

}