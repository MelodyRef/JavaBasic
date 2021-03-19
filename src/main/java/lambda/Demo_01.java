package lambda;

public class Demo_01 {
    public static void main(String[] args) {
        int x = 3;
        new Thread(() -> System.out.println("Hello Lamda")).start();
    }
}
