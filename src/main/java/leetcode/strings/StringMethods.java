package leetcode.strings;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringMethods {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(str.substring(1,3));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd");
        System.out.println(simpleDateFormat.format(new Date()));
    }
}
