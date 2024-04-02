package ast;

public class AbstractStatement extends AbstractASTNode implements Statement {


    public Type returnType;

    public AbstractStatement(int line, int column) {
        super(line, column);
    }
}
