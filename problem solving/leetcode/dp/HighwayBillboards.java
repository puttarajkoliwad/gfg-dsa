// problem statement: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/highway-billboard-official/ojquestion#!

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HighwayBillboards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int bbs = Integer.parseInt(br.readLine());
        String[] spos = br.readLine().split("\s");
        int[] pos = new int[bbs];
        for(int i=0; i<bbs; i++){
            pos[i] = Integer.parseInt(spos[i]);
        }
        String[] srev = br.readLine().split("\s");
        int[] rev = new int[bbs];
        for(int i=0; i<bbs; i++){
            rev[i] = Integer.parseInt(srev[i]);
        }
        int interval = Integer.parseInt(br.readLine());
        int profit = highwayBillboards1(length, bbs, pos, rev, interval);
        int profit2 = highwayBillboards2(length, bbs, pos, rev, interval);
        System.out.println(profit + "   " + profit2);
    }

    public static int highwayBillboards1(int length, int bbs, int[] pos, int[] rev, int interval){
        // This is O(m^2) solution where m = number of billboards(bbs)
        int max = 0;
        int[] profits = new int[bbs];
        profits[0] = rev[0];
        for(int i=1; i<bbs; i++){
            int temp = rev[i];
            for(int j=i-1; j>=0; j--){
                if(pos[i] - pos[j] > interval){
                    if(profits[j] + rev[i] > temp){
                        temp = profits[j] + rev[i];
                    }
                }
            }
            profits[i] = temp;
        }

        for(int i=0; i<bbs; i++){
            if(profits[i] > max) max =profits[i];
            // System.out.print(profits[i] + " ");
        }
        return max;
    }

    public static int highwayBillboards2(int length, int bbs, int[] pos, int[] rev, int interval){
        int[] dp = new int[length+1];
        HashMap<Integer, Integer> kv = new HashMap<Integer, Integer>();
        for(int i = 0; i < bbs; i++){
            kv.put(pos[i], rev[i]);
        }
        dp[0] = 0;
        for(int i=1; i<=length; i++){
            if(!kv.containsKey(i)){
                dp[i] = dp[i-1];
            }else{
                int includeCurrent = kv.get(i);
                int excludeCurrent = dp[i-1];
                if(i-interval >0 ) includeCurrent += dp[i-interval-1];
                dp[i] = Math.max(includeCurrent, excludeCurrent);
            }
        }
        return dp[length];
    }
}
