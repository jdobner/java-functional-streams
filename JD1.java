public class JD1 {
    public static void main(String[] args) {
        Printer myInt = s -> System.out.println(s) + getVersion();
        myInt.printMe("Hello World 2.0");
        new Thread(() -> 
            System.out.println("Running in " + Thread.currentThread().getName()),
                "JDThread").start();;
    }

    @FunctionalInterface
    static interface Printer {
        void printMe(String string);
        
        //cannot have more than one method, or it is not a functional interface
        default String getVersion() {return "2.0";};
    }
}