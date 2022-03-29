// Problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count_binary_strings/topic

// This is just the fibonacci problem with different wording
// Hint: If you do not understand how the solution is designed, follow the same steps and write the answer for a case where no consecutive 1s OR no consecutive 0s are allowed and observe why the answer is always a constant value of '2' for any given length. 

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountBinaryStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int old_zeros = 1, old_ones = 1;
        for( int i=2; i<=n; i++ ){
            int new_zeros = old_ones;
            int new_ones = old_zeros + old_ones;
            old_zeros = new_zeros;
            old_ones = new_ones;
        }

        System.out.println(old_zeros + old_ones);
    }    
}
