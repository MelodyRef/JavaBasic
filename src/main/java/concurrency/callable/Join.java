package concurrency.callable;

/**
 * @author Melody
 * @date 2021/11/3 9:46
 */
public class Join {
    public static Object join = new Object();

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("我是子线程，我先睡1秒");
                Thread.sleep(1000l);
                System.out.println("我是子线程，睡完了1秒");
                synchronized (join) {
                    join.notify();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new ThreadA());
        thread.start();
        synchronized (join) {
            join.wait();
        }
//        thread.join();
        System.out.println("如果不加join,我将先打印出来");
    }
}
