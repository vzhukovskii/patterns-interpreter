package pro.javax.interpreter;

/**
 * @author Vlad Zhukovskyi
 */
public class ContextImpFactory implements ContextFactory {
    @Override
    public Context createContext() {
        return new ContextImp();
    }
}
