package dynamicProgramming;

public class Sol {

  public static String longestPalindrome(String s) {

    int n = s.length();
    int[][] dp = new int[n + 1][n + 1];
    int i, j;
    for (i = 0; i <= n; i++) {
      for (j = 0; j <= n; j++)
        dp[i][j] = 0;
    }
    for (i = 0; i <= n; i++) {
      dp[i][i] = 1;
      dp[i][0] = 0;
      dp[0][i] = 0;
    }
    dp[0][0] = 0;
    int ans = 1;
    String res = s.substring(0, 1);
    for (int l = 2; l <= n; l++) {
      for (i = 1; i <= n - l + 1; i++) {
        j = i + l - 1;
        if ((l == 2 || dp[i + 1][j - 1] != 0) && s.charAt(i - 1) == s.charAt(j - 1)) {
          dp[i][j] = 2 + dp[i + 1][j - 1];
          if (dp[i][j] > ans) {
            ans = dp[i][j];
            int st = i-1;
            int end = j;
          }
        } else
          dp[i][j] = 0;
      }
    }
    return s.substring(st,end+1);

  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
  }
}