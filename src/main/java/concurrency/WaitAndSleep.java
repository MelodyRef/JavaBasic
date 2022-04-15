package concurrency;

/**
 * @author Melody
 * @date 2022/4/15 11:14
 */
public class WaitAndSleep {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    // 休眠 2s
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();

//        Thread.sleep(200);
        System.out.println("wait() 之后进入状态：" + t1.getState());
        System.out.println("sleep(2000) 之后进入状态：" + t2.getState());

    }

}
