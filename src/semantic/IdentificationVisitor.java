package semantic;

import ast.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Variable;
import ast.types.ErrorType;
import symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {


    private SymbolTable st = new SymbolTable();


    @Override
    public Void visit(VarDefinition varDefinition, Void param) {
        if (!st.insert(varDefinition))
            new ErrorType(varDefinition.getLine(), varDefinition.getColumn(),
                    "There already exists a definition for variable " + varDefinition.getName());
        else
            varDefinition.getType().accept(this, param);
        return null;
    }


    @Override
    public Void visit(FunctionDefinition funcDefinition, Void param) {
        if (!st.insert(funcDefinition))
            new ErrorType(funcDefinition.getLine(), funcDefinition.getColumn(),
                    "There already exists a definition for function " + funcDefinition.getName());
        else {
            st.set();

            funcDefinition.getType().accept(this, param);
            funcDefinition.getFuncBody().forEach(p -> p.accept(this, param));

            st.reset();
        }
        return null;
    }


    @Override
    public Void visit(Variable variable, Void param) {
        Definition definition = st.find(variable.getName());
//        if (definition == null)
//            new ErrorType(variable.getLine(),variable.getColumn(),"Variable not defined.");
        variable.setDefinition(definition);
        return null;
    }
}
