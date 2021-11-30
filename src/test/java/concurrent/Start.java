package concurrent;

import org.junit.Test;

/**
 * @author Melody
 * @date 2021/8/9 17:26
 */
public class Start {
    @Test
    public void testStartMethod() {
        Thread thread = new Thread(() -> {
        });
        thread.start();
        thread.start();
    }

    @Test
    public void blockedTest() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");
//        a.start();
//        Thread.sleep(1000);
//        b.start();
        a.start();
//        a.join(1000);
        Thread.sleep(1000L);
        b.start();
        System.out.println(a.getName() + ":" + a.getState());
        Thread.sleep(3000L);
        System.out.println(b.getName() + ":" + b.getState());
    }

    private synchronized void testMethod() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
