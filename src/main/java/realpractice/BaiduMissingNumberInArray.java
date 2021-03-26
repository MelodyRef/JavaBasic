package realpractice;

public class BaiduMissingNumberInArray {
    public static int solve(int array[]) {
        if (array.length == 0)
            return 0;
        int length = array.length;
//        int tru[] = new int[length + 1];
//        for (int i = 0; i < tru.length; i++) {
//            tru[i] = i;
//        }
        int min = 0, max = length, midt = (int) Math.ceil((double) ((min + max) / 2));
        int from = 0, tail = length - 1, mid = (from + tail) / 2;
        //比较当前mid中数值和完整数组中数值大小，如过小于等于则后面缺失，大与等于则后面前面缺失
        while (from != tail) {
            if (array[mid] <= mid) {
                from = mid + 1;
                mid = (from + tail) / 2;
            } else {
                tail = mid - 1;
                mid = (from + tail) / 2;
            }
        }
        if (array[from] != from)
            return from;
        else return from == 0 ? 0 : length;
    }

    public static void main(String[] args) {
        int a[] = {0,1, 2, 3, 4, 6, 7};
        System.out.println(solve(a));
    }
}
