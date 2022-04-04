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
        
    }
}
