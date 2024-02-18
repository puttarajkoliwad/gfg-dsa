/*
  prerequisites: SummateDifferences.java
 * Q) Given an array arr of N integers,
 * and an array K containing query numbers having I, V, K,
 * for each query, make Aj = V(Aj != V for every I != J). 
 * Maximize  (1*f(k1) + 2*f(k2) + .. + Q*f(kq)), where
 * f(k) = sum of absolute differences b/w each pair of elements in the sub array of Kj elements.
*/


import java.util.Arrays;
public class QuickQueries{

  static int arrMin;
  static int arrMax;
  public static void main(String[] args) {
    int[] arr, I, V, K;

    int[] arr1 = {7, 5, 8, 3, 9};
    int[] I1 = {1, 3};
    int[] V1 = {1, 2};
    int[] K1 = {2, 3};
    
    arr = arr1; I=I1; V=V1; K=K1;

    int[] auxArr = new int[K.length];
    for(int i=0; i<K.length; i++){
      arr[I[i]-1] = V[i];
      System.out.println(Arrays.toString(arr));
      int[] subArr = selectSubset(arr, K[i]);
      auxArr[i] = evaluateAbsoluteDifference(subArr);
    }

    System.out.println(Arrays.toString(auxArr));
    int result = findIndexMultipliedArraySum(auxArr);
    System.out.println(result);
  }

  static int evaluateAbsoluteDifference(int[] arr){
    int sum=0;
    for(int i=0; i<arr.length-1; i++){
      for(int j=i+1; j<arr.length; j++){
        sum += Math.abs(arr[i] - arr[j]);
      }
    }

    return sum;
  }

  static int findIndexMultipliedArraySum(int[] arr){
    int sum=arr[0];
    for(int i=1; i<arr.length; i++){
      sum += ((i+1)*arr[i]);
    }
    return sum;
  }

  // static void setMinMax(int[] arr){
  //   int min = arr[0];
  //   int max = arr[0];

  //   for(int i=0; i<arr.length; i++){
  //     if(arr[i] < min) min = arr[i];
  //     if(arr[i] > max) max = arr[i];
  //   }

  //   arrMin = min;
  //   arrMax = max;
  // }

  // static int findSubstitue(int[] arr, int[] V, int j, int k){

  //   return 0;
  // }

  // static int[] buildSubArray(int[] arr, int k){
  //   int[] a = arr.clone();
  //   Arrays.sort(a);
    
  //   return a;
  // }

  // static int evaluateSum(int[] arr){
  //   int sum = arr[0];
  //   for(int i=1; i<arr.length; i++){
  //     sum += ((i+1) * arr[i]);
  //   }
  //   return sum;
  // }

  // main logic of the solution is to select only the elements that optimize the final result
  static int[] selectSubset(int[] originalArray, int k){
    // two pointers can be applies here
    int[] arr = originalArray.clone();
    int[] subArr = new int[k];
    Arrays.sort(arr);
    int start=1;
    int end=arr.length - 2;
    int min = subArr[0] = arr[0];
    int max = subArr[1] = arr[arr.length-1];
    int j=2;
    
    while(start <= end && j<k){
      if(arr[start] - min < max - arr[end]){
        subArr[j] = arr[start];
        start++;
      }else{
        subArr[j] = arr[end];
        end--;
      }
      j++;
    }
    System.out.println(Arrays.toString(subArr));
    return subArr;
  }

  // static int[] getMinMax(int[] arr){
  //   int[] minMaxArr = new int[2];

  //   return minMaxArr;
  // }
 }