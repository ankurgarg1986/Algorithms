package ArraysPractice;

import java.util.Arrays;



public class BuyingSellingTwice {

  public static void main(String[] args) {
    int p[] = {90, 80, 70, 60, 50};
    int n = p.length;
    System.out.println("Maximum Profit = "+ maxProfit(p, n));

  }

  private static int maxProfit(int[] a, int n) {
      int[] dp = new int[n];
      Arrays.fill(dp, 0);
      int maxm,minm ;
      maxm = a[n-1];
      int i;
      for(i=n-2;i>=0;i--){
        if(a[i] > maxm){
          maxm = a[i];
        }
        dp[i] = Math.max(dp[i+1],maxm - a[i] );
      }
      minm = a[0];
      for(i=1;i<n;i++){
         if(a[i] < minm){
           minm = a[i];
         }
         dp[i] = Math.max(dp[i-1], dp[i] + a[i] - minm);
      }
      return dp[n-1];
  }

}
