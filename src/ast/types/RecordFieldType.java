package ast.types;

import ast.Type;
import semantic.Visitor;

public class RecordFieldType extends AbstractType {

    private Type type;

    public String getName() {
        return name;
    }

    private String name;

    public RecordFieldType(int line, int column, Type type, String name) {
        super(line, column);
        this.type = type;
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RecordField { type: " + this.type + ", name: " + this.name + " }" ;
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }



}