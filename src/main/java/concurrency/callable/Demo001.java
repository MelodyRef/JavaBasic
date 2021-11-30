package concurrency.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Melody
 * @date 2021/11/1 10:31
 */
public class Demo001 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 2;
    }

    public static void main(String[] args)  throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        Demo001 demo001 = new Demo001();
        Future<Integer> result = executorService.submit(demo001);
        System.out.println(result.get());
    }
}
