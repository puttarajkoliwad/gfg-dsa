// Problem statement: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lps-official/ojquestion
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class LongestPalindromicSubsequenceLength {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String str = br.readLine().trim();
      int lps_length = findLPS(str);
      System.out.println(lps);
    }

    public static int findLPS(String str){
      int res = 0;
      int[][] lps_table = new int[str.length()][str.length()];
      for(int j=0; j<str.length(); j++){
        for(int i=0; i<str.length(); i++){
          if(j<i) lps_table[i][j] = 0;
          else if(i==j) lps_table[i][j] = 1;
          else{
            if(str.charAt(i) == str.charAt(j)){
              lps_table[i][j] = lps_table[i-1][j-1] + 2;
            }else{
              lps_table[i][j] = Math.max(lps_table[j-1][i], lps_table[j][i+1]);
            }
          }
        }
      }
      return res;
    }
}
