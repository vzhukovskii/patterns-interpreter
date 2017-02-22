package pro.javax.interpreter;

/**
 * @author Vlad Zhukovskyi
 */
public class NotExp implements BooleanExp {

    private final BooleanExp operand;

    public NotExp(BooleanExp operand) {
        this.operand = operand;
    }

    @Override
    public boolean evaluate(Context context) {
        return !operand.evaluate(context);
    }

    @Override
    public BooleanExp replace(char ch, BooleanExp expression) {
        return new NotExp(operand.replace(ch, expression));
    }

    @Override
    public BooleanExp clone() {
        return new NotExp(operand.clone());
    }
}
