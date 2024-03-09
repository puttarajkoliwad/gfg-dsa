// Given a numbe Nr, count the number of digits in it and print it out
// input: 234, output: 3
// Space complexity: O(1), time complexity: O(D), D => number of digits in N

public class CountDigits{

  static int countDigits(int num){
    int count = 0;
    while(num >0){
      num /= 10;
      count++;
    }
    return count;
  }
  public static void main(String[] args) {
    // int num = 456;
    System.out.println(countDigits(45678));
  }
}