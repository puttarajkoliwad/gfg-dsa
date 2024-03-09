// Given two integers a, b, find the GCD or HCF of these two values.
// input: a = 20, b = 28; output: 4
// space complexity O(1), time complexity < O(log(min(a,b)))

package Maths;

class GcdHcf{
  static int findGCD(int bigger, int smaller){
    if(smaller == 0){
      return bigger;
    }else{
      return findGCD(smaller, bigger%smaller);
    }
  }

  public static void main(String[] args) {
    int a = 20, b=28;
    int res = a > b ? findGCD(a, b) : findGCD(b, a);
    System.out.println(res);
  }
}
