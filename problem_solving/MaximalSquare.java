public class MaximalSquare {
    public static void main(String[] args) {
        
    }

    public int getMaximumSafeSquareArea(int[][] matrix) {
        int rows = matrix.length;
         if(rows==0){
             return 0;
         }        
         
         int column = matrix[0].length;
         
         int[][] dp = new int[rows+1][column+1];
         
         
         int largest = 0;
         
         for(int i=1; i<=rows; i++){
             for(int j=1; j<=column; j++){
                 
                 if(matrix[i-1][j-1] == 1){
                     dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
                     
                     largest = Math.max(largest, dp[i][j]);
                 }
                 
             }
         }
         
         return largest*largest; 
     }
}
