package ast.types;

import ast.AbstractASTNode;
import ast.Type;
import semantic.Visitor;

public class AbstractType extends AbstractASTNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }


}
