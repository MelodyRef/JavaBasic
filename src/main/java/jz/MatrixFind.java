package jz;

public class MatrixFind {
    public static boolean find(int[][] array, int target) {
        int rows = array.length;
       if(rows==0)
           return false;
       int cols = array[0].length;
       if(cols==0)
           return false;
        int border = array[0].length - 1;
//        int rowmax = colmax;
        int col = border;
        int row = 0;
        while (array[row][col] != target) {
            if (array[row][col] < target) {
                if (row < border) {
                    row++;
                    continue;

                }
                if(row==border)
                    break;
            }
            if (array[row][col] > target) {
                if(col>0){
                    col--;
                    continue;
                }
                if(col==0)
                    break;
            }
        }
        if(array[row][col]==target)
            return true;
        else return false;
    }

    public static void main(String[] args) {
        int [][] array= {{}} ;
        System.out.println(find(array,7));
    }
}
