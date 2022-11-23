package concurrency;

import java.util.concurrent.*;

/**
 * @author Melody
 * @date 2021/8/9 16:23
 */
public class TaskDemo1 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(new TaskDemo1());
        executor.submit(futureTask);
        System.out.println(futureTask.get());
    }
}
