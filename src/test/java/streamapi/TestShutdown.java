package streamapi;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestShutdown extends TestCase {
    List<Employee2> emps = Arrays.asList(
            new Employee2(102, "李四", 59, 6666.66, Employee2.Status.BUSY),
            new Employee2(101, "张三", 18, 9999.99, Employee2.Status.FREE),
            new Employee2(103, "王五", 28, 3333.33, Employee2.Status.VOCATION),
            new Employee2(104, "赵六", 8, 7777.77, Employee2.Status.BUSY),
            new Employee2(104, "赵六", 8, 7777.77, Employee2.Status.FREE),
            new Employee2(104, "赵六", 8, 7777.77, Employee2.Status.FREE),
            new Employee2(105, "田七", 38, 5555.55, Employee2.Status.BUSY)
    );

    void testSerachAndMatch() {
        System.out.println("========allMatch========");
        boolean allMatch = emps.stream().allMatch((e) -> e.getStatus().equals(Employee2.Status.BUSY));

        System.out.println("========anyMatch========");
        boolean anyMatch = emps.stream().anyMatch((e) -> e.getAge() > 10);

        System.out.println("========noneMatch========");
        boolean noneMatch = emps.stream().noneMatch((e) -> e.getName().equals("李四"));

        System.out.println("========findFirst========");
        Optional<Employee2> findFirst = emps.stream().sorted(
                (e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).findFirst();

    }


}