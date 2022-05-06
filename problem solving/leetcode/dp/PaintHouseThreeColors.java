// Problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint_house/topic

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class PaintHouseThreeColors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mns = br.readLine().split("\s");
        int houses = Integer.parseInt(mns[0]);
        int colors = 3;
        int[][] costs = new int[houses][colors];
        for(int i = 0; i < houses; i++){
            String[] sCosts = br.readLine().split("\s");
            for(int j = 0; j < sCosts.length; j++){
                costs[i][j] = Integer.parseInt(sCosts[j]);
            }
        }
        long min_paint_cost = paintHouseThreeColors(costs, colors, houses);
        System.out.println(min_paint_cost);
    }

    public static long paintHouseThreeColors(int[][] costs, int colors, int houses){
        long c1 = costs[0][0];
        long c2 = costs[0][1];
        long c3 = costs[0][2];
        
        for(int i=1; i<houses; i++){
            long new_c1 = costs[i][0] + Math.min(c2, c3);
            long new_c2 = costs[i][1] + Math.min(c1, c3);
            long new_c3 = costs[i][2] + Math.min(c1, c2);
            c1 = new_c1; c2 = new_c2; c3 = new_c3;
        }
        return Math.min(c1, Math.min(c2, c3));
    }
}
