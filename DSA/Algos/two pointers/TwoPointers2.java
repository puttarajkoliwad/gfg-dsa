// challenge link: https://www.hackerrank.com/challenges/angry-children/problem

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// class name to be renamed to Solution in Hackerrank
public class TwoPointers2 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        List<Integer> li = new ArrayList<Integer>();
        String line;
        while((line = br.readLine()) != null && line != ""){
            li.add(Integer.parseInt(line));
        }
        int res = twoPointers(li, k); 
        System.out.println(res);
    }

    static int twoPointers(List<Integer> li, int k) {
        Collections.sort(li);
        int n = li.size();

        //Initializing minp to index '0' and maxp to index 'k-1', cause we need sub-array of length 'k'
        int i=0, j=k-1;
        int min = Integer.MAX_VALUE;
        while(j<n){
            int diff = li.get(j) - li.get(i);
            if(diff < min) min = diff;
            i++; j++;
        }
        return min;
    }
}
