public class PlayWithMethods {
    

    public static void main(String[] args) {
        final var ca = new ClassA(5);
        final var cb = new ClassB(9);
        FI fi = ClassA::sum;

        int sum = fi.doIt(ca, cb);
        System.out.println(sum);

        fi = (ClassA cla, ClassB clb) ->  ca.val - cb.val;
        sum = fi.doIt(ca, cb);
        System.out.println(sum);


    }

    
    static class ClassA {
        int val;

        ClassA(int val) {
            this.val = val;
        }

        int sum(ClassB cb) {
            return val + cb.val;
        }
    }
    
    static class ClassB {
        final int val;

        ClassB(int val) {
            this.val = val;
        }
    }


    interface FI {
        int doIt(ClassA ca, ClassB cb);
    }
    


}