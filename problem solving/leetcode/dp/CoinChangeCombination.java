import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoinChangeCombination {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int tar = Integer.parseInt(br.readLine());

        int max_ways = coinChangeCombination(arr, tar);
        System.out.println("max_ways = " + max_ways);
    }

    public static int coinChangeCombination(int[] arr, int tar){
        int n = arr.length;
        int[] coin_combi = new int[tar+1];
        // System.out.print("XX ");
        // for(int i=0; i<=tar; i++) System.out.print(i + " ");
        // System.out.println();
        coin_combi[0] = 1;
        for(int i=0; i<n; i++){
            for(int j=arr[i]; j<=tar; j++){
                coin_combi[j] += coin_combi[j-arr[i]];
                // if(j==0) System.out.print(arr[i]+"- ");
                // System.out.print(coin_combi[j]+ " ");
            }
            // System.out.println();
        }
        // System.out.println("====");
        // for(int i=0; i<=tar; i++) System.out.print(coin_combi[i] + " ");
        // System.out.println("====");
        return coin_combi[tar];
    }
    
}
