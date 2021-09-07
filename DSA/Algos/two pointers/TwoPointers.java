import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//input
// 6 6
// 1 2 3 4 5 6

//output
// 2
public class TwoPointers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split("\\s");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] a = new int[n];
        String[] as = br.readLine().split("\\s");
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(as[i]);
        }
        int paircount = twoPointers(a, n, k);
        System.out.println(paircount);

    }

    static int twoPointers(int[] a, int n, int k) {
        int paircount = 0;
        Arrays.sort(a);
        int i=0, j=n-1;
        while(i<j){
            if(a[i] + a[j] > k) j--;
            else{
                if(a[i] + a[j] == k) paircount++;
                i++;
            }
        }
        return paircount;
    }
    
}
