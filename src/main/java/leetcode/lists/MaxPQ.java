package leetcode.lists;

/**
 * @author Melody
 * @date 2021/9/9 15:05
 */
public class MaxPQ
        <Key extends Comparable<Key>> {
    // 存储元素的数组
    private Key[] pq;
    // 当前 Priority Queue 中的元素个数
    private int N = 0;

    public MaxPQ(int cap) {
        // 索引 0 不用，所以多分配一个空间
        pq = (Key[]) new Comparable[cap + 1];
    }

    /* 返回当前队列中最大元素 */
    public Key max() {
        return pq[1];
    }

    /* 插入元素 e */
    public void insert(Key e) {
        N++;
        pq[N] = e;
        swim(N);
    }

    /* 删除并返回当前队列中最大元素 */
    public Key delMax() {
        Key max = pq[1];
        exch(1, N);
        pq[N] = null;
        N--;
        sink(1);
        return max;
    }

    /* 上浮第 k 个元素，以维护最大堆性质 */
    private void swim(int k) {
        while (k > 1 && less(parent(k), k)) {
            exch(parent(k), k);
            k = parent(k);
        }
    }

    /* 下沉第 k 个元素，以维护最大堆性质 */
    private void sink(int k) {
        //如果沉到堆底，就沉不下去了
        while (left(k) <= N) {
            //assuming left child is larger than right
            int larger = left(k);
            //compare the value of left and right child
            if (right(k) <= N && less(larger, right(k))) {
                larger = right(k);
            }
            //if both the childs are less than parent,then break
            if (less(larger, k)) break;
            exch(k, larger);
            k = larger;
        }
    }

    /* 交换数组的两个元素 */
    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /* pq[i] 是否比 pq[j] 小？ */
    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /* 还有 left, right, parent 三个方法 */

    /**
     * parent of k
     */

    public int parent(int k) {
        return k / 2;
    }

    /**
     * left child of root
     *
     * @param root
     * @return the index of ans
     */
    public int left(int root) {
        return 2 * root;
    }

    /**
     * right child of root
     *
     * @param root
     * @return the index of ans
     */
    public int right(int root) {
        return root * 2 + 1;
    }
}
