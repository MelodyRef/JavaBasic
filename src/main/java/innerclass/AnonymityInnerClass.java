package innerclass;

/**
 * @author Melody
 * @date 2021/8/4 16:40
 */

class Inner {
    private int value = 1;

    public int getValue() {
        return value;
    }
}

public class AnonymityInnerClass {
    public Inner getInnerValue(int tmp) {
        return new Inner() {
            private int value = 11;

            @Override
            public int getValue() {
                return value;
            }
        };
    }

    public static void main(String[] args) {
        AnonymityInnerClass cls = new AnonymityInnerClass();
        Inner inner = cls.getInnerValue(5);
        System.out.println(inner.getValue());
    }
}




