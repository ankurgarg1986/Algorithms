package leetcode;


public class P123 {

  public static int maxProfit(int[] p) {
    if(p.length == 0) return 0;
    int n = p.length;
    int[] dp = new int[n];
    int i,maxm,minm;
    minm = p[0];
    for(i=1;i<n;i++){
       if(minm > p[i]){
         minm = p[i];
       }
       dp[i] = Math.max(dp[i-1] ,p[i]-minm );
    }
    maxm = p[n-1];
    for(i=n-2;i>=0;i--){
      if(maxm < p[i]){
        maxm = p[i];
      }
      dp[i] = Math.max(dp[i+1], dp[i] + maxm-p[i]);
    }
    return dp[n-1];
    
  }
   public static void main(String[] args) {
     int[] p = {2,1,2,0,1};
     System.out.println(maxProfit(p));
  }
}
