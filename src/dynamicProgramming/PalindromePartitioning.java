package dynamicProgramming;

public class PalindromePartitioning {

  public static void main(String[] args) {
    String s = "aacd";
    System.out.println(minCuts(s));

  }

  private static int minCuts(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    int[] c = new int[n];
    int i, j;
    for (i = 0; i < n; i++)
      dp[i][i] = true;
    int l = 2;
    for (l = 2; l <= n; l++) {
      for (i = 0; i < n - l + 1; i++) {
        j = i + l - 1;
        if (l == 2) {
          dp[i][j] = (s.charAt(i) == s.charAt(j));
        } else {
          if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }
      }
    }
    if (dp[0][n - 1])
      return 0;
    for (i = 0; i < n; i++) {
      if (dp[0][i])
        c[i] = 0;
      else {
        c[i] = 9999;
        for (j = 0; j < i; j++) {
           if(dp[j+1][i] == true){
              c[i] = Math.min(c[i], c[j] + 1);
           }
         // c[i] = Math.min(c[i],  );
        }

      }

    }
    return c[n - 1];

  }

}
