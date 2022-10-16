// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy_and_sell_stocks_two_transactions_allowed/topic

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StocksWithTwoTransactions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.parseInt(br.readLine());
        int prices[] = new int[days];
        for(int i=0; i<days; i++){
            prices[i] = Integer.parseInt(br.readLine());
        }
        int twoTransProfit = stocksWithTwoTransactions(prices);
        System.out.println(twoTransProfit);
    }

    public static int stocksWithTwoTransactions(int[] prices){
        int n = prices.length;
        int[] pTrades = new int[n];
        int[] fTrades = new int[n];

        int min_buy = prices[0];
        for(int i = 1; i < n; i++){
            if(prices[i] < min_buy){
                min_buy = prices[i];
            }

            pTrades[i] = Math.max(prices[i] - min_buy, pTrades[i-1]);
        }

        int max_sell = prices[n-1];
        for(int i=n-2; i>=0; i--){
            if(prices[i] > max_sell){
                max_sell = prices[i];
            }

            fTrades[i] = Math.max(max_sell - prices[i], fTrades[i+1]);
        }

        int totalTrade = pTrades[0] + fTrades[0];
        for(int i=1; i<n; i++){
            if(pTrades[i] + fTrades[i] > totalTrade) totalTrade = pTrades[i] + fTrades[i];
        }
        return totalTrade;
    } 
}
