package ast.expressions;

import ast.AbstractASTNode;
import ast.AbstractExpression;
import ast.Expression;
import semantic.Visitor;

public class FieldAccess extends AbstractExpression {

    private Expression struct;
    private String fieldName;

    public FieldAccess(int line, int column, Expression struct, String fieldName) {
        super(line, column);
        this.struct = struct;
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Expression getStruct() {
        return this.struct;
    }

    @Override
    public String toString() {
        return "FieldAccess { " + this.struct + "." + this.fieldName + " }\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
