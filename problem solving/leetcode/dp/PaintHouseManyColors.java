// Problem statement : https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint_house_many_colors/topic

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class PaintHouseManyColors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mns = br.readLine().split("\s");
        int houses = Integer.parseInt(mns[0]);
        int colors = Integer.parseInt(mns[1]);
        int[][] costs = new int[houses][colors];
        for(int i = 0; i < houses; i++){
            String[] sCosts = br.readLine().split("\s");
            for(int j = 0; j < sCosts.length; j++){
                costs[i][j] = Integer.parseInt(sCosts[j]);
            }
        }
        long min_paint_cost = paintHouseManyColors(costs, colors, houses);
        System.out.println(min_paint_cost);
    }

    public static long paintHouseManyColors(int[][] costs, int colors, int houses){
        long[] costArr = new long[colors];
        long old_min = Math.min(costs[0][0], costs[0][1]), old_sec_min = Math.max(costs[0][1], costs[0][0]);
        int min_index = costs[0][0] <= costs[0][1] ? 0 : 1;
        int sec_min_index = min_index == 0 ? 1 : 0;
        for(int i=0; i<colors; i++){
            costArr[i] = costs[0][i];
            if(costArr[i] <= old_min && i != min_index){
                old_sec_min = old_min;
                sec_min_index = min_index;
                old_min = costArr[i];
                min_index = i;
            }else if(costArr[i] <= old_sec_min && sec_min_index != i){
                old_sec_min = costArr[i];
                sec_min_index = i;
            }
        }

        for(int i=1; i<houses; i++){
            for(int j=0; j<2;j++){
                if(j==min_index){
                    costArr[j] = old_sec_min + costs[i][j];
                }else{
                    costArr[j] = old_min + costs[i][j];
                }
            }

            // declare new base-comparison values
            long new_min = Math.min(costArr[0], costArr[1]), new_sec_min = Math.max(costArr[1], costArr[0]);
            int new_min_index = costArr[0] <= costArr[1] ? 0 : 1;
            int new_sec_min_index = min_index == 0 ? 1 : 0;

            for(int j=2; j<colors; j++){
                //update the array value first
                if(j==min_index){
                    costArr[j] = old_sec_min + costs[i][j];
                }else{
                    costArr[j] = old_min + costs[i][j];
                }

                //handle the new base comparison values
                if(costArr[j] <= new_min){
                    new_sec_min = new_min;
                    new_sec_min_index = new_min_index;
                    new_min = costArr[j];
                    new_min_index = j;
                }else if(costArr[j] < new_sec_min){
                    new_sec_min = costArr[j];
                    new_sec_min_index = j;
                }
            }

            old_min = new_min;
            old_sec_min = new_sec_min;
            min_index = new_min_index;
            sec_min_index = new_sec_min_index;
        }
        return Math.min(old_min, old_sec_min);
    }
}