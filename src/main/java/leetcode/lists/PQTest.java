package leetcode.lists;

/**
 * @author Melody
 * @date 2021/9/23 15:51
 */
public class PQTest {
    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<>(15);
        maxPQ.insert(1);
        maxPQ.insert(3);
        maxPQ.insert(5);
        maxPQ.insert(4);
        maxPQ.insert(2);
        maxPQ.delMax();
        System.out.println(maxPQ.max());
    }
}
