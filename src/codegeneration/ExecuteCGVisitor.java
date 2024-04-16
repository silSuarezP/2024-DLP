package codegeneration;

public class ExecuteCGVisitor {

    /**
     *
     * ------ STATEMENTS
     * - read
     * - write
     * - assignment
     *
     *
     * ------ DEFINITIONS
     * - varDefinition
     * - functionDefinition
     *
     *
     * ------ PROGRAM
     * - program
     *
     * execute [[ Read: statement -> expression ]] =
     *      address [[ expression ]]
     *      <in> expression.type.suffix()
     *      <store> expression.type.suffix()
     *
     *
     * execute [[ Write: statement -> expression ]] =
     *      address [[ expression ]]
     *      <out> expression.type.suffix()
     *
     *
     * execute [[ Assignment: statement -> expression1 expression2 ]] =
     *      address [[ expression1 ]]
     *      value [[ expression2 ]]
     *      <store> expression1.type.suffix()
     *
     *
     * execute [[ Program: program -> definition* ]] =
     *      <call main>
     *      <halt>
     *      definition*.forEach(def -> execute [[ def ]]);
     *
     *
     * execute [[ VarDefinition: definition -> type ID ]] =
     *      <' *> type.toString() ID < (offset > definition.offset < ) >
     *
     *
     * execute [[ FunctionDefinition: definition -> type ID definition* statement* ]] =
     *      ID <:>
     *      <' * parameters>
     *      execute [[ type ]]
     *
     *
     *
     *
     *
     */
}
