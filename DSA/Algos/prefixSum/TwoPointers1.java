//https://www.hackerrank.com/challenges/pairs/problem

import java.util.Collections;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//Input
// 5 2
// 1 5 3 4 2

//Output
// 3

//ClassName to be renamed if copy pasting the code to hackerrank ide
class TwoPointers1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split("\\s");
        int n = Integer.parseInt(nk[0]);
        long k = Long.parseLong(nk[1]);
        List<Integer> a = new ArrayList<Integer>();
        String[] as = br.readLine().split("\\s");
        for(String s:as){
            a.add(Integer.parseInt(s));
        }
        long paircount = twoPointers(a, n, k);
        System.out.println(paircount);
    }


    static long twoPointers(List<Integer> a, int n, long k) {
        long paircount = 0;
        int i=0, j=1;
        Collections.sort(a);
        while(j<n){
            int diff = a.get(j) - a.get(i);
            if(diff > k){
                i++;
            }else{
                if(diff == k) paircount++;
                j++;
            }
        }
        return paircount;
    }
    

}
