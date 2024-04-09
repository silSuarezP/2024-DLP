package ast.types;

import ast.Type;
import errorhandler.ErrorHandler;
import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Struct extends AbstractType {

    private List<RecordFieldType> records;

    public Struct(int line, int column, List<RecordFieldType> records) {
        super(line, column);
        this.records = new ArrayList<RecordFieldType>(records);

        checkFields(this.records);
    }

    public List<RecordFieldType> getRecords() {
        return records;
    }

    private void checkFields(List<RecordFieldType> recs) {
        List<String> aux = new ArrayList<String>();
        for (RecordFieldType rf : recs) {
            if (aux.contains(rf.getName())) {
                new ErrorType(rf.getLine(), rf.getColumn(),
                        String.format("There already exists a field named '%s", rf.getName()));
            }
            else
                aux.add(rf.getName());
        }
    }

    @Override
    public String toString() {
        return "Struct { " + this.records + " }";
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type dot(String field, int line, int column) {
        for (RecordFieldType f: this.records) {
            if (f.getName().equals(field))
                return f.getType();
        }
        return new ErrorType(line, column, String.format(
                "Field %s is not defined in the struct.", field
        ));
    }
}
