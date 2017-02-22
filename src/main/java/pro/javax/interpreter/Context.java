package pro.javax.interpreter;

/**
 * @author Vlad Zhukovskyi
 */
public interface Context {

    boolean lookup(Object obj);

    void assign(VariableExp expression, boolean value);
}
