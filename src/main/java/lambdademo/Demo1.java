package lambdademo;

import java.util.Arrays;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("add","sub","multi","division");
        list.forEach(Demo1::print);
    }
    public static void print(String context){
        System.out.println(context);
    }
}
