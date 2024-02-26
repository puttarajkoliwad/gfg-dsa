import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PartitionIntoSubsets {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
       int k = Integer.parseInt(br.readLine());
       int parts = partitionIntoSubsets(n, k);
       System.out.println(parts);
    }

    public static int partitionIntoSubsets(int n, int k){
        int[][] parts = new int[k+1][n+1];
        for(int i=0; i<=k; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0) parts[i][j] = 0;
                else{
                    if(i > j) parts[i][j] = 0;
                    else if(i==j) parts[i][j] = 1;
                    else{
                        parts[i][j] = i * parts[i][j-1] + parts[i-1][j-1];
                    }
                }
            }
        }
        return parts[k][n];
    }
}
