import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Andy on 04.07.2017.
 */
public class MockTests {

    int counter=0;

    @Rule
    public RepeatRule watcher = new RepeatRule();


    //always fails
    @Test
    @Unstable(repetitions = 5)
        public void alwaysFails(){
        Assert.assertEquals(2,3);

    }

    @Test
    @Unstable(repetitions = 10)
    public void worksFromFirstTry(){
        assert(true);
    }

    @Test
    @Unstable(repetitions = 10)
    public void sometimesTrue(){
       counter++;
        Assert.assertEquals(7,counter);
    }

    @Test
   // @Unstable(repetitions = 10)
    public void sometimesNoAnnotation(){
        counter++;
        Assert.assertEquals(7,counter);

    }






}
