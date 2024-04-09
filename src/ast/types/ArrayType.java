package ast.types;

import ast.Type;
import semantic.Visitor;

public class ArrayType extends AbstractType {

    private Type type;
    private int size;


    public ArrayType(int line, int column, Type type, int size) {
        super(line, column);
        this.type = type;
        this.size = size;
    }


    /**
     * we need a factory in order to create the array because if we have a n-dimensional array (being n greater than 1),
     * then the constructor is going to create the array with wrong sizes (first parent, second child), and we need to take
     * first the child and then the parent
     *
     * so for this, we need to create a linkedlist and take the TAIL to be the HEAD!!!!!!!!!!!!
     * (whatever that means...?)
     */

    /**
     * FACTORY METHOD
     * Creates an array type with the specified line, column, type, and size.
     * If the type received in the constructor is another array type, it adds the new array type at the end of the existing array chain
     *
     * @param line   number of line where the array is being created
     * @param column number of column where the array is being created
     * @param type   type of the array received as a parameter (to check whether it is another array)
     * @param size   size of the array
     *
     * @return the created array type
     */
    public static ArrayType createArray(int line, int column, Type type, int size) {
        // if the array that is received in the constructor is ANOTHER ARRAY -> add at the end of a linkedlist

        Type old = type; // type of the array received as a param
        ArrayType aux = new ArrayType(line, column, type, size); // auxiliar array
        ArrayType result = aux; // auxiliar array used to store the result

        if (type instanceof ArrayType) { // if the array received as a parameter is another array
            result = (ArrayType) type; // store the reference to type in variable result

            while (((ArrayType) old).getType() instanceof ArrayType) { // we need to keep a reference of the last array
                old = ((ArrayType) old).getType(); // we get last array node
            }

            // set the type of the new array we have created to the type of the old array (old)
            // our new array is linked to the old one
            (aux).setType(((ArrayType) old).getType());

            // set the type of the old array to the type of the new array that we have just created (aux)
            // our old array is linked to the new one
            ((ArrayType) old).setType(aux);
        }

        return result;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "[" + size + "]" + type.toString();
    }


    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP param) {
        return v.visit(this, param);
    }

    @Override
    public Type squareBrackets(Type t, int line, int column) {
        if (t instanceof ErrorType)
            return t;
        if (t instanceof IntType)
            return this.type;
        return new ErrorType(line, column, String.format(
                "The type of %s cannot be used as an index.", t));
    }

}
