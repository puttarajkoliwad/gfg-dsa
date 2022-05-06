// Problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/unbounded-knapsack-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KnapSackUnbound {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] vals = new int[n];
        int[] caps = new int[n];
        String[] sVals = br.readLine().split("\s");
        String[] sCaps = br.readLine().split("\s");
        for(int i=0; i<n; i++){
            vals[i] = Integer.parseInt(sVals[i]);
            caps[i] = Integer.parseInt(sCaps[i]);
        }
        int vol = Integer.parseInt(br.readLine());
        int max_gain1 = knapSackUnboundPermuteApproach(vals, caps, vol);
        // int max_gain2 = knapSackUnboundCombiApproach(vals, caps, vol);
        System.out.println("max_gain1 = " + max_gain1);
    }

    public static int knapSackUnboundPermuteApproach(int[] vals, int[] caps, int vol){
        int n = vals.length;
        int[] gains = new int[vol+1];
        gains[0] = 0;
        for(int j=1; j<= vol; j++){
            int max = 0;
            for(int i=0; i<n; i++){
                if(caps[i] <= j){
                    int curr = vals[i] + gains[j-caps[i]];
                    if(max < curr) max = curr;
                    gains[j] = max;
                }
            }
        }
        return gains[vol];
    }
}
