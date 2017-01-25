package leetcode;


public class P44 {

  public static void main(String[] args) {
    System.out.println(isMatch("aa","a"));//f
    System.out.println(isMatch("aa","aa"));//t
    System.out.println(isMatch("aaa","aa"));//f
    System.out.println(isMatch("aa", "*"));//t
    System.out.println(isMatch("aa", "a*"));//t
    System.out.println(isMatch("ab", "?*"));//t
    System.out.println(isMatch("aab", "c*a*b"));//f

  }
  
  public static boolean isMatch(String s, String p) {
      int n = s.length();
      int m = p.length();
      boolean[][] dp = new boolean[m+1][n+1];
      dp[0][0] = true;
      int i,j;
      for(i=1;i<=n;i++)
        dp[0][i] = false;
      for(i=1;i<=m;i++){
        if(p.charAt(i-1) == '*')
          dp[i][0] = dp[i-1][0];
        else
          dp[i][0] = false;
      }
      for(i=1;i<=m;i++){
        for(j=1;j<=n;j++){
          if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?')
            dp[i][j] = dp[i-1][j-1];
          else if(p.charAt(i-1) == '*')
            dp[i][j] = dp[i-1][j] || dp[i][j-1];
          else if(p.charAt(i-1) != s.charAt(j-1))
            dp[i][j] = false;
        }
      }
      
      
      return dp[m][n];
  }

}
