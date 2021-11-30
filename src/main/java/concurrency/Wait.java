package concurrency;

/**
 * @author Melody
 * @date 2021/11/3 10:09
 */
public class Wait {
    public static void main(String[] args) throws Exception {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行");
            }
        });
        a.start();
        synchronized (a){
            a.wait(1000);
        }
        Thread b = new Thread(()-> System.out.println(Thread.currentThread().getName()+"执行"));
        b.start();
    }
}
