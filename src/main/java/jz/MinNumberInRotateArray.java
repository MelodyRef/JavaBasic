package jz;

public class MinNumberInRotateArray {
    //数组旋转是指将数组的前n个数放到数组的末尾
    public int minNumberInRotateArray(int array[]) {
        if (array.length == 0)
            return 0;
        //找到旋转的数的开头一个数即是最小数
        if (array.length == 1)
            return array[0];
        int size = array.length;
        int min = array[size - 1];
        int x = size - 1;
        while (x > 0 && array[x - 1] < min) {
            min = array[x - 1];
            x--;

        }
        return min;
    }
}
