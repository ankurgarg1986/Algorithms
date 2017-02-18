package leetcode;

public class P188 {

  public static int maxProfit(int k, int[] p) {
    int n = p.length;
    if(n==0 || k==0) return 0;
    int[][] dp = new int[k+1][n];
    int i, j, t;
    for (i = 0; i <= k; i++)
      dp[i][0] = 0;
    for (i = 0; i < n; i++)
      dp[0][i] = 0;
    for(i=1;i<=k;i++){
      int val = Integer.MIN_VALUE;
      for(j=1;j<n;j++){
       // int val = 0;
//        for(t=0;t<j;t++){
//          val = Math.max(val,p[j] - p[t] + dp[i-1][t]);
//        }
        val = Math.max(val, dp[i-1][j-1] - p[j-1]);
        dp[i][j] = Math.max(val + p[j], dp[i][j-1]);
      }
    }
    return dp[k][n - 1];
  }
  
  public static void main(String[] args) {
    int k = 1;
    //int price[] = {10, 22, 5, 75, 65, 80};
    int[] price = {1,2};
    System.out.println(maxProfit(k,price));
  }
}
