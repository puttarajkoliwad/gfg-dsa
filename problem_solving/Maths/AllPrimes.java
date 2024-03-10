// Sieve of Eratosthenes
// Given an integer N, print all the prime numbers in the range 2..N
// testcases: 10 => 2 3 5 7; 20 => 2 3 5 7 11 13 17 19; 50 => 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 
// space complexity: O(N), time complexity: O(n*log(log(N))).

import java.util.Arrays;

class AllPrimes{
  static void sieveOfEratosthenes(int n){
    if(n<=1) return;

    boolean[] isPrime = new boolean[n+1];
    Arrays.fill(isPrime, true);
    // System.out.println(isPrime[0]);

    // All the prime factors of a number always lie within it's square root. We eliminate all multiples till N from isPrime array for each of these prime factors. the rest ones are prime numbers within the range 2..N.
    for(int i=2; i*i<=n; i++){
      if(isPrime[i]){
        for(int j=2; i*j<=n; j++){
          isPrime[i*j] = false;
        }
      }
    }

    for(int i=2; i<=n; i++){
      if(isPrime[i]) System.out.print(i + " ");
    }
    System.out.println();
  }

  static void optimizedSieveOfEratosthenes(int n){
    // We reject composites from j = i*i, cause the multiples of `j` less than `i*i` will be of the form `j*(i-1)`, `j*(i-2)`, `j*(i-3)`...
    // We will print the number at the starting of the inner loop itself. With this, we can avoid one extra loop.
    // The time and space complexity of this optimized implementation of Sieve-of-Eratosthenes will also be asymptotically same as the previous implementation. Just that we avoid an extra loop and some extra iterations

    boolean[] isPrime = new boolean[n+1];
    Arrays.fill(isPrime, true);

    for(int i=2; i<=n; i++){
      if(isPrime[i]){
        System.out.print(i + " ");
        for(int j=i*i; j<=n; j+=i){
          isPrime[j] = false;
        }
      }
    }

    System.out.println();
  }
  
  public static void main(String[] args) {
    sieveOfEratosthenes(10);
    optimizedSieveOfEratosthenes(10);
    sieveOfEratosthenes(20);
    optimizedSieveOfEratosthenes(20);
    sieveOfEratosthenes(50);
    optimizedSieveOfEratosthenes(50);
  }
}