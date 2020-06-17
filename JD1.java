
import static java.lang.System.out;

public class JD1 {


    public static void main(String[] args) {
        Printer myPrinter = s -> out.println(s);
        myPrinter.printMe("Hello World");
        myPrinter.printWithVersion("Hello World!");
        new Thread(() -> 
            System.out.println("Running in " + Thread.currentThread().getName()),
                "JDThread").start();;

        String test = "test";
        /*         
        Local variable test defined in an enclosing scope must be final or effectively final  Java(536871575)

        test = "test-";
         */
        myPrinter = new Printer() {
            public void printMe(String s) {
                out.println(test + s + " [anon]");
            }
        };
        test(myPrinter);

        myPrinter = s -> out.println(test + s + " [lamda] ");
        test(myPrinter);
        myPrinter = JD1::testPrint;
        test(myPrinter);
        //test(((Printer)JD1::testPrint(s)));

        for (int i = 0; i++ ; i < 10)
        
        
    }


    private static void testPrint(String s) {
        out.println(s + " [method]");
    }

    private static void test(Printer printer) {
        printer.printMe("Hello from " + printer);
    }

    @FunctionalInterface
    static interface Printer {
        void printMe(String string);
        
        //cannot have more than one method, or it is not a functional interface
        /* 
        void doSomethingElse(String s);
         */

        default void printWithVersion(String s) {
            printMe("Version 2.0: " + s);
        };
    }


    
}