package concurrency;

/**
 * @author Melody
 * @date 2021/11/3 10:09
 */
public class Wait {
    public static void main(String[] args) throws Exception {
        System.out.println("-1<<29=");
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行");
            }
        });
        a.start();
//        Thread c = new Thread()
        synchronized (a) {
            a.wait();

        }

        System.out.println("调用带时间参数的wait方法后线程的状态：" + a.getState());
        Thread b = new Thread(() -> System.out.println(Thread.currentThread().getName() + "执行"));
        b.start();
    }
}
