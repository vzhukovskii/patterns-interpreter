package pro.javax.interpreter;

/**
 * @author Vlad Zhukovskyi
 */
public class Constant implements BooleanExp {

    private final boolean operand;

    public Constant(boolean operand) {
        this.operand = operand;
    }

    @Override
    public boolean evaluate(Context context) {
        return context.lookup(operand);
    }

    @Override
    public BooleanExp replace(char ch, BooleanExp expression) {
        return this;
    }

    @Override
    public BooleanExp clone() {
        return new Constant(operand);
    }
}
