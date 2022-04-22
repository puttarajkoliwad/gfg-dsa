// problem statement: https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/n-queens-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueensRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        nQueens(arr, "", 0);
        br.close();
    }

    public static void nQueens(int[][] arr, String curr_pos, int row){
        if(row==arr.length){
            System.out.println(curr_pos+".");
        }

        for(int col=0; col<arr.length; col++){
            if(isSafeSquare(arr, row, col)){
                arr[row][col] = 1;
                nQueens(arr, curr_pos+row+"-"+col+", ", row+1);
                arr[row][col] = 0;
            }
        }
    }

    public static boolean isSafeSquare(int[][] arr, int row, int col) {
        for(int i=row-1; i >= 0 && col < arr.length; i--) {
            if(arr[i][col] == 1) return false;
        }

        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(arr[i][j] == 1) return false;
        }

        for(int i=row-1, j=col+1; i>=0 && j<arr.length; i--, j++){
            if(arr[i][j] == 1) return false;
        }

        return true;
    }
    
}
