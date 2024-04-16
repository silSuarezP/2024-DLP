package codegeneration;

public class ValueCGVisitor {
    /**
     * ------ EXPRESSIONS
     * - integer literal
     * - character literal
     * - double literal
     * - variable
     * - arithmetic
     * - comparison
     * - logical
     * - cast
     *
     *
     * value [[ IntLiteral: expression -> INT_CONSTANT ]] =
     *      <pushi > INT_CONSTANT
     *
     *
     * value [[ CharLiteral: expression -> CHAR_CONSTANT ]] =
     *      int aux = expression.value
     *      <pushb > aux
     *
     *
     * value [[ DoubleLiteral: expression -> REAL_CONSTANT ]] =
     *      <pushf > REAL_CONSTANT
     *
     *
     * value [[ Variable: expression -> ID ]] =
     *      address [[ expression ]]
     *      <load> expression.type.suffix
     *
     *
     * value [[ Arithmetic: expression1 -> expression2 expression3 ]] =
     *      value [[ expression2 ]]
     *      expression2.type.convertTo(expression1.type);
     *      value [[ expression3 ]]
     *      expression3.type.convertTo(expression1.type);
     *
     *      switch(expression1.operator) {
     *          case "+":
     *              <add > expression1.type.suffix
     *              break;
     *          case "-":
     *              <sub > expression1.type.suffix
     *              break;
     *          case "*":
     *              <mul > expression1.type.suffix
     *              break;
     *          case "/":
     *              <div > expression1.type.suffix
     *              break;
     *      }
     *
     *
     * value [[ Comparison: expression1 -> expression2 expression3 ]] =
     *      Type superType = expression2.type.superType(expression1.type);
     *      value [[ expression2 ]]
     *      expression2.type.convertTo(superType);
     *      value [[ expression3 ]]
     *      expression3.type.convertTo(superType);
     *
     *      switch(expression1.operator) {
     *          case ">":
     *              <gt> expression1.type.suffix()
     *              break;
     *          case "<":
     *              <lt> expression1.type.suffix()
     *              break;
     *          case ">=":
     *              <ge> expression1.type.suffix()
     *              break;
     *          case "<=":
     *              <le> expression1.type.suffix()
     *              break;
     *          case "==":
     *              <eq> expression1.type.suffix()
     *              break;
     *          case "!=":
     *              <ne> expression1.type.suffix()
     *              break;
     *      }
     *
     *
     * // we dont need to check if expression2 and expression3 are integers, because it is already checked
     * value [[ Logical: expression1 -> expression2 (&& | ||) expression3 ]] =
     *      value [[ expression2 ]]
     *      value [[ expression3 ]]
     *      switch(expression1.operator) {
     *          case "&&":
     *              <and>
     *              break;
     *          case "||":
     *              <or>
     *              break;
     *      }
     *
     *
     * value [[ Cast: expression1 -> type expression2 ]] =
     *      expression2.type.convertTo(type);
     *
     *
     */
}
