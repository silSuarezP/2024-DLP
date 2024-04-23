package codegeneration;

import ast.Type;
import ast.definitions.FunctionDefinition;

import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    private FileWriter outputFile;
    private int labels = 0;

    public String nextLabel(){
        return "label" + this.labels++;
    }

    public CodeGenerator(String fileName, String sourceName){
        try {
            this.outputFile = new FileWriter(fileName);
            writeLineWithoutTab(String.format("#source\t\"%s\"\n", sourceName));
        } catch (IOException e){

        }
    }

    private void writeLine(String line){
        try {
            outputFile.write("\t" + line + "\n");
        } catch (IOException e) {

        }
    }

    public void writeLineWithoutTab(String line) {
        try {
            outputFile.write( line + "\n");
        } catch (IOException e) {

        }
    }


    public void writeLineNumber(int line) {
        writeLineWithoutTab("\n#line\t" + line);
    }

    public void pushAddress(int i) {
        writeLine("pusha " + i+ "\n");
    }

    public void pushBP(){
        writeLine("push bp");
    }

    public void pushInt(int value) {
        writeLine("pushi\t" + value);
    }

    public void pushByte(int value) {
        writeLine("pushb\t" + value);
    }

    public void pushFloat(double value) {
        writeLine("pushf\t" + value);
    }


    public void addIntegers() {
        writeLine("addi");
    }

    public void convert(Type from, Type to) {
        String convert = from.convertTo(to);
        if (convert != null)
            writeLine(convert);
    }

    public void arithmetic(String operator, Type type) {
        String o = "";
        switch (operator){
            case "+":
                o = "add";
                break;
            case "-":
                o = "sub";
                break;
            case "*":
                o = "mul";
                break;
            case "/":
                o = "div";
                break;
            default:
                return;
        }
        String suffix = type.suffix();
        writeLine(o + suffix);
    }

    public void compare(String operand, Type type) {
        String compare = "";
        switch (operand){
            case ">":
                compare = "gt";
                break;
            case ">=":
                compare = "ge";
                break;
            case "==":
                compare = "eq";
                break;
            case "!=":
                compare = "ne";
                break;
            case "<":
                compare = "lt";
                break;
            case "<=":
                compare = "le";
                break;
            default:
                return;
        }
        String suffix = type.suffix();
        writeLine(compare + suffix);
    }

    public void logical(String operand) {
        switch (operand){
            case "&&":
                writeLine("and");
                break;
            case "||":
                writeLine("or");
                break;
            default:
                return;
        }
    }


    public void generateComment(String s) {
        writeLine(String.format("' * %s", s));
    }


    public void load(Type type) {
        writeLine("load" + type.suffix());
    }


    public void read(Type type) {
        writeLine("in" + type.suffix());
        writeLine("store" + type.suffix());
    }

    public void write(Type type) {
        writeLine("out" + type.suffix());
    }

    public void store(Type type) {
        writeLine("store" + type.suffix());
    }

    public void newFunction(FunctionDefinition funcDefinition) {
        writeLineNumber(funcDefinition.getLine());
        writeLineWithoutTab(String.format("\n %s :", funcDefinition.getName()));
    }

    public void allocateMem(int memory) {
        writeLine(String.format("enter\t%d", memory));
    }

    public void ret(int bRet, int bLocals, int bArgs){
        writeLine(String.format("ret %d, %d, %d", bRet, bLocals, bArgs));
    }


    public void mainProgram() {
        writeLineWithoutTab("\n' Invocation to the main function");
        writeLineWithoutTab("call main\nhalt\n");
    }

    public void writeToFile() {
        try {
            outputFile.flush();
            outputFile.close();
        } catch (IOException e){}
    }


}
