// problem statement: https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/target-sum-subsets-official/ojquestion

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TargetSumSubsetRecusion {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int tar = Integer.parseInt(br.readLine());
        targetSumSubsetRecursion(arr, 0, "", 0, tar);
    }

    public static void targetSumSubsetRecursion(int[] arr, int idx, String set, int curr_sum, int tar){
        if(idx >= arr.length){
            if(curr_sum == tar){
                System.out.println(set+ ".");
            }
            return;
        }

        targetSumSubsetRecursion(arr, idx+1, set + arr[idx] + ", ", curr_sum + arr[idx], tar);
        targetSumSubsetRecursion(arr, idx+1, set, curr_sum, tar);
    }
}
