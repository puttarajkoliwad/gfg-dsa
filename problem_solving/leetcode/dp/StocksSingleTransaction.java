// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy_and_sell_stocks_1_transaction_allowed/topic

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StocksSingleTransaction{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine()); 
        }

        int profit = maxTrade(arr);
        System.out.println(profit);
    }

    public static int maxTrade(int[] arr){
        int n = arr.length;
        int buy = Integer.MAX_VALUE;
        int curr_sell = 0;
        int max_profit = 0;
        for(int i=0; i<n; i++){
            if(arr[i] < buy){
                buy = arr[i];
            }

            curr_sell = arr[i] - buy;
            if(curr_sell > max_profit) max_profit = curr_sell;
        }
        return max_profit;
    }
}