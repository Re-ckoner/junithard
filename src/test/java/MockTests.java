import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Andy on 04.07.2017.
 */
public class MockTests {

    int i=0;

    @Rule
    public UnstableRule rule = new UnstableRule();

    @Test
        public void mockTest1(){
        Assert.assertEquals(++i,2);
        System.out.print("test");
    }


}
