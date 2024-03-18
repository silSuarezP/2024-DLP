package ast;

import semantic.Visitor;

public interface ASTNode {

    int getLine();

    int getColumn();

    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param);
}
