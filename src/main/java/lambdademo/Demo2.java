package lambdademo;

import java.util.Arrays;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
//        int x->5;
        String[] strs = {"11", "22", "33", "44", "55"};
        List<String> list = Arrays.asList(strs);
        for (String str : strs) {
            System.out.println(str + ";");
        }

        //lamda表达式
        list.forEach((str) -> System.out.println(str + ";"));

        //双冒号
        list.forEach(System.out::println);
    }
}
