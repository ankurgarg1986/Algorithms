package ArraysPractice;

import java.util.Arrays;

public class BuyingSellingTwice {

  // Returns maximum profit with two transactions on a given
  // list of stock prices, price[0..n-1]
  static int maxProfit(int a[], int n) {
      int[] dp = new int[n];
      Arrays.fill(dp, 0);
      int maxm,minm;
      maxm = a[n-1];
      int i;
      for(i=n-2;i>=0;i--){
          if(a[i] > maxm){
            maxm = a[i];
          }
          dp[i] = Math.max(dp[i+1], maxm - a[i]);
      }
      minm = a[0];
      for(i=1;i<n;i++){
        if(a[i] < minm){
          minm  = a[i];
        }
        dp[i] = Math.max(dp[i-1] , a[i] - minm + dp[i]);
        
        
      }

      return dp[n-1];
  }

  public static void main(String args[]) {
    int price[] =  {100, 30, 15, 10, 8, 25, 80};
    int n = price.length;
    System.out.println("Maximum Profit = " + maxProfit(price, n));
  }

}
