// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/zero-one-knapsack-official/ojquestion

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class KnapSack01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] vals = new int[n];
        int[] weights = new int[n];
        String[] s_vals = br.readLine().split("\s");
        String[] s_weights = br.readLine().split("\s");
        for(int i=0; i<n; i++) {
            vals[i] = Integer.parseInt(s_vals[i]);
            weights[i] = Integer.parseInt(s_weights[i]);
        }
        int volume = Integer.parseInt(br.readLine());
        int max_gain = knapsack(vals, weights, volume);
        System.out.println("max_gain: " + max_gain);
    }

    public static int knapsack(int[] vals, int[] weights, int volume) {
        int n = vals.length;
        int[][] gains = new int[n+1][volume+1];
        // System.out.print("XX ");
        // for(int i=0; i<=volume; i++) System.out.print(i+ " ");
        // System.out.println();
        for(int i = 1; i <= n; i++) {
            for(int j=1; j<=volume; j++){
                // System.out.println("i: " + i + ",  j: " + j);
                if(j < weights[i-1]) gains[i][j] = gains[i-1][j];
                else gains[i][j] = Math.max(gains[i-1][j], vals[i-1] + gains[i-1][j-weights[i-1]]);
                // if(i==0) System.out.print("0- ");
                // else if(j==0) System.out.print(weights[i-1]+"- ");
                // System.out.print(gains[i][j] + " ");
            }
            // System.out.println();
        }
        return gains[n][volume];
    }
}
