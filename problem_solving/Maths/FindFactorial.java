// Given a number N, find its factorial.
// consider type overflow scenarios (byte -> short -> int -> long)
// input: 4, output: 24, input: 5: 4, output: 120
// Time complexity: O(N), space complexity: O(1)

// Hint: Do NOT use recusrsion. If we use recursion, for each level, a stack allocation is used. Which will add up to space complexity of O(N) for this problem.

class FindFactorial{
  static int findFactorial(int num){
    int res = 2;
    for(int i=3; i<=num; i++){
      res *= i;
    }

    return res;
  }
  public static void main(String[] args) {
    System.out.println(findFactorial(5));
  }
}