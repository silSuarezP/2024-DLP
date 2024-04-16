package ast;

public interface Expression extends ASTNode {

    boolean getlValue();
    void setlValue(boolean lValue);
    public Type getType();
    public void setType(Type type);
}
