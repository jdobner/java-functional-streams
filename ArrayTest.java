public class ArrayTest {
    public static void main(String[] args) {
        MyClass[] myClasses = new MyClass[5];
        for (MyClass myClass : myClasses) {
            System.out.println(myClass);
        }
    }

    class MyClass {
        final int value;

        MyClass (int val) {
            value = val;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }
}
