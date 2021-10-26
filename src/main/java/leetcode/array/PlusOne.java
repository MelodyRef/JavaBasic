package leetcode.array;

/**
 * @author Melody
 * @date 2021/10/21 9:50
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        //没有进位产生
        if (digits[n - 1] + 1 < 10) {
            digits[n - 1]++;
        } else {
            //进位
            int add = 1;
            int i = n - 1;
            while (i >= 0 && digits[i] + add == 10) {
                //产生进位，
                if (i == 0) {
                    int[] ans = new int[digits.length + 1];
                    ans[0] = 1;
                    return ans;
                } else {
                    add = 1;
                    digits[i--] = 0;
                }
            }
            if (add == 1) {
                digits[i] += 1;
            }
        }
        return digits;
    }
}
