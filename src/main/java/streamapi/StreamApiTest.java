package streamapi;

import java.util.Arrays;
import java.util.List;

public class StreamApiTest {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(16);
//        Stream stream1 = list.stream();
        List<Employee> emps = Arrays.asList(
                new Employee(102, "李四", 59, 6666.66),
                new Employee(101, "张三", 18, 9999.99),
                new Employee(103, "王五", 28, 3333.33),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(105, "田七", 38, 5555.55)
        );

//        Employee emps[] = new Employee[10];
//        Stream<Employee> stream2 = Arrays.stream(emps);
//        Stream<String> stream3 = Stream.of("aa", "bb", "cc");
//        stream3.forEach(System.out::println);
//        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
//        stream4.limit(10)
//                .forEach(System.out::println);
//        stream4.filter()
    }
}
