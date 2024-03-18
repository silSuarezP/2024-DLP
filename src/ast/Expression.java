package ast;

public interface Expression extends ASTNode {

    boolean getlValue();
    void setlValue(boolean lValue);
}
