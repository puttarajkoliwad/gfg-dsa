
public class BookOrphans {


    public static void main(String[] args) {
        int[] a = {2, 1, 0};
        System.out.println(distributeBooks(a, a.length));
    }

    static int distributeBooks(int[] b, int n){
        int count = 0;
        int sum = 0;
        int comp = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            sum += b[i];
            if(b[i] < comp){
                comp = b[i];
            }
        }
        if(sum%n != 0) return -1;

        int exact = sum / n;
        for (int i = 0; i < n; i++){
            count += Math.abs(b[i] - exact);
        }
        return count/2;
    }
    
}
