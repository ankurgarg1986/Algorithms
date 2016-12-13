package ArraysPractice;

// Java program to find maximum product subarray
import java.io.*;

public class ProductSubarray {

  // Utility functions to get minimum of two integers
  static int min(int x, int y) {
    return x < y ? x : y;
  }

  // Utility functions to get maximum of two integers
  static int max(int x, int y) {
    return x > y ? x : y;
  }

  /*
   * Returns the product of max product subarray. Assumes that the given array always has a subarray with product more
   * than 1
   */
  static int maxSubarrayProduct(int a[]) {
    int n = a.length;
    int ans = 1;
    int minm = 1;
    int maxm = 1;
    int temp = 1;
    for (int i = 0; i < n; i++) {
      if (a[i] == 0) {
        temp = 1;
        minm = 1;
        maxm = 1;
      } else {
        temp = maxm;
        maxm = Math.max(minm * a[i] , Math.max( 1, maxm * a[i]));
        minm  = Math.min(temp * a[i] , Math.min(minm*a[i] , a[i]));
        ans = Math.max(ans, maxm);
      }
    }
    return ans;

  }

  public static void main(String[] args) {

    int arr[] = {10, 20, -30, 5};
    System.out.println("Maximum Sub array product is " + maxSubarrayProduct(arr));
  }
}
/* This code */
