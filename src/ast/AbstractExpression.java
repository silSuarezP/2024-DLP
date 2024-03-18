package ast;

public class AbstractExpression extends AbstractASTNode implements Expression {

    private boolean lValue;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }


    @Override
    public boolean getlValue() {
        return this.lValue;
    }

    @Override
    public void setlValue(boolean lValue) {
        this.lValue = lValue;
    }
}
