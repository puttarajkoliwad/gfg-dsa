// problem statement: https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/knights_tour/topic

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KnightsTour {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int row0 = Integer.parseInt(br.readLine());
        int col0 = Integer.parseInt(br.readLine());
        int[][] arr = new int[size][size];
        knightsTour(arr, row0, col0, 1);
    }

    public static void knightsTour(int[][] arr, int row, int col, int move) {
        if(row <0 || col < 0|| row >= arr.length || col >= arr.length || arr[row][col] > 0){
            return;
        }else if(move == arr.length * arr.length){
            arr[row][col] = move;
            printMoves(arr);
            arr[row][col] = 0;
            return;
        }

        arr[row][col] = move;
        knightsTour(arr, row-2, col+1, move+1);
        knightsTour(arr, row-1, col+2, move+1);
        knightsTour(arr, row+1, col+2, move+1);
        knightsTour(arr, row+2, col+1, move+1);
        knightsTour(arr, row+2, col-1, move+1);
        knightsTour(arr, row+1, col-2, move+1);
        knightsTour(arr, row-1, col-2, move+1);
        knightsTour(arr, row-2, col-1, move+1);
        arr[row][col] = 0;
    }

    public static void printMoves(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

