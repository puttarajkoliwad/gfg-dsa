// Given an integer 'n' express it in its prime factors
// testcases: 12 => 2 2 3; 315 => 3 3 5 7
// space complexity: O(1), Time complexity: O(sqrt(n))

// concept Any number can be expressed as Product of Powers of it's prime factors. i.e., 12 => 2^2 * 3^1, 315 => 3^2 * 5^1 * 7^1
// prerequisites: './IsPrime.java'


class PrimeFactors{
  static void printPrimeFactors(int n){
    if(n==1) return; //

    // handle for 2 as a factor
    while(n%2==0){
      System.out.print(2 + " ");
      n /= 2;
    }

    // handle for 3 as a factor
    while(n%3==0){
      System.out.print(3 + " ");
      n /= 3;
    }

    for(int i=5; i*i<=n; i+=6){
      while(n%i == 0){
        System.out.print(i + " ");
        n /= i;
      }

      while(n%(i+2) == 0){
        System.out.print(i+2 + " ");
        n /= (i+2);
      }
    }

    if(n > 3) System.out.print(n);

    System.out.println();
  }
  
  public static void main(String[] args) {
    printPrimeFactors(12);
    printPrimeFactors(315);
  }
}