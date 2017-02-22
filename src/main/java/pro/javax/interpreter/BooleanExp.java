package pro.javax.interpreter;

/**
 * @author Vlad Zhukovskyi
 */
public interface BooleanExp extends Cloneable {
    boolean evaluate(Context context);

    BooleanExp replace(char ch, BooleanExp expression);

    BooleanExp clone();
}
