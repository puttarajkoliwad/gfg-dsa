// Given two integers a, b, return their LCM
// input: (15, 20) => 60, (2, 8) => 8, (3, 7) => 21
// space complexity O(1), time complexity O(log(min(a,b)))

// formula used: a * b = LCM(a,b) * HCF(a,b)

// prerequisites: './GcdHcf.java'

// package Maths;
// import Maths.GcdHcf;

class Lcm{
  static int findHCF(int larger, int smaller){
    if(smaller == 0) return larger;
    else return findHCF(smaller, larger%smaller);
  }

  static int findLCM(int a, int b){
    int hcf = a > b ? findHCF(a, b) : findHCF(b, a);
    return (a*b)/hcf;
  }
  
  public static void main(String[] args) {
    int a = 15, b = 20;
    System.out.println(findLCM(a, b));
    System.out.println(findLCM(2, 8));
    System.out.println(findLCM(3, 7));
  }
}