package ast;

public interface Definition extends ASTNode {

    int getScope();
    void setScope(int scope);

    Type getType();

    String getName();

    int getOffset();
    void setOffset(int offset);

}
