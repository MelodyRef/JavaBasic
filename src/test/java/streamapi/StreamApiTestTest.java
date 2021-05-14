package streamapi;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamApiTestTest extends TestCase {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 18, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 7777.77)
    );

    @Test
    public void testFilter() {
        emps.stream().filter((e) -> e.getAge() > 18).forEach(System.out::println);
    }

    @Test
    public void testLimit() {
        emps.stream().filter((e) -> e.getAge() < 40).limit(4).forEach(System.out::println);
    }

    @Test
    public void testSkip() {
        emps.stream().filter((e) -> e.getSalary() == 7777.77).skip(2)
                .filter((employee -> employee.getAge() > 18))
                .forEach(System.out::println);
    }

    @Test
    public void testDistinct() {
        emps.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void testMapAndFlatMap() {
        //testMap
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        list.stream().map(str -> str.toUpperCase())
                .forEach(System.out::println);
        //
        System.out.println("------------------------------");
        emps.stream().map(Employee::getName).forEach(System.out::println);
        System.out.println("==============================");

        //流中流
        // Stream<Stream<Character>> stream= list.stream();
    }

    @Test
    public void testSorted() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("==========定制排序============");

        emps.stream().sorted((x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            } else {
                return Integer.compare(x.getAge(), y.getAge());
            }
        }).forEach(System.out::println);
    }
}