// problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count_a_+_b_+_c_subsequences/topic

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountSubsequences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] chs = str.toCharArray();
        int a = 0, ab = 0, abc = 0;
        for(char c: chs){
            if(c == 'a') a = 2 * a + 1;
            else if(c == 'b') ab = 2 * ab + a;
            else abc = 2 * abc + ab;
        }
        System.out.println(abc);
    }
}
