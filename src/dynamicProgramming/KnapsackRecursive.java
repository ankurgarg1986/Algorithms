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
    System.out.println(knapSackDP(W, wt, val,n));
  }

  private static int knapSackDP(int w, int[] wt, int[] val,  int n) {
    int[] dp = new int[w+1];
    int i=0,j;
    for(i=0;i<=n;i++){
      dp[wt[i]] = val[i];
    }
    for(i=0;i<=w;i++){
      for(j=0;j<n;j++){
        if(i-wt[j] >= 0)
          dp[i] = Math.max(dp[i], dp[i-wt[j]] + dp[wt[j]]);
      }
    }
    return dp[w];
  }
}
