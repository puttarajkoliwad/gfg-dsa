// Permutation: where order of the elements matters. Eg. {2, 3} and {3, 2} are considered different entries and count 1 each, i.e. 2 entries in total.
// Problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/coin-change-permutations-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CoinChangePermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int tar = Integer.parseInt(br.readLine());
        int total_ways = coinChangePermutaion(arr, tar);
        System.out.println("total_ways = " + total_ways);
    }

    public static int coinChangePermutaion(int[] arr, int tar){
        int n = arr.length;
        int[] permutes = new int[tar+1];
        permutes[0] = 1;
        for(int j=1; j<=tar; j++){
            for(int i=0; i<n; i++){
                if(j-arr[i] >=0 ) permutes[j] += permutes[j-arr[i]];
            }
        }
        return permutes[tar];
    }
}
