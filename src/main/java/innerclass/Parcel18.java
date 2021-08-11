package innerclass;

/**
 * @author Melody
 * @date 2021/8/5 16:05
 */
public class Parcel18 {
    public Wrapping wrapping(int x) {
        return new Wrapping(x) {
            public String str = x + "5";

            @Override
            public int value() {
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel18 parcel18 = new Parcel18();
        Wrapping wrapping = parcel18.wrapping(10);
        System.out.println(wrapping.value());
    }
}
