// Find the subset of length 'k' from an array of integers such that the sum of absolute differences b/w each pair of elements in the subset is maximum

// Theory: https://excalidraw.com/#json=0UcEAfyWXvxJA0kyxdl2v,JMe_XhyH0GVz-sxN1EG_JQ. This theory is wrong, compare [1,6,8,9] to [1,7,8,9], i.e., 26 to 25

import java.util.Arrays;

public class SummateDifferences{
  static int[] selectSubset(int[] arr, int k){
    // two pointers can be applies here
    int[] subArr = new int[k];
    Arrays.sort(arr);
    int start=1;
    int end=arr.length - 2;
    int min = subArr[0] = arr[0];
    int max = subArr[1] = arr[arr.length-1];
    int j=2;
    
    boolean pickStart = true;

    while(start <= end && j<k){
      // pick alternatively
      
      // if(arr[start] - min <= max - arr[end]){
      if(pickStart){
        // picks from the front of the array
        subArr[j] = arr[start];
        start++;
        pickStart = false;
      }else{
        // picks from the back of the array
        subArr[j] = arr[end];
        end--;
        pickStart = true;
      }
      j++;
    }

    return subArr;
  }
  
  public static void main(String args[]) {
    int x=10;
    int y=25;
    int z=x+y;
    
    int[] arr = {1, 4, 9, 8, 6, 7};
    // int[] arr = {1, 5, 2, 3, 9};
    
    int[] res = selectSubset(arr, 5);
    System.out.println(Arrays.toString(res));
    int ans = evaluateAbsoluteDifference(res);
    System.out.println(ans);
  }

  // static int findIndexMultipliedArraySum(int[] arr){
  //   int sum = arr[0];

  // }

  static int evaluateAbsoluteDifference(int[] arr){
    int sum=0;
    for(int i=0; i<arr.length-1; i++){
      for(int j=i+1; j<arr.length; j++){
        sum += Math.abs(arr[i] - arr[j]);
      }
    }

    return sum;
  }
}