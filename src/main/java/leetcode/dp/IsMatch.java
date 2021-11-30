package leetcode.dp;

/**
 * @author Melody
 * @date 2021/10/22 15:57
 */
public class IsMatch {
    public boolean isMatch(String s, String p) {
        return match(s, 0, p, 0);
    }

    public boolean match(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();
        //字符串s已经匹配完成
        if (i == m) {
            if (j == n) {
                return true;
            } else {
                //p之后的不以a*b*c*的形式出现则必定不匹配空串
                if ((n - j) % 2 != 0) {
                    return false;
                } else {
                    for (; j < n; j += 2) {
                        if (p.charAt(j) != '*')
                            return false;
                    }
                    return true;
                }
            }
        }
        if (j == n) {
            return i == m ? true : false;
        }
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            //匹配0次或者任意次，0次:左边未匹配，右边j和j+1不产生效果，任意次:右边不动，左边匹配成功往后移动
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                return match(s, i, p, j + 2) || match(s, i + 1, p, j);
            } else {
                return match(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                return match(s, i, p, j + 2);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        IsMatch s = new IsMatch();
        System.out.println(s.isMatch("missM", "m.s*."));
    }
}
