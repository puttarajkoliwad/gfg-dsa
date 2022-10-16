//challenge link: https://leetcode.com/problems/maximal-square/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaximalSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        List<String> li = new ArrayList<String>();
        while((line = br.readLine()) != null && line != ""){
            li.add(line);
        }

        char[][] matrix = new char[li.size()][li.get(0).length()];

        for(int i=0; i < li.size(); i++){
            matrix[i] = String.join("",li.get(i).split("\\s")).toCharArray();
        }
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix){
        int largest = 0;

        int m = matrix.length, n = matrix[0].length;
        int[][] dp_matrix = new int[m+1][n+1];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1'){
                    dp_matrix[i+1][j+1] = 1 + Math.min(dp_matrix[i][j], Math.min(dp_matrix[i+1][j], dp_matrix[i][j+1]));
                    if(dp_matrix[i+1][j+1] > largest) largest = dp_matrix[i+1][j+1];
                }
            }
        }
        
        return largest * largest;
    }
}
