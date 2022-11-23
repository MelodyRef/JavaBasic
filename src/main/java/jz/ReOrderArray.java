package jz;

public class ReOrderArray {
    public static int[] reOrderArray(int[] array) {
        int[] odds = new int[array.length];
        int[] evens = new int[array.length];
        int ocnt = 0, ecnt = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evens[ecnt++] = array[i];
            } else odds[ocnt++] = array[i];
        }
        for (int i = 0; i < ocnt; i++) {
            array[i] = odds[i];
        }
        for (int i = 0; i < ecnt; i++) {
            array[ocnt++] = evens[i];
        }
        return array;
    }

    public static void main(String[] args) {
        int a[] = {1, 4, 3};
        reOrderArray(a);
        System.out.println(a[2]);

    }
}
