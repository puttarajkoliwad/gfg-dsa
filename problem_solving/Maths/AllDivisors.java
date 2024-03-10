// Given an integer N, print all its divisors in the increasing order of their values.
// testcases: 10 => 1 2 5 10; 100 => 1 2 4 5 10 20 25 50 100
// Space complexity: O(1), time complexity: O(sqrt(N))

class AllDivisors{
  static void printAllDivisors(int n){
    int i=1;
    
    for(;i*i<=n;i++){
      if(n%i == 0) System.out.print(i + " ");
    }

    for(;i>=1;i--){
      if(n%i == 0){
        if(i != n/i) System.out.print(n/i + " ");
      }
    }
    System.out.println();
  }
  
  public static void main(String[] args) {
    printAllDivisors(10);
    printAllDivisors(100);
    printAllDivisors(125);
  }
}