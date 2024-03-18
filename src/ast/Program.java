package ast;

import semantic.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Program extends AbstractASTNode {


    List<Definition> defs;


    public Program(int line, int column, List<Definition> defs) {
        super(line, column);
        this.defs = new ArrayList<Definition>(defs);
    }

    public List<Definition> getDefinitions() {
        return defs;
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }
}
