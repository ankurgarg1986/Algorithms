package dynamicProgramming;

public class PemutationKInversion {

  public static void main(String[] args) {
    int n = 4;
    int k = 2;
    System.out.println(kInversion(n, k));
  }

  private static int kInversion(int n, int k) {
      int[][] dp = new int[n+1][k+1];
      int i,j;
      dp[0][0]= 0;
      for(i=1;i<=n;i++) dp[i][0] = 1;
      for(i=1;i<=k;i++) dp[0][i] = 0;
      for(i=1;i<=n;i++){
         for(j=1;j<=k;j++){
              if(j <= i - 1)dp[i][j] += dp[i-1][k-j];  
           
         }
      }
      return dp[n][k];
  }

}
