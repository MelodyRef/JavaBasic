package concurrency.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author Melody
 * @date 2022/5/6 14:34
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务足够小就执行任务
        boolean canCompute = (end - start) <= THRESHOLD;

        if (canCompute) {
            for (int i = start; i <= end; ++i) {
                sum += i;
            }
        } else {
            int middle = (end + start) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            invokeAll(leftTask, rightTask);
//            leftTask.fork();
//            rightTask.fork();

            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            sum = leftResult + rightResult;

        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1, 4);
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (Exception e) {

        }
    }
}
