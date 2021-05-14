package realpractice;

public class BaiduMissingNumberInArray {
    public static int solve(int array[]) {
        if (array.length == 0)
            return 0;
        int length = array.length;
        //数组最大值和最小值差
        int div = array[length - 1] - array[0];
        //差比数组长度小说明是尾或者头缺失
        if (div < length)
            return array[0] == 0 ? length : 0;
        int from = 0, tail = length - 1, mid = (from + tail) / 2;
        //比较当前mid中数值和完整数组中数值大小，如过小于等于则后面缺失，大与则后面前面缺失
        while (from != tail) {
            if (array[mid] <= mid) {
                from = mid + 1;
                mid = (from + tail) / 2;
            } else {
                tail = mid - 1;
                mid = (from + tail) / 2;
            }
        }
        if (array[from] != mid)
            return mid;
        return mid + 1;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(solve(a));
    }
}
