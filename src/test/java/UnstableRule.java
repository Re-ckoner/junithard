import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Created by Andy on 04.07.2017.
 */
public class UnstableRule extends TestWatcher {

    @Override
    protected void failed(Throwable e, Description description) {
        System.out.print("custom fail");

    }
}
