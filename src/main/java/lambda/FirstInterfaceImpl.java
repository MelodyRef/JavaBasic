package lambda;

import lambda.inteface.FirstFunctionInteface;

public class FirstInterfaceImpl {

    public FirstFunctionInteface functionInteface;

    public FirstInterfaceImpl(FirstFunctionInteface inteface) {
        this.functionInteface = inteface;
        System.out.println("My first FunctionalInterface");
    }

    public void sout(int x, int y) {
        System.out.println("Hello World");
        functionInteface.add(x, y);
    }

    public static void main(String[] args) {
        int x = 3;
        new FirstInterfaceImpl((a, b) -> System.out.println(a + x + b - 1)).sout(4, x);
    }
}
