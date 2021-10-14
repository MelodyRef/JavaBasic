package leetcode.lists;

/**
 * @author Melody
 * @date 2021/9/23 15:56
 */
public class MinPQ<Key extends Comparable<Key>> {
    //capacity of PQ
    private int N = 0;
    private Key[] pq;

    public MinPQ(int cap) {
        pq = (Key[]) new Comparable[cap + 1];
    }

    /**
     * return the minmum key of pq
     * @return
     */
    public Key min(){
        return pq[1];
    }



}
