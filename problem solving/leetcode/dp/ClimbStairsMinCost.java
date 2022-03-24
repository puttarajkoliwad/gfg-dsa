// propblem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/min-cost-maze-traversal-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClimbStairsMinCost {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(br.readLine());
        int cols = Integer.parseInt(br.readLine());

        int costs[][] = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            String[] row_str = br.readLine().split("\s");
            for(int j = 0; j < cols; j++){
                costs[i][j] = Integer.parseInt(row_str[j]);
            }
        }

        int min_cost = climbStairsMinCost(costs);
        System.out.println("min cost: "+min_cost);
    }

    public static int climbStairsMinCost(int[][] costs){
        // int cost = 0;
        int rows = costs.length;
        int cols = costs[0].length;
        int[][] min_mat = new int[rows][cols];
        for(int i=rows-1; i>=0; i--){
            for(int j=cols-1; j>=0; j--){
                // int min_adj = Integer.MAX_VALUE;
                if(i==rows-1){
                    if(j==cols-1) min_mat[i][j] = costs[i][j];
                    else{
                        min_mat[i][j] = costs[i][j] + min_mat[i][j+1];
                    }
                }else{
                    if(j==cols-1) min_mat[i][j] = costs[i][j] + min_mat[i+1][j];
                    else{
                        min_mat[i][j] = Math.min(min_mat[i+1][j], min_mat[i][j+1]) + costs[i][j];
                    }
                }
            }
        }
        // System.out.println("=====");
        // for(int i=0; i<rows; i++){
        //     for(int j=0; j<cols; j++){
        //         System.out.print(min_mat[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("=====");
        return min_mat[0][0];
    }
}
