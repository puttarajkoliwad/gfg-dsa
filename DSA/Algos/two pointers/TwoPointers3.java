// Trapping Rain Wanter Problem leetcode#42
// challenge: https://leetcode.com/problems/trapping-rain-water/
// tutorial: https://www.youtube.com/watch?v=C8UjlJZsHBw

//related problems: Maximum Area Histogram, in problem_solving branch


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class TwoPointers3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];
        String[] strhts = br.readLine().split("\\s+");
        for(int i = 0; i<n; i++){
            heights[i] = Integer.parseInt(strhts[i]);
        }

        int trapped_water = twoPointers(n, heights);
        System.out.println(trapped_water);
    }

    // In this problem we are applying 2-pointers algo to an unsorted array
    public static int twoPointers(int n, int[] a){
        int trapped_water = 0;
        int l_pointer = 1;
        int r_pointer = a.length - 2;
        int l_max = a[l_pointer] > a[0] ? a[l_pointer]:a[0];
        int r_max = a[r_pointer] > a[n-1] ? a[r_pointer]:a[n-1];
        while(l_pointer <= r_pointer){
            if(l_max < r_max){
                if(a[l_pointer] < l_max){
                    trapped_water += l_max - a[l_pointer];
                }else{
                    l_max = a[l_pointer];
                }
                l_pointer++;
            }else{
                if(a[r_pointer] < r_max){
                    trapped_water += r_max - a[r_pointer]; 
                }else{
                    r_max = a[r_pointer];
                }
                r_pointer--;
            }
        }
        
        return trapped_water;
    }
}
