// Problem statement: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lps-official/ojquestion
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class LongestPalindromicSubsequenceLength {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str = br.readLine().trim();
      int lps_length = findLPSLength(str);
      System.out.println(lps_length);
    }

    public static int findLPSLength(String str){
      int res = 0;
      int[][] lps_table = new int[str.length()][str.length()];
      for(int j=0; j<str.length(); j++){
        for(int i=str.length()-1; i>=0; i--){
          if(j<i) lps_table[i][j] = 0;
          else if(i==j) lps_table[i][j] = 1;
          else{
            if(str.charAt(i) == str.charAt(j)){
              lps_table[i][j] = lps_table[i+1][j-1] + 2;
            }else{
              lps_table[i][j] = Math.max(lps_table[i][j-1], lps_table[i+1][j]);
            }
          }

          if(lps_table[i][j] > res) res = lps_table[i][j];
        }
      }

      // for(int i=0; i<lps_table.length; i++){
      //   if(i==0){
      //     for(int j=0; j<lps_table.length; j++){
      //       if(j==0) System.out.print(" ");
      //       System.out.print(" "+str.charAt(j));
      //     }
      //     System.out.println();
      //   }
      //   for(int j=0; j<lps_table.length; j++){
      //     if(j==0) System.out.print(str.charAt(i) + " ");
      //     System.out.print(lps_table[i][j] + " ");
      //   }
      //   System.out.println();
      // }
      return res;
    }
}
