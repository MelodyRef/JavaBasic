package leetcode.others;

/**
 * @author Melody
 * @date 2021/10/18 10:37
 */
public class Complement {
    public int findComplement(int num) {
        String binaryStr = Integer.toBinaryString(num);
        StringBuilder ans = new StringBuilder();
        for (char ch : binaryStr.toCharArray()) {
            ans.append(ch == '0' ? 1 : 0);
        }
        int res = Integer.parseInt(ans.toString(),2);
        return res;
    }

    public static void main(String[] args) {
        Complement com = new Complement();
        System.out.println(com.findComplement(5));
    }
}
