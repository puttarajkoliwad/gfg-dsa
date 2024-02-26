
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//sample test case input:
// 7
// 6 3 -2 4 -1 0 -5
// 4
// 0 4
// 0 6
// 2 6
// 3 5

//output
// 10 5 -4 3 
class PrefixSum{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] numString = br.readLine().split("\\s");
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(numString[i]);
        }
        int m = Integer.parseInt(br.readLine());
        int[][] q = new int[m][2];
        for(int i=0; i<m; i++){
            String[] qi = br.readLine().split("\\s");
            q[i][0] = Integer.parseInt(qi[0]);
            q[i][1] = Integer.parseInt(qi[1]);
        }

        int[] solution = prefixSum(a, n, q, m);

        for(int s:solution){
            System.out.print(s+" ");
        }
    }

    private static int[] prefixSum(int[] a, int n, int[][] q, int m) {
        int[] solution = new int[m];
        int[] ps = new int[n];
        ps[0] = a[0];
        for(int i=1; i<n; i++){
            ps[i] = ps[i-1] + a[i];
        }
        for(int i=0; i<m; i++){
            int start = q[i][0];
            int end = q[i][1];
            solution[i] = start == 0 ? ps[end] : ps[end] - ps[start-1];
        }
        return solution;
    }
}
