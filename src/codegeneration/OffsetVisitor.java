package codegeneration;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.expressions.literals.CharLiteral;
import ast.expressions.literals.DoubleLiteral;
import ast.expressions.literals.IntLiteral;
import ast.statements.*;
import ast.types.*;

public class OffsetVisitor extends AbstractCGVisitor<Void, Void> {


    /**
     *
     * VarDefinition
     * FuncDefinition
     * FunctionType
     * RecordType
     *
     *
     * ***************** GLOBAL VARIABLES (not including itself)
     *  &global = S(numberOfBytes(types(previous global variables not including itself)))
     *
     *  (P) VarDefinition: definition -> type ID
     *  (R) // globalBytesSum is a global variable initialized to 0
     *      if (definition.scope == 0) {
     *          definition.offset = globalBytesSum;
     *          globalBytesSum += type.numberOfBytes();
     *      }
     *
     *
     *
     * ***************** LOCAL VARIABLES (including itself)
     *  &local = BP - S(numberOfBytes(types(previous local variables including itself)))
     *
     *  (P) FunctionDefinition: definition -> type ID definition* statement*
     *  (R) int localBytesSum = 0;
     *      for (VarDefinition vd : definition*) {
     *          localBytesSum = vd.type.numberOfBytes();
     *          vd.offset = -localBytesSum;
     *      }
     *
     *
     *
     * ***************** PARAMETERS (parameters on the right not including itself)
     *  &param = BP + 4 + S(numberOfBytes(types(params on the right not including itself)))
     *
     *  (P) FunctionType: type1 -> type2 definition*
     *  (R) int paramBytesSum = 0;
     *      for (int i = definition*.size()-1; i >= 0; i++) {
     *          VarDefinition vd = definition*.get(i);
     *          vf.offset = paramBytesSum + 4;
     *          paramBytesSum = vf.type.numberOfBytes();
     *      }
     *
     *
     *
     * ***************** STRUCT
     *  &field = S(numberOfBytes(types(previous fields not including itself)))
     *
     *  (P) Struct: ID -> field*
     *  (R) int fieldBytesSum = 0;
     *      for (RecordFieldType rf : field*) {
     *          rf.offset = fieldBytesSum;
     *          fieldBytesSum += rf.type.numberOfBytes();
     *      }
     *
     */


    private int globalBytesSum = 0;

    /**
     *  (P) VarDefinition: definition -> type ID
     *  (R) // globalBytesSum is a global variable initialized to 0
     *      if (definition.scope == 0) {
     *          definition.offset = globalBytesSum;
     *          globalBytesSum += type.numberOfBytes();
     *      }
     */
    @Override
    public Void visit(VarDefinition varDefinition, Void param) {
        if (varDefinition.getScope() == 0) {
            varDefinition.setOffset(globalBytesSum);
            globalBytesSum += varDefinition.getOffset();
        }

        return null;
    }


    /**
     *  (P) FunctionType: type1 -> type2 definition*
     *  (R) int paramBytesSum = 0;
     *      for (int i = definition*.size()-1; i >= 0; i++) {
     *          VarDefinition vd = definition*.get(i);
     *          vf.offset = paramBytesSum + 4;
     *          paramBytesSum += vf.type.numberOfBytes();
     *      }
     */
    @Override
    public Void visit(FunctionType functionType, Void param) {
        int paramBytesSum = 0;

        for (int i = functionType.getParams().size()-1; i >= 0; i++) {
            VarDefinition vd = functionType.getParams().get(i);
            vd.setOffset(paramBytesSum + 4);
            paramBytesSum += vd.getType().numberOfBytes();
        }

        return null;
    }


    /**
     *  (P) FunctionDefinition: definition -> type ID definition* statement*
     *  (R) int localBytesSum = 0;
     *      for (VarDefinition vd : definition*) {
     *          localBytesSum = vd.type.numberOfBytes();
     *          vd.offset = -localBytesSum;
     *      }
     */
    @Override
    public Void visit(FunctionDefinition funcDefinition, Void param) {
        int localBytesSum = 0;

        for (VarDefinition vd : funcDefinition.getType().getParams()) {
            localBytesSum = vd.getType().numberOfBytes();
            vd.setOffset(-localBytesSum);
        }

        return null;
    }


    /**
     *  (P) Struct: ID -> field*
     *  (R) int fieldBytesSum = 0;
     *      for (RecordFieldType rf : field*) {
     *          rf.offset = fieldBytesSum;
     *          fieldBytesSum += rf.type.numberOfBytes();
     *      }
     */
    @Override
    public Void visit(Struct struct, Void param) {
        int fieldBytesSum = 0;

        for (RecordFieldType rf : struct.getRecords()) {
            rf.setOffset(fieldBytesSum);
            fieldBytesSum += rf.getType().numberOfBytes();
        }
        return null;
    }





}
