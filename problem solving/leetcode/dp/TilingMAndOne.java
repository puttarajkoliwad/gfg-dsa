// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/tiling_with_mx1_tiles/topic

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TilingMAndOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int tiling_ways = tilingMAndOne(m, n);
        System.out.println(tiling_ways);   
    }

    public static int tilingMAndOne(int m, int n){
        int[] tiling_combi = new int[n];
        if(m > n) return 1;
        // tiling_combi[0] = 1;
        for(int i = 0; i < n; i++) {
            if(i<m-1) tiling_combi[i] = 1;
            else{
                if(i==m-1) tiling_combi[i] = 2;
                else{
                    tiling_combi[i] = tiling_combi[i-1]+ tiling_combi[i-m];
                }
            }
        }
        return tiling_combi[n-1];
    }
}
