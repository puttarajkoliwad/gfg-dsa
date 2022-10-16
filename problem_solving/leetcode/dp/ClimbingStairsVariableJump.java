// Problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-variable-jumps-official/ojquestion

// Explanantion 1: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb_stairs_with_variable_jumps/topic 
// Explanantion 2: https://www.youtube.com/watch?v=uNqoQ0sNZCM&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=3

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ClimbingStairsVariableJump{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] jumps = new int[n];
        // String[] jumps_str = br.readLine().split("\s");
        for(int i=0; i<n; i++) {
            jumps[i] = Integer.parseInt(br.readLine());
        }

        int solution = climbStairsVariableJump(jumps);
        System.out.println(solution);
    }

    //solution using DP Tabulation
    public static int climbStairsVariableJump(int[] arr){
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i=n-1; i>=0; i--){
            for(int j=1; j<=arr[i] && i+j<=n; j++){
                dp[i] += dp[i+j];
            }
        }
        return dp[0];
    }
}