package dynamicProgramming;

public class MaxPalinSubSequence {

  /* Driver program to test above functions */
  public static void main(String args[]) {
    String seq = "GEEKSFORGEEKS";
    int n = seq.length();
    System.out.println("The lnegth of the lps is " + maxPalinSub(seq));
  }

  private static int maxPalinSub(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    int i, j;
    for (i = 0; i < n; i++)
      dp[i][i] = 1;
    for (int l = 2; l <= n; l++) {
      for (i = 0; i < n - l + 1; i++) {
        j = i + l - 1;
        if (s.charAt(i) == s.charAt(j) && l == 2) {
          dp[i][j] = 2;
        } else {
          if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + dp[i + 1][j - 1];
          } else {
            dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
          }
        }
      }
    }

    return dp[0][n - 1];
  }

}
