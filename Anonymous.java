public class Anonymous {
    
    public static void main(String[] args) {
        new Anonymous().test();
    }

    void test() {
        var a = 1;

        new Runnable() {
            public void run() {
                System.out.println("a=" + a);
            }
        }.run();
    }
}