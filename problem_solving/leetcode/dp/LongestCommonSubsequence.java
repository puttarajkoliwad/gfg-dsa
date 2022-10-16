// problem statement: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lcs-official/ojquestion

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LongestCommonSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine().trim();
        String str2 = br.readLine().trim();

        int lcs_length = longestCommonSubsequence(str1, str2);
        System.out.println(lcs_length);

        br.close();
    }

    public static int longestCommonSubsequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = str1.length(); i >= 0; i--) {
            for (int j = str2.length(); j >= 0; j--) {
                if (i == str1.length() || j == str2.length())
                    dp[i][j] = 0;
                else {
                    if (str1.charAt(i) == str2.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                    }
                }
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }
        return dp[0][0];
    }
}