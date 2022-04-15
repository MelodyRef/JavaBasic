package leetcode.strings;

/**
 * @author Melody
 * @date 2021/12/21 9:50
 */
public class DayOfYear {
    public int dayOfYear(String date) {
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8, date.length());
        return 1;
    }

    public static void main(String[] args) {
        DayOfYear dayOfYear = new DayOfYear();
        System.out.println(dayOfYear.dayOfYear("2019-01-20"));
    }
}
