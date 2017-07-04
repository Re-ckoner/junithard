import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Andy on 04.07.2017.
 */
public class MockTests {

    int i=0;

    @Rule
    public RepeatRule watcher = new RepeatRule();



    @Test
    @Repeat(times=10)
        public void mockTest1(){
        Assert.assertEquals(2,2);
        i++;
        System.out.println(i);
    }


}
