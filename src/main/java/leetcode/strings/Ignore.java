package leetcode.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Melody
 * @date 2021/10/13 16:11
 */
public class Ignore {
    public static void main(String[] args) {
        String[] array = new String[]{"apple", "Orange", "banana", "Lemon"};
//        Arrays.sort(array, Ignore::comp);
//        Arrays.sort(array, (a, b) -> a.compareToIgnoreCase(b));
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        System.out.println(String.join(",", array));
    }

    public static int comp(String a, String b) {
        return a.compareToIgnoreCase(b);
    }

}
