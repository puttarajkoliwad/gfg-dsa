// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy_and_sell_stocks_infinite_transaction_allowed/topic

import java.io.IOException; 
import java.io.BufferedReader; 
import java.io.InputStreamReader;

public class StocksInfiniteTransactions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max_gain = stocksInfiniteTransactions(arr);
        System.out.println(max_gain);
    }

    public static int stocksInfiniteTransactions(int[] arr){
        int n = arr.length;
        int buy = arr[0];
        int total_profit = 0;
        for(int i = 1; i < n; i++){
            if(arr[i] <= buy) buy = arr[i];
            else{
                total_profit += arr[i] - buy;
                buy = arr[i];
            }
        }
        return total_profit;
    }
}
