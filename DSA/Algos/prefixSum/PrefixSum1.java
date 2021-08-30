import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Hackerrank Array Manipulation problem
//https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays


//ClassName should be renamed to "Solution" while using this code in hackerrank ide.
class PrefixSum1{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split("\\s");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] qs = new int[m][3];

        for(int[] q:qs){
            String[] qstr = br.readLine().split("\\s");
            q[0] = Integer.parseInt(qstr[0]);
            q[1] = Integer.parseInt(qstr[1]);
            q[2] = Integer.parseInt(qstr[2]);
        }

        long max = prefixSum(n, m, qs);

        System.out.println(max);
    }

    static long prefixSum(int n, int m, int[][] qs) {
        long[] ps = new long[n];

        for(int[] q:qs){
            int start = q[0]-1;
            int end = q[1];
            int queryvalue = q[2];
            ps[start] += queryvalue;
            if(end < n) ps[end] -= queryvalue;
        }

        long max = ps[0];
        for(int i=1; i<n; i++){
            ps[i] += ps[i-1];
            if(max < ps[i]) max = ps[i];
        }
        return max;
    }
}