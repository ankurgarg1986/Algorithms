package ArraysPractice;

import java.util.Arrays;

public class CountInversions {

  static int getSum(int BITree[], int index) {
    int sum = 0; // Initialize result

    // Traverse ancestors of BITree[index]
    while (index > 0) {
      // Add current element of BITree to sum
      sum += BITree[index];

      // Move index to parent node in getSum View
      index -= index & ( -index);
    }
    return sum;
  }

  // Updates a node in Binary Index Tree (BITree) at given index
  // in BITree. The given value 'val' is added to BITree[i] and
  // all of its ancestors in tree.
  static void updateBIT(int BITree[], int n, int index, int val) {
    // Traverse all ancestors and add 'val'
    while (index <= n) {
      // Add 'val' to current node of BI Tree
      BITree[index] += val;

      // Update index to that of parent in update View
      index += index & ( -index);
    }
  }

  // Converts an array to an array with values from 1 to n
  // and relative order of smaller and greater elements remains
  // same. For example, {7, -90, 100, 1} is converted to
  // {3, 1, 4 ,2 }
  static int[] convert(int arr[], int n){
    // Create a copy of arrp[] in temp and sort the temp array
    // in increasing order
    int[] temp = new int[n];
    for (int i=0; i<n; i++)
        temp[i] = arr[i];
    Arrays.sort(temp);
    int[] res = new int[n];
    // Traverse all array elements
    for (int i=0; i<n; i++)
    {
       for(int j=0;j<n;j++){
         if(arr[i] == temp[j]){
           res[i] = j+1;
           break;
         }
       }
    }
    return res;
}

  // Returns inversion count arr[0..n-1]
  static int getInvCount(int arr[], int n)
{
    int invcount = 0; // Initialize result
 
     // Convert arr[] to an array with values from 1 to n and
     // relative order of smaller and greater elements remains
     // same.  For example, {7, -90, 100, 1} is converted to
    //  {3, 1, 4 ,2 }
    int[] res = convert(arr, n);
 
    // Create a BIT with size equal to maxElement+1 (Extra
    // one is used so that elements can be directly be
    // used as index)
    int[] BIT = new int [n+1];
    for (int i=1; i<=n; i++)
        BIT[i] = 0;
 
    // Traverse all elements from right.
    for (int i=n-1; i>=0; i--)
    {
        // Get count of elements smaller than arr[i]
        invcount += getSum(BIT, res[i]-1);
 
        // Add current element to BIT
        updateBIT(BIT, n, res[i], 1);
    }
 
    return invcount;
}

  // Driver program
  public static void main(String[] args) {
    //int arr[] = { 8, 4, 2, 1 };
    int arr[] = { 7, -90, 100, 1 };
    int n = arr.length;
    System.out.println("Number of inversions are : " + getInvCount(arr, n));
  }
}