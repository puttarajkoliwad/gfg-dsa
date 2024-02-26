// problem statement:
// https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/practice-problems/algorithm/lola-and-candies-36b57b1b/

// We can use sum of first N odd numbers formula here

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class AliceAndCandies {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Integer.parseInt(br.readLine());
    long count = 0;
    if (n % 2 == 1)
      count++; // For odd numbers there will be least 1 set which is itself. It is the only set lying in the second half of the 'n'. So we can set count =1 for this and not traverse 2nd half.
    for(long i = 1; i < n / 2; i += 2) {
      long n1 = i / 2;
      long n2 = (long) Math.sqrt(n + n1 * n1);
      if (n2 * n2 - n1 * n1 == n) {
        count++;
      }
    }

    System.out.println(count);
  }
}