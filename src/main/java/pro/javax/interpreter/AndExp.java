package pro.javax.interpreter;

/**
 * @author Vlad Zhukovskyi
 */
public class AndExp implements BooleanExp {

    private final BooleanExp operandA;
    private final BooleanExp operandB;

    public AndExp(BooleanExp operandA, BooleanExp operandB) {
        this.operandA = operandA;
        this.operandB = operandB;
    }

    public boolean evaluate(Context context) {
        return operandA.evaluate(context) && operandB.evaluate(context);
    }

    public BooleanExp replace(char ch, BooleanExp expression) {
        return new AndExp(operandA.replace(ch, expression), operandB.replace(ch, expression));
    }

    public BooleanExp clone() {
        return new AndExp(operandA.clone(), operandB.clone());
    }
}
