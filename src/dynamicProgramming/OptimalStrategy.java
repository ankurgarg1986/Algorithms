package dynamicProgramming;


public class OptimalStrategy {

  public static void main(String[] args) {
    int[] arr1 = {8, 15, 3, 7};
    
    System.out.println(optimalStrategyOfGame(arr1, arr1.length));
 
    int[] arr2 = {2, 2, 2, 2};
    System.out.println(optimalStrategyOfGame(arr2, arr2.length));
 
    int arr3[] = {20, 30, 2, 2, 2, 10};
    System.out.println(optimalStrategyOfGame(arr3, arr3.length));
 
    

  }

  private static int optimalStrategyOfGame(int[] a, int n) {
     int[][] dp = new int[n][n];
     int i,j;
     for(i=0;i<n-1;i++){
       dp[i][i] = a[i];
       dp[i][i+1] = Math.max(a[i], a[i+1]);
     }
     dp[n-1][n-1] = a[n-1];
     for(int k=2;k<n;k++){
       for(i=0,j=i+k;j<n;j++,i++){
           dp[i][j] = Math.max(a[i] + Math.min(dp[i+2][j], dp[i+1][j-1]) , a[j] + Math.min(dp[i+1][j-1],dp[i][j-2]));
       }
     }
     return dp[0][n-1];
  }
  
  
 
     


}
