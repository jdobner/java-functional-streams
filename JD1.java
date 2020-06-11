public class JD1 {
    public static void main(String[] args) {
        Printer myInt = s -> System.out.println(s);
        myInt.printMe("Hello World!");
        new Thread(() -> 
            System.out.println("Running in " + Thread.currentThread().getName()),
                "JDThread").start();;
    }

    static interface Printer {
        void printMe(String string);
    }
}