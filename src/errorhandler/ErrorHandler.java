package errorhandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private List<ErrorType> errors;
    private static ErrorHandler eh;

    /**
     * SINGLETON PATTERN
     * not publicly used!!!!!!!
     */
    private ErrorHandler() {
        this.errors = new ArrayList<ErrorType>();
    }

    /**
     * If there not exist an instance of ErrorHandler class, create a new one using the private constructor and return it
     * If there already exists an instance of ErrorHandler class, just return it
     *
     * @return
     */
    public static ErrorHandler getInstance() {
        if (eh == null)
            eh = new ErrorHandler();
        return eh;
    }

    public boolean anyErrors() {
        return !this.errors.isEmpty();
    }

    public void showErrors(PrintStream out) {
        if (anyErrors())
            for (ErrorType e : this.errors)
                out.println(e.toString());
    }

    public void addError(ErrorType error) {
        this.errors.add(error);
    }
}
