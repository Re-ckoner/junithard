import javafx.scene.SubScene;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by Andy on 04.07.2017.
 */
public class SimpleRule extends TestWatcher implements TestRule {

    public Statement apply(final Statement base, Description description){
        return new MyRule(base);
    }

    private static class MyRule extends Statement {
        private final Statement base;

        public MyRule(Statement base) {
            this.base = base;
        }

        @Override
        public void evaluate() throws Throwable {
            System.out.println("before");
            try{
                System.out.println("ev");
            base.evaluate();
            }
            catch (Throwable t){
                System.out.println("ev1");
                base.evaluate();
            }
            System.out.println("after");
        }



    }
}
