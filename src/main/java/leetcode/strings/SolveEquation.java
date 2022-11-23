package leetcode.strings;

/**
 * @author Melody
 * LeetCode_640-Medium-求解一元一次方程
 * 解题思路：先化简为ax+b=0,可以得到x=-b/a;
 * a=0&b!=0->no solution
 * a=0&b=00>infinite solution
 * 问题：1.x前面会有系数，怎么确定
 * 从左往右开始遍历，遇到符号则前面的一串字符可以确定是常数还是未知数
 * @date 2022/8/10 16:14
 */
public class SolveEquation {
    public String solveEquation(String equation) {
        int a = 0, b = 0;
        StringBuilder sb = new StringBuilder();
        boolean after = false;
        boolean pos = equation.charAt(0) == '-' ? false : true;
        for (int i = 0; i < equation.length(); ++i) {
            char ch = equation.charAt(i);
            //遇到运算符，sb值已经确定
            if ('+' == ch || '-' == ch || '=' == ch) {
                //是未知数
                if (sb.charAt(sb.length() - 1) == 'x') {
                    if (sb.length() == 1) {
                        a = pos && !after ? a + 1 : a - 1;
                    } else {
                        a = pos && !after ? a + Integer.parseInt(sb.substring(0, sb.length() - 1)) : a - Integer.parseInt(sb.substring(0, sb.length() - 1));
                    }
                } else {
                    //是常数
                    int tmp = Integer.parseInt(sb.substring(0, sb.length()));
                    b = pos ? b + tmp : b - tmp;
                }
                pos = ch == '+' ? true : false;
                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        }
        if (a == 0 && b != 0) {
            return "No solution";
        } else if (a == 0 && b == 0) {
            return "Infinite solutions";
        } else {
            int value = -b / a;
            return "x=" + value;
        }
    }

    public static void main(String[] args) {
        SolveEquation solveEquation = new SolveEquation();
        System.out.println(solveEquation.solveEquation(new String("x+5-3+x=6+x-2")));
    }
}
