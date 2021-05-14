package sort;

import java.util.ArrayList;

public class PartitionedQuery {

    public int[] index;
    public ArrayList<Integer>[] list;

    public PartitionedQuery(int[] index) {
        if (index != null && index.length != 0) {
            this.index = index;
            this.list = new ArrayList[index.length];
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }
        } else {
            throw new Error("index cannot be null or empty");
        }
    }


    private int binarySearch(int value) {
        int start = 0;
        int end = index.length;
        int mid = -1;
        while(start<=end){
            mid=(start+end)/2;
        }
        return 0;
    }
}
