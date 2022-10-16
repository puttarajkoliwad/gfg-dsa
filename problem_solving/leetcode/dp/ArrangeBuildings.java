// Problem statement:  https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/arrange_buildings/topic

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrangeBuildings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long old_buildings = 1;
        long old_spaces = 1;
        for(int i=2; i<=n; i++){
            long new_buildings = old_spaces;
            long new_spaces = old_buildings + old_spaces;
            old_buildings = new_buildings;
            old_spaces = new_spaces;
        }
        // Why squaring? : for each combination of left side of the road, there are exact combinations on the same side of the road. This is like total outcomes possible for 2-dice probabilities.
        System.out.println((old_buildings + old_spaces) * (old_buildings + old_spaces));
    }
}
