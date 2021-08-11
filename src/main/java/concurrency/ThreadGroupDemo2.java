package concurrency;

/**
 * @author Melody
 * @date 2021/8/9 16:57
 */


//
public class ThreadGroupDemo2 {
    public static void main(String[] args) {
        ThreadGroup threadGroup1 = new ThreadGroup("gourp1") {
            //继承Thread类并重新定义方法
            //this method can catch all unchecked exception by group members
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };
        Thread thread1 = new Thread(threadGroup1, new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("测试异常");
            }
        });
        thread1.start();
    }
}
