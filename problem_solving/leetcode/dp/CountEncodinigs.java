// Problem statement: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/count_encodings/topic

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountEncodinigs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int encodeWays = countEncodings(str);
        System.out.println(encodeWays);
    }

    public static int countEncodings(String str){
        int n = str.length();
        int[] encs = new int[n];
        if(str.charAt(0) == '0'){
            return 0;
        }else{
            encs[0] = 1;
        }
        for(int i=1; i<n; i++){
            char prev = str.charAt(i-1);
            char curr = str.charAt(i);
            if(prev == '0' && curr == '0'){
                return 0;
            }else if(prev == '0'){
                encs[i] = encs[i-1];
            }else if(prev != '0' && curr == '0'){
                if(prev == '1' || prev == '2') encs[i] = encs[i-2];
                else return 0;
            }else{
                encs[i] = encs[i-1];
                if(Integer.parseInt(str.substring(i-1, i+1)) <= 26) encs[i] += (i>=2 ? encs[i-2]:1);
            }
        }
        return encs[n-1];
    }
}
