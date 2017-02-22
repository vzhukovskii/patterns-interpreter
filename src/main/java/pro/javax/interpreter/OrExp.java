package pro.javax.interpreter;

/**
 * @author Vlad Zhukovskyi
 */
public class OrExp implements BooleanExp {
    private final BooleanExp operandA;
    private final BooleanExp operandB;

    public OrExp(BooleanExp operandA, BooleanExp operandB) {
        this.operandA = operandA;
        this.operandB = operandB;
    }

    public boolean evaluate(Context context) {
        return operandA.evaluate(context) || operandB.evaluate(context);
    }

    public BooleanExp replace(char ch, BooleanExp expression) {
        return new OrExp(operandA.replace(ch, expression), operandB.replace(ch, expression));
    }

    public BooleanExp clone() {
        return new OrExp(operandA.clone(), operandB.clone());
    }
}
