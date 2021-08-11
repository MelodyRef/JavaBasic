package concurrency;

/**
 * @author Melody
 * @date 2021/8/9 16:42
 */
public class PriorityDemo1 {
    public static void main(String[] args) {
        Thread a = new Thread();
        System.out.println("我是默认线程优先级:" + a.getPriority());
        Thread b = new Thread();
        b.setPriority(10);
        System.out.println("我是设置过的线程优先级:" + b.getPriority());
    }
}
