package innerclass;

/**
 * @author Melody
 * @date 2021/8/5 16:34
 */
public interface ClassInterface {
    void howdy();

    class Test implements ClassInterface {
        @Override
        public void howdy() {
            System.out.println("howdy");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
