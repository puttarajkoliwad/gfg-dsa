// Given an integer N, check if it is a prime number
// test cases: 1 => false, 11 => true, 15 => false
// Space complexity: O(1), time complexity: O(sqrt(N))

/*
  - We will deal with a few numbers such as 1, 2, and 3, and the numbers which are divisible by 2 and 3 in separate cases.
  - For the remaining numbers, we iterate from 5 to sqrt(n) and check for each iteration whether (that value) or (that value + 2) divides n or not and increment the value by 6 [because any prime can be expressed as 6n+1 or 6n-1].
  - If we find any number that divides, we return false, else true.

*/

class IsPrime{
  static boolean isPrime(int num){
    if(num == 1) return false;
    if(num == 2 || num == 3) return true;
    if(num %2 == 0 || num % 3 ==0) return false;

    for(int i=5 ; i*i<num; i += 6){
      if(num%i == 0 || num%(i+2) == 0) return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    System.out.println(isPrime(1));
    System.out.println(isPrime(11));
    System.out.println(isPrime(15));
  }
}