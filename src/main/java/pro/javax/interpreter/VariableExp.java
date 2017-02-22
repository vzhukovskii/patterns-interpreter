package pro.javax.interpreter;

import java.util.Objects;

/**
 * @author Vlad Zhukovskyi
 */
public class VariableExp implements BooleanExp {

    private final char ch;

    public VariableExp(char ch) {
        this.ch = ch;
    }

    public boolean evaluate(Context context) {
        return context.lookup(ch);
    }

    public BooleanExp replace(char ch, BooleanExp expression) {

        if (this.ch == ch) {
            return expression.clone();
        }

        return new VariableExp(this.ch);
    }

    public BooleanExp clone() {
        return new VariableExp(ch);
    }

    public char getVariable() {
        return ch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VariableExp that = (VariableExp)o;
        return ch == that.ch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ch);
    }
}
