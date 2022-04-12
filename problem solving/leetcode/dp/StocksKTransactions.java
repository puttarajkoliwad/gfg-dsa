// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy_and_sell_stocks_k_transactions_allowed/topic

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StocksKTransactions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.parseInt(br.readLine());
        int[] prices = new int[days];
        for(int i=0; i<days; i++){
            prices[i] = Integer.parseInt(br.readLine());
        }
        int transLmt = Integer.parseInt(br.readLine());
        int profit = stocksKTransactions(prices, transLmt);
        System.out.println(profit);
    }

    public static int stocksKTransactions(int[] prices, int transLmt){
        int n = prices.length;
        int k = transLmt;
        int[][] dp = new int[k+1][n];
        for(int i=1; i<=k; i++){
            int max = Integer.MIN_VALUE;
            for(int j=1; j<n; j++){
                if(dp[i-1][j-1] - prices[j-1] > max) max = dp[i-1][j-1] - prices[j-1];
                if(max + prices[j] > dp[i][j-1]){
                    dp[i][j] = max + prices[j];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[k][n-1];
    }
}
