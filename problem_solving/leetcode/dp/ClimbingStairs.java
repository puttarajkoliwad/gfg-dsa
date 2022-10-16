// https://leetcode.com/problems/climbing-stairs/

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClimbingStairs {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] qb = new int[n+1];
        qb[0] = 1;

        // Read the below discussion before referring to the solution code.
        /*
        Why direct permutaion formula does not work here?
        ================================================================
        -- This is a case of Combination, not Permutation. Because order does not matter here.
        -- If we somehow make it as a Permutation problem, it would be similar to 3rd scenario of Permutation where there are muliple sets.
        But, in this case all the 'n' sets are identical. Then on top of this we will have to apply repetition allowed scenario, but again
        we will have to lookout for negative scenarios when a series of choices does not yield the desired out put, like choosing {2, 2} when n = 3.
        So, we will have to make intelligent choices. This is why we can't directly apply Permutation&Combination formula here.
        */

        int ans = climbStairsDpMemoization(n, qb);
        int ans2 = climbStairsDpMemoizationWithoutArray(n);
        int ans3 = climbStairsDpTabulation(n);
        System.out.println(ans);
        System.out.println(ans2);
        System.out.println(ans3);

        br.close();
    }

    // using DP memoization method
    public static int climbStairsDpMemoization(int n, int[] qb){
        if(n < 0) return 0;

        if(qb[n] > 0){
            return qb[n];
        }

        if(n==0){
            return 1;
        }else if(n==1){
            return 1;            
        }else{
            qb[n-1] = climbStairsDpMemoization(n-1, qb);
            qb[n-2] = climbStairsDpMemoization(n-2, qb);
            return qb[n-1]+qb[n-2];
        }
    }

    //using DP memoization without arrays
    public static int climbStairsDpMemoizationWithoutArray(int n){
        int prev = 1;
        int curr = 1;
        if(n==0 || n==1) return 1; //we can also do return prev or return curr, but that will take more memory?
        int next = prev+curr;
        int i=2;
        while(i<=n){
            next = prev+curr;
            prev = curr;
            curr = next;
            i++;
        }
        return next;
    }

    //using DP Tabulation method
    public static int climbStairsDpTabulation(int n){
        int[] qb = new int[n+1];
        qb[0] = 1;
        for(int i=1; i<=n; i++){
            if(i==1) qb[i] = qb[i-1];
            else{
                qb[i] = qb[i-1]+qb[i-2];
            }
        }
        return qb[n];
    }
    
}
