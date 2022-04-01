// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/tilling_with_2_*_1_tiles/topic

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TilingTwoAndOne{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tiles = Integer.parseInt(br.readLine());
        int[] ways = new int[tiles];
        ways[0] = 1;
        ways[1] = 2;
        for(int i=2; i<tiles; i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }
        System.out.println(ways[tiles-1]);
    }
}