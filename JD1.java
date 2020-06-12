public class JD1 {
    public static void main(String[] args) {
        Printer myInt = s -> System.out.println(s);
        myInt.printMe("Hello World");
        myInt.printWithVersion("Hello World!");
        new Thread(() -> 
            System.out.println("Running in " + Thread.currentThread().getName()),
                "JDThread").start();;
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