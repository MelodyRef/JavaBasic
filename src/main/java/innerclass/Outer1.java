package innerclass;

/**
 * @author Melody
 * @date 2021/8/4 10:33
 */
public class Outer1 {
    class Inner1 {
        public int value = 1;
    }

    public static void main(String[] args) {
        Outer1 outer1 = new Outer1();
        Outer1.Inner1 inner = outer1.new Inner1();
    }
}
