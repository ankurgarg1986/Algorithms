package dynamicProgramming;

public class ReverseStringMin {

  static long inf = (long) (1e15 + 15);
  public static void main(String[] args) {
    String arr[] = { "ba", "ac" };
    long cost[] = { 1, 2 };

    System.out.println(minCost(arr, cost));
  }

  private static long minCost(String[] s, long[] cost) {
    int n = s.length;
    long[][] dp = new long[n][2];
    int i;
    for (i = 0; i < n; i++) {
      dp[i][0] = inf;//Integer.MAX_VALUE;
      dp[i][1] = inf;
    }
    dp[0][0] = 0;
    dp[0][1] = cost[0];
    
    for (i = 1; i < n; i++) {
      String s1 = s[i - 1];
      String s2 = s[i];
      StringBuilder sb = new StringBuilder(s1);
      String s1r = sb.reverse().toString();// reverse s1
      StringBuilder sb1 = new StringBuilder(s2);
      String s2r = sb1.reverse().toString();// reverse s2
      if (s1.compareTo(s2) <= 0) {
        // sorted
        dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
      }
      if (s1r.compareTo(s2) <= 0) {
        // sorted
        // dp[i][1] = Math.min(dp[i][1], cost[i] + dp[i-1][0]);
        dp[i][0] = Math.min(dp[i][0], dp[i - 1][1]);
      }
      if (s1r.compareTo(s2r) <= 0) {
        dp[i][1] = Math.min(dp[i][1], cost[i] + dp[i - 1][1]);
      }
      if (s1.compareTo(s2r) <= 0) {
        dp[i][1] = Math.min(dp[i][1], cost[i] + dp[i - 1][0]);
      }

    }
    long res =  Math.min(dp[n - 1][0], dp[n - 1][1]);
    res = (res>=inf) ? -1 : res;
    return res;
  }

}
