// problem statement: https://leetcode.com/problems/coloring-a-border/
// Solution: https://www.youtube.com/watch?v=R3AJoOBVAlg&list=PL-Jc9J83PIiEuHrjpZ9m94Nag4fwAvtPQ

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ColoringBorder {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] mat = new int[m][n];
        for(int i=0; i<m; i++){
            String[] parts = br.readLine().split("\s");
            for (int j=0; j<n; j++){
                mat[i][j] = Integer.parseInt(parts[j]);
            }
        }
        int row = Integer.parseInt(br.readLine());
        int col = Integer.parseInt(br.readLine());
        int color = Integer.parseInt(br.readLine());

        int[][] ans = colorBorder(mat, row, col, color);
        for(int i=0; i<ans.length; i++){
            for(int j=0; j<ans[i].length; j++){
                System.out.print(ans[i][j]+ " ");
            }
            System.out.println();
        }
        
        br.close();
    }

    public static int[][] colorBorder(int[][] mat, int row, int col, int color) {
        int[][] counts = new int[mat.length][mat[0].length];
        counts[row][col] = -1;
        dfs(mat, row, col, mat[row][col], counts);
        // for(int i=0; i<mat.length; i++) {
        //     for(int j=0; j<mat[i].length; j++) {
        //         System.out.print(counts[i][j]);
        //     }
        //     System.out.println();
        // }
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[i].length; j++) {
                if(counts[i][j] < 4 && mat[i][j] < 0) {
                    mat[i][j] = color;
                }
                if(mat[i][j] < 0) mat[i][j] = -mat[i][j];
            }
        }
        return mat;
    }

    public static void dfs(int[][] mat, int row, int col, int tar, int[][] counts){
        if(row < 0 || row >= mat.length || col <0 || col >= mat[0].length || Math.abs(mat[row][col]) != tar){
            return;
        }

        if(Math.abs(mat[row][col]) == tar){
            counts[row][col]++;
            if(mat[row][col] == tar){
                mat[row][col] = -tar;
            }else return;
        }

        dfs(mat, row-1, col, tar, counts);
        dfs(mat, row, col+1, tar, counts);
        dfs(mat, row+1, col, tar, counts);
        dfs(mat, row, col-1, tar, counts);
    }
    
}
