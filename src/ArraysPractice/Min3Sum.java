package ArraysPractice;


public class Min3Sum {
  static int minimum(int a, int b, int c)
  {
      return Math.min(Math.min(a, b), c);
  }
   
  // Returns minimum possible sum of elements such
  // that an element out of every three consecutive
  // elements is picked.
  static int findMinSum(int arr[], int n)
  {
      // Create a DP table to store results of
      // subpriblems. sum[i] is going to store
      // minimum possible sum when arr[i] is
      // part of the solution.
      int[] sum = new int[n];
   
      // When there are less than or equal to
      // 3 elements
      sum[0] = arr[0];
      sum[1] = arr[1];
      sum[2] = arr[2];
   
      // Iterate through all other elements
      for (int i=3; i<n; i++)
        sum[i] = arr[i] +
                minimum(sum[i-3], sum[i-2], sum[i-1]);
   
      return minimum(sum[n-1], sum[n-2], sum[n-3]);
  }
   
  // Driver code
 public static void main(String[] args) {
   int arr[] = {9,1,1,1};
   //   {1, 2, 3, 20, 2, 10, 1};
    System.out.println(findMinSum(arr, arr.length));
    
}
  
}
