package ArraysPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class BitTree {

  

  /*
   * n --> No. of elements present in input array. BITree[0..n] --> Array that represents Binary Indexed Tree.
   * arr[0..n-1] --> Input array for whic prefix sum is evaluated.
   */

  // Returns sum of arr[0..index]. This function assumes
  // that the array is preprocessed and partial sums of
  // array elements are stored in BITree[].
  public static int getSum(int bTree[], int index) {
    int idx = index + 1;
    int sum = 0;
    while (idx > 0) {
      sum += bTree[idx];
      idx -= idx & ( -idx);
    }
    return sum;

  }

  // Updates a node in Binary Index Tree (BITree) at given index
  // in BITree. The given value 'val' is added to BITree[i] and
  // all of its ancestors in tree.
  public static void updateBIT(int bTree[], int n, int index, int val) {
    int idx = index + 1;
    while (idx <= n) {
      bTree[idx] += val;
      idx += idx & ( -idx);
    }

  }

  // Constructs and returns a Binary Indexed Tree for given
  // array of size n.
  public static int[] constructBITree(int arr[], int n) {

    int[] bitTree = new int[n + 1];
    int i;
    for (i = 0; i < n; i++) {
      updateBIT(bitTree, n, i, arr[i]);
    }
    return bitTree;
  }

  private static void update(int[] bITree, int l, int r, int n, int val) {

    updateBIT(bITree, n, l, val);
    updateBIT(bITree, n, r + 1, -val);
  }

  // Driver program to test above functions

  public static void main(String[] args) {
    int freq[] = { 2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9 };
    int n = freq.length;
    int[] BITree = constructBITree(freq, n);
    // System.out.println( "Sum of elements in arr[0..5] is "
    // + getSum(BITree, 4));

    update(BITree, 2, 4, n, 10);

    // // Let use test the update operation
    // freq[3] += 6;
    // updateBIT(BITree, n, 3, 6); //Update BIT for above change in arr[]

    System.out.println("\nSum of elements in arr[0..5] after update is " + getSum(BITree, 7));

  }

}
