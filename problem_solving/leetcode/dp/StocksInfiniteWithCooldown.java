// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy_&_sell_stock_cooldown/topic

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StocksInfiniteWithCooldown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.parseInt(br.readLine());
        int[] prices = new int[days];
        for(int i = 0; i < days; i++){
            prices[i] = Integer.parseInt(br.readLine());
        }
        int maxProfit = stocksInfiniteWithCooldown(prices);
        System.out.println(maxProfit);
    }

    public static int stocksInfiniteWithCooldown(int[] prices){
        int n = prices.length;
        int tbuy = -prices[0];
        int tsell = 0;
        int tcool = 0;
        for(int i=1; i<n; i++){
            int nbuy = 0;
            int nsell = 0;
            int ncool = 0;

            if(tcool - prices[i] > tbuy){
                nbuy = tcool - prices[i];
            }else{
                nbuy = tbuy;
            }

            if(prices[i] + tbuy > tsell){
                nsell = prices[i] + tbuy;
            }else{
                nsell = tsell;
            }

            if(tsell > tcool) ncool = tsell;
            else{
                ncool = tcool;
            }

            tbuy = nbuy; tsell = nsell; tcool = ncool;
        }
        return tsell;
    }
}
