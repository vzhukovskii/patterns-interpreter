package pro.javax.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vlad Zhukovskyi
 */
public class ContextImp implements Context {

    private final Map<Object, Boolean> variables;

    ContextImp() {
        variables = new HashMap<>();
        variables.put(true, true);
        variables.put(false, false);
    }

    public boolean lookup(Object obj) {
        return variables.get(obj);
    }

    public void assign(VariableExp expression, boolean value) {
        variables.put(expression.getVariable(), value);
    }
}
