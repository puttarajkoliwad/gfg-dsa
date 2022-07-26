// problem statement: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/lps-official/ojquestion

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CountPalindromicSubstrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        int ans = countPalindromicSubstrings(input);
        System.out.println(ans);

        br.close();
    }

    public static int countPalindromicSubstrings(String str) {
        int count = 0;
        int n = str.length();
        boolean[][] dp = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                    count++;
                } else if (i == j - 1 && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = true;
                    count++;
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }
        return count;
    }
}
