package concurrency;

/**
 * @author Melody
 * @date 2021/8/12 14:36
 */
public class VolatileExample {
    int a = 0;
    volatile boolean flag = false;

    public void writer() {
        a = 1;//step1
        flag = true;//step2
    }

    public void reader() {
        if (flag) {//step3
            System.out.println(a);//step4
        }
    }

}
