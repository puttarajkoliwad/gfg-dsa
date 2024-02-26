// https://leetcode.com/problems/largest-rectangle-in-histogram/#

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MaximumAreaHistogram {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] strin = br.readLine().split("\\s+");
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(strin[i]);
        }

        System.out.println(largestRectangleArea(arr));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0; //since non-negative integers
        
        //left_array computation
        for(int i=0; i<n; i++){
            int k=i-1;
            while(k >=0){
                if(heights[k] < heights[i]){
                    break;
                }
                k--;
            }
            if(k < 0) k++;
            left[i] = heights[k] < heights[i] ? k+1 : k;
        }
        
        //right_array
        for(int i=n-1; i>=0; i--){
            int k=i+1;
            while(k < n){
                if(heights[k] < heights[i]){
                    break;
                }
                k++;
            }
            if(k == n) k--;
            right[i] = heights[k] < heights[i] ? k-1 : k;
            int curr_max = (right[i] - left[i] + 1) * heights[i];
            if(max < curr_max) max = curr_max;
        }
        
        return max;     
    }
}
