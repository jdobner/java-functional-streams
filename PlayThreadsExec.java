import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PlayThreadsExec {
    public static void main(final String[] args) throws Exception {
        final var exec = Executors.newScheduledThreadPool(1);
        final var f = exec.schedule(() -> new MyClass().toString(), 1, TimeUnit.SECONDS);
        System.out.println("waiting");
        System.out.println(f.get());

        final var f2 = exec.schedule(new MyClass()::toString, 1, TimeUnit.SECONDS);
        System.out.println("waiting");
        System.out.println(f2.get());

        exec.shutdown();
     }

     static class MyClass {

        MyClass() {
            System.out.println("Created " + getClass());
        }
         @Override
         public String toString() {
             return "Hello World!";
         }
     }

}