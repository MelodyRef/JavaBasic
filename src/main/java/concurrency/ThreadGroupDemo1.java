package concurrency;

/**
 * @author Melody
 * @date 2021/8/9 16:34
 */
public class ThreadGroupDemo1 {
    public static void main(String[] args) {
        Thread testThread = new Thread(()-> {
            System.out.println("testThread当前ThreadGroup的名字："+Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字"+Thread.currentThread().getName());
        });
        testThread.start();
        System.out.println("执行main方法线程的名字"+Thread.currentThread().getName());

    }
}
