// Given a number N, find the Number of Trailing Zeros in the factorial of the number.
// input: 8, output: 1, 10 => 2, 15 => 3, 20 => 4, 25 => 6, 100 => 24
// space complexity: O(1), time complexity: O(log(N)) with base 5

/*
  The idea is to consider prime factors of a factorial n. A trailing zero is always produced by prime factors 2 and 5. Our task is done if we can count the number of 5s and 2s. Consider the following examples:

n = 5: There is one 5 and 3 2s in prime factors of 5! (2 * 2 * 2 * 3 * 5). So a count of trailing 0s is 1.


n = 11: There are two 5s and eight 2s in prime factors of 11! (2 8 * 34 * 52 * 7). So the count of trailing 0s is 2.
We can easily observe that the number of 2s in prime factors is always more than or equal to the number of 5s. So if we count 5s in prime factors, we are done.

Following is the summarized formula for counting trailing 0s:

Trailing 0s in n! = Count of 5s in prime factors of n! = floor(n/5) + floor(n/25) + floor(n/125) + ....
 
 */

class FactorialTrailingZeroes{
  static int factorialTrailingZeroes(int num){
    int res =0;
    for(int i=5; i<=num; i *= 5){
      res += (num/i);
      // num /= 5;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(factorialTrailingZeroes(20));
    System.out.println(factorialTrailingZeroes(25));
    System.out.println(factorialTrailingZeroes(100));
  }
}