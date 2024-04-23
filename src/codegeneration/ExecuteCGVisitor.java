package codegeneration;

import ast.Definition;
import ast.Program;
import ast.Statement;
import ast.definitions.FunctionDefinition;
import ast.definitions.VarDefinition;
import ast.statements.Assignment;
import ast.statements.Read;
import ast.statements.Write;
import ast.types.FunctionType;

import java.util.ArrayList;
import java.util.List;

public class ExecuteCGVisitor extends AbstractCGVisitor<ExecuteCGDTO, Void> {

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
     * execute [[ While: statement -> expression statement* ]] =
     *      String conditionLabel = cg.nextLabel(),
     *              endLabel = cg.nextLabel();
     *      conditionLabel<:>
     *      value [[ expression ]]
     *      <jz > exitLabel
     *      statement*.forEach(st -> execute [[ st ]])
     *      <jmp > conditionLabel
     *      exitLabel<:>
     *
     *
     * execute [[ IfElse: statement1 -> expression statement2+ statement3* ]]
     *      String elseLabel = cg.nextLabel(),
     *              exitLabel = cg.nextLabel();
     *          // if condition
     *      value [[ expression ]]
     *      <jz > elseLabel
     *          // if body
     *      statement2+.forEach(st -> execute [[ st ]])
     *      elseLabel<:>
     *          // else body
     *      statement3*.forEach(st -> execute [[ st ]])
     *      exitLabel<:>
     *
     *
     */


    private AddressCGVisitor addressVisitor;
    private ValueCGVisitor valueVisitor;

    public ExecuteCGVisitor(CodeGenerator cg) {
        super(cg);
        this.valueVisitor = new ValueCGVisitor(cg);
        this.addressVisitor = new AddressCGVisitor(cg, valueVisitor);
    }

    public void setValueVisitor(ValueCGVisitor v) {
        this.valueVisitor = v;
    }
    public void setAddressVisitor(AddressCGVisitor a)  {
        addressVisitor = a;
    }

    @Override
    public Void visit(Read readSt, ExecuteCGDTO param) {
        cg.writeLineNumber(readSt.getLine());

        cg.generateComment("Read");

        readSt.getExpr().accept(this.addressVisitor, null);
        cg.read(readSt.getExpr().getType());

        return null;
    }

    @Override
    public Void visit(Write writeSt, ExecuteCGDTO param) {
        cg.writeLineNumber(writeSt.getLine());

        cg.generateComment("Write");

        writeSt.getExpr().accept(this.valueVisitor, null);
        cg.write(writeSt.getExpr().getType());

        return null;
    }


    @Override
    public Void visit(Assignment assign, ExecuteCGDTO param) {

        cg.writeLineNumber(assign.getLine());
        cg.generateComment("Assignment");

        assign.getLeft().accept(this.addressVisitor, null);
        assign.getRight().accept(this.valueVisitor, null);

        cg.store(assign.getLeft().getType());
        return null;
    }

    @Override
    public Void visit(VarDefinition var, ExecuteCGDTO param) {
        cg.generateComment("" + var.getType() + " " + var.getName() + " (offset " + var.getOffset() +")");
        return null;
    }

    @Override
    public Void visit(FunctionDefinition funcDefinition, ExecuteCGDTO param) {
        cg.newFunction(funcDefinition);

        cg.generateComment("Parameters:");
        funcDefinition.getType().accept(this, null);

        int bytesLocal = 0,
                bytesReturn = 0,
                bytesParam = 0;


        // local variables
        cg.generateComment("Local variables:");
        List<VarDefinition> varDefs = new ArrayList<VarDefinition>();
        for (Statement st : funcDefinition.getFuncBody()) {
            if (st instanceof VarDefinition) {
                varDefs.add((VarDefinition) st);
                st.accept(this, null);
            }
        }

        if (!varDefs.isEmpty())
            bytesLocal = - varDefs.get(varDefs.size()-1).getOffset();

        cg.allocateMem(bytesLocal);

        FunctionType funcType = (FunctionType)funcDefinition.getType();
        bytesParam = funcType.getBytesOfParams();

        bytesReturn = funcDefinition.getType().numberOfBytes();

        ExecuteCGDTO paramDTO = new ExecuteCGDTO(bytesReturn, bytesLocal, bytesParam);

        funcDefinition
                .getFuncBody()
                .stream()
                .filter(s -> !(s instanceof VarDefinition))
                .forEach(st -> st.accept(this, paramDTO));


        if (bytesReturn == 0)
            //bytes to return, bytes local variables, bytes arguments
            cg.ret(bytesReturn, bytesLocal, bytesParam);

        return null;
    }

    @Override
    public Void visit(Program program, ExecuteCGDTO param) {

        cg.mainProgram();

        cg.generateComment("Global variables:");

        // variable definitions
        for (Definition definition : program.getDefinitions()) {
            if (definition instanceof VarDefinition)
                definition.accept(this, null);
        }

        cg.generateComment("Functions");

        // function definitions
        for (Definition definition : program.getDefinitions()) {
            if (definition instanceof FunctionDefinition)
                definition.accept(this, null);
        }

        cg.writeToFile();

        return null;
    }

}
