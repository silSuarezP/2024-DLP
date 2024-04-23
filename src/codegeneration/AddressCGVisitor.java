package codegeneration;

import ast.definitions.VarDefinition;
import ast.expressions.Variable;

public class AddressCGVisitor extends AbstractCGVisitor<Void, Void> {

    /**
     *
     * ------ EXPRESSIONS
     * - variable
     *
     * address [[ Variable: expression -> ID ]] =
     *      // if the variable is local, its scope is > 0
     *      if (expression.definition.scope > 0) {
     *          <push bp>
     *          <pushi > expression.definition.offset
     *          <addi >
     *      }
     *      // if the variable is global, its scope is = 0
     *      else {
     *          <pusha > expression.definition.offset
     *      }
     *
     ****************+ LAB12
     * ------ EXPRESSIONS
     * - indexing
     * - fieldAccess
     *
     * value [[ Indexing: expression1 -> expression2 expression3 ]]:
     *      address [[ expression2 ]]
     *      value [[ expression3 ]]
     *      <pushi > expression1.type.numberOFBytes()
     *      <muli>
     *      <addi>
     *
     *
     * value [[ FieldAccess -> expression1: expression2 ID ]]:
     *      address [[ expression2 ]]
     *      <pushi > expression2.type.getField(ID).offset
     *      <addi >
     *
     *
     *
     *
     */

    private ValueCGVisitor valueVisitor;

    public AddressCGVisitor(CodeGenerator cg, ValueCGVisitor valueCGVisitor) {
        super(cg);
        this.valueVisitor = valueVisitor;
    }

    public void setValueVisitor(ValueCGVisitor valueVisitor) {
        this.valueVisitor = valueVisitor;
    }

    @Override
    public Void visit(Variable variable, Void param) {
        if(variable.getDefinition().getScope() == 0) {
            cg.pushAddress(variable.getDefinition().getOffset());
        }
        else {
            cg.pushBP();
            cg.pushInt(((VarDefinition)variable.getDefinition()).getOffset());
            cg.addIntegers();
        }

        return null;
    }
}
