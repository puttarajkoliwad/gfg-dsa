// prblem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/goldmine-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoldMine {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(br.readLine());
        int cols = Integer.parseInt(br.readLine());
        int[][] mine = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            String[] row = br.readLine().split("\\s");
            for(int j = 0; j < cols; j++) {
                mine[i][j] = Integer.parseInt(row[j]);
            }
        }
        int max_gold = maxGold(mine);
        System.out.println(max_gold);
    }

    public static int maxGold(int[][] mine){
        int rows = mine.length;
        int cols = mine[0].length;
        int[][] gold_mat = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            gold_mat[i][cols-1] = mine[i][cols-1];
        }
        
        for(int j=cols-2; j>=0; j--){
            for(int i=0; i < rows; i++){
                if(i==0) gold_mat[i][j] = mine[i][j] + Math.max(gold_mat[i][j+1], gold_mat[i+1][j+1]);
                else if(i==rows-1) gold_mat[i][j] = mine[i][j] + Math.max(gold_mat[i][j+1], gold_mat[i-1][j+1]);
                else gold_mat[i][j] = mine[i][j] + Math.max(gold_mat[i][j+1], Math.max(gold_mat[i-1][j+1], gold_mat[i+1][j+1]));
            }
        }

        /* System.out.println("====");
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(gold_mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("===="); */

        int max_gold = gold_mat[0][0];
        for(int i = 0; i < rows; i++) {
            if(max_gold < gold_mat[i][0]) max_gold = gold_mat[i][0];
        }
        
        return max_gold;
    }
}
