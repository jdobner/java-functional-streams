public class JD1 {
    public static void main(String[] args) {
        Printer myPrinter = s -> System.out.println(s);
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
                System.out.println(test + s);
            }
        };
        myPrinter.printMe("Hello World");
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