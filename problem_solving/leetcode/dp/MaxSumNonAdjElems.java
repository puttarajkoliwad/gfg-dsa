// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/maximum_sum_non_adjacent_elements/topic
// hackerrank: https://www.hackerrank.com/challenges/max-array-sum/problem?h_r=internal-search

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MaxSumNonAdjElems {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max_non_adj_sum = maxSumOfNonAdjElems(arr);
        System.out.println(max_non_adj_sum);
    }
    public static int maxSumOfNonAdjElems(int[] arr){
        int n = arr.length;
        int old_included = 0;
        int old_excluded = 0;
        for(int i = 0; i < n; i++){
            int new_included = old_excluded + arr[i];
            // You can not choose both included and excluded for new_included, it will create a duplicacy for the previous array element. You will choose only one value old_excluded or old_included whichever is max, to avoid considering the prev arr elem twice.
            int new_excluded = Math.max(old_included, old_excluded);
            old_included = new_included;
            old_excluded = new_excluded;
            // System.out.println(old_included+" ;;; "+old_excluded);
        }
        return Math.max(old_included, old_excluded);
    }
    
}
