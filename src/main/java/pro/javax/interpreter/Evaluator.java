package pro.javax.interpreter;

/**
 * @author Vlad Zhukovskyi
 */
public class Evaluator {
    private final Context context;

    public Evaluator(ContextFactory contextFactory) {
        this.context = contextFactory.createContext();
    }

    public void bindVariable(VariableExp expression, boolean value) {
        context.assign(expression, value);
    }

    public boolean evaluate(BooleanExp expression) {
        return expression.evaluate(context);
    }
}
