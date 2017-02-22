package pro.javax.interpreter;

/**
 * @author Vlad Zhukovskyi
 */
public class Application {

    public static void main(String[] args) {
        evaluateExpression1();
        evaluateExpression2();
    }

    // (true and x) or (y and (not x))
    public static void evaluateExpression1() {
        Evaluator app = new Evaluator(new ContextImpFactory());

        VariableExp x = new VariableExp('x');
        VariableExp y = new VariableExp('y');

        app.bindVariable(x, false);
        app.bindVariable(y, true);

        BooleanExp expression = new OrExp(
                new AndExp(new Constant(true), x),
                new AndExp(y, new NotExp(x))
        );

        boolean result = app.evaluate(expression);

        System.out.println(result);
    }

    // (true and x) or (y and (not x))
    // => (true and x) or ((not z) and (not x))
    // => (true and x) or ((not true) and (not x))
    // => (true and x) or (false and (not x))
    public static void evaluateExpression2() {
        Evaluator app = new Evaluator(new ContextImpFactory());

        VariableExp x = new VariableExp('x');
        VariableExp y = new VariableExp('y');

        app.bindVariable(x, false);
        app.bindVariable(y, true);

        BooleanExp expression = new OrExp(
                new AndExp(new Constant(true), x),
                new AndExp(y, new NotExp(x))
        );

        VariableExp z = new VariableExp('z');
        NotExp notZ = new NotExp(z);

        BooleanExp replacement = expression.replace('y', notZ);

        app.bindVariable(z, true);

        boolean result = app.evaluate(replacement);

        System.out.println(result);
    }
}
