// prolem statement: https://www.pepcoding.com/resources/online-java-foundation/graphs/count-islands-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
// import graphs.Edge;

public class CountIslands {
    static int islands=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(br.readLine());
        int cols = Integer.parseInt(br.readLine());
        int[][] arr = new int[rows][cols];
        for(int i=0; i<rows; i++){
            String[] srow = br.readLine().split("\s");
            for(int j=0; j<cols; j++){
                arr[i][j] = Integer.parseInt(srow[j]);
            }
        }
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(arr[i][j]==0 && !visited[i][j]){
                    spanIsland(arr, i, j, visited);
                    islands++;
                }
            }
        }
        System.out.println(islands);
    }

    public static void spanIsland(int[][] arr, int row, int col, boolean[][] visited){
        if(row < 0 || row >= arr.length || col <0 || col >= arr[row].length || visited[row][col] || arr[row][col] == 1){
            return;
        }

        visited[row][col] = true;
        spanIsland(arr, row-1, col, visited);
        spanIsland(arr, row, col-1, visited);
        spanIsland(arr, row+1, col, visited);
        spanIsland(arr, row, col+1, visited);
        // System.out.println(row + " " + col + " " + islands);
    }
}
