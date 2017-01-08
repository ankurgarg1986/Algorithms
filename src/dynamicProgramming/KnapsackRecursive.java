package dynamicProgramming;

public class KnapsackRecursive {

  // // A utility function that returns maximum of two integers
  // static int max(int a, int b) { return (a > b)? a : b; }

  // Returns the maximum value that can be put in a knapsack of capacity W
  static int knapSack(int W, int wt[], int val[], int i, int n) {
    if (W <= 0 || i >= n)
      return 0;
    int ans = 0;
    if (wt[i] > W) {
      ans = knapSack(W, wt, val, i + 1, n);
    } else {
      ans = Math.max(val[i] + knapSack(W - wt[i], wt, val, i + 1, n), knapSack(W, wt, val, i + 1, n));
    }
    return ans;
  }

  // Driver program to test above function
  public static void main(String args[]) {
    int val[] = new int[] { 60, 100, 120 };
    int wt[] = new int[] { 10, 20, 30 };
    int W = 50;
    int n = val.length;
    System.out.println(knapSack(W, wt, val, 0, n));
  }
}
