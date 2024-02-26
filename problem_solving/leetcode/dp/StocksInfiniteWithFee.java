// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy_&_sell_stocks_with_transaction_fee/topic 

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StocksInfiniteWithFee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.parseInt(br.readLine());
        int prices[] = new int[days];
        for(int i = 0; i < days; i++) prices[i] = Integer.parseInt(br.readLine());
        int fee = Integer.parseInt(br.readLine());
        int max_profit = stocksInfiniteWithFeeDP(prices, fee);
        System.out.println(max_profit); 
    }

    //Greedy method
    public static int stocksInfiniteWithFee(int[] prices, int fee){
        int buy = prices[0];
        int n = prices.length;
        // int netProfit = 0;
        int currProfit = 0;
        int currSell = 0;
        System.out.println("fee: " + fee);
        for(int i=0; i<n; i++) System.out.print(prices[i]+ " ");
        System.out.println();
        System.out.print(buy + " ");
        int[] sp = new int[n];
        int[] profs = new int[n];

        for(int i=1; i<n; i++){
            if(prices[i] < buy){
                // currProfit += currSell - buy - fee;
                buy = prices[i];
                // currSell = 0;
            }
            else{
                if(prices[i] > currSell){
                    currSell = prices[i];
                }else{
                    if(currSell - prices[i] > fee){
                        currProfit += currSell - buy - fee;
                        buy = prices[i];
                        currSell = 0;
                    }
                }
            }
            System.out.print(buy + " ");
            sp[i] = currSell;
            profs[i] = currProfit;
        }
        System.out.println();
        for(int i = 0; i <n; i++) System.out.print(sp[i] + " ");
        System.out.println();
        for(int i = 0; i <n; i++) System.out.print(profs[i] + " ");
        System.out.println();
        return Math.max(currProfit + currSell - buy - fee, 0);
    }

    //DP method
    public static int stocksInfiniteWithFeeDP(int[] prices, int fee){
        int n = prices.length;
        int buy = -prices[0];
        int sell = 0;
        for(int i = 1; i < n; i++){
            // int nbuy = 0, nsell = 0;
            if(sell - prices[i] > buy){
                buy = sell - prices[i];
            }

            if(prices[i] + buy - fee > sell){
                sell = prices[i] + buy -fee;
            }
        }
        return sell;
    }
}
