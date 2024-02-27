package ast;

public class AbstractASTNode implements ASTNode {

    int line;
    int column;

    public AbstractASTNode(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.getColumn();
    }

}