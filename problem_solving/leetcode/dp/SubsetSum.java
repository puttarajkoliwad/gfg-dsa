// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/target-sum-subsets-dp-official/ojquestion

// This problem is referred to as target-sum-subsets problem, not just subset-sum problem

// This is different from the triplet-sum problem where we used 2-pointers algorithm. The current problem focuses on considering subsets of any length unlike just the pairs/triplets. Hence, we can't use 2-pointers algo here.

// There is one more variant subset-sum problem, which focuses where we append the sum at every index of the array, which means, we only consider the scenario of all the elements included or the first-to-N elements included. That problem doesnt cover the scenario of non-last elements excluded. So, we can't use that approach here.

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class SubsetSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int tar = Integer.parseInt(br.readLine());
        boolean subset_present = hasSubsetSum(arr, tar);
        System.out.println("Subset possible: "+ subset_present);
    }

    public static boolean hasSubsetSum(int[] arr, int tar){
        int rows = arr.length + 1;
        int cols = tar + 1;
        boolean[][] dp_sum = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(j==0) dp_sum[i][j] = true;
                else if(i==0) dp_sum[i][j] = false;
                else{
                    if(arr[i-1] > j) dp_sum[i][j] = dp_sum[i-1][j];
                    else dp_sum[i][j] = dp_sum[i-1][j] || dp_sum[i-1][j-arr[i-1]];
                }
            }
        }

        /* System.out.println("======");
        System.out.print("   ");
        for(int j=0; j<cols; j++) {
            System.out.print(j+" ");
        }
        System.out.println("");
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(j==0){
                    if(i==0) System.out.print("XX ");
                    else System.out.print(arr[i-1]+"- ");
                }
                if(dp_sum[i][j]) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
        System.out.println("======"); */
        return dp_sum[rows-1][cols-1];
    }
}
