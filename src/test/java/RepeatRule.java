import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by amil on 7/4/2017.
 */
public class RepeatRule implements TestRule
{

    private static class RepeatStatement extends Statement {

        private final int reps;
        private final Statement statement;

        private RepeatStatement(int reps, Statement statement ) {
            this.reps = reps;
            this.statement = statement;
        }

        @Override
        public void evaluate() throws Throwable {
            for(int i = 0; i < reps; i++ ) {
               try{
                   statement.evaluate();
                   System.out.println("worked from attempt number " + (i+1));
                   break;
               }
               catch (Throwable t){
                   System.out.println((i+1) +" try failed");
                   if(i==reps-1){
                       statement.evaluate();
                   }
               }
            }
        }
    }


    public Statement apply(Statement statement, Description description ) {
        Statement result = statement;
        Unstable unstable = description.getAnnotation( Unstable.class );
        if( unstable != null ) {
            int n = unstable.repetitions();
            result = new RepeatStatement( n, statement );
        }
        return result;
    }
}