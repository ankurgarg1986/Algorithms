package dynamicProgramming;


public class MaxProfiltKSelling {

  public static void main(String[] args) {
    
        int k =3;
        int price[] = {10, 22, 5, 75, 65, 80};
        int  n = price.length;
     System.out.println( maxProfit(price, n, k));
     System.out.println( maxProfitOptimized(price, n, k));
  }

  
  private static int maxProfitOptimized(int[] price, int n, int k) {
    int[][] dp = new int[k+1][n];
    int i,j;
    for(i=0;i<=k;i++){
      dp[i][0] = 0; 
    }
    
    
    for(i=0;i<n;i++){
      dp[0][i] = 0; 
    }
    
    for(i=1;i<=k;i++){
      for(j=1;j<n;j++){
        int maxm = -9999;
        maxm = Math.max(maxm, dp[i-1][j-1]-price[j-1]);
        dp[i][j] = Math.max(dp[i][j-1],maxm + price[j]);
      }
    }
    
    return dp[k][n-1];
  }

  private static int maxProfit(int[] price, int n, int k) {
  
   int[][] dp = new int[k+1][n];
   int i,j;
   for(i=0;i<=k;i++){
     dp[i][0] = 0; 
   }
   for(i=0;i<n;i++){
     dp[0][i] = 0; 
   }
   
   for(i=1;i<=k;i++){
     for(j=1;j<n;j++){
       int maxm = -9999;
       for(int m=0;m<j;m++){
         maxm = Math.max(price[j] - price[m] + dp[i-1][m],maxm);
       }
       dp[i][j] = Math.max(dp[i][j-1],maxm);
     }
   }
   
   return dp[k][n-1];
   
  }
}
