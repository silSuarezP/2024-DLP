package codegeneration;

public class AddressCGVisitor {

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
     *
     */
}
