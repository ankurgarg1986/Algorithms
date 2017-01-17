package facebook.hackercup;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;

class Move {
  int s;
  int d;
  public Move(int s, int d) {
    super();
    this.s = s;
    this.d = d;
  }
  
}
public class Round1P3 {

  static final int INF = 1000000001;

  public static void main(String[] args) {
    FastReader2 sc = new FastReader2(System.in);
    int t = sc.nextInt();
    int i, j, gas, k;
    int tcase =1;
    while (t > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int z = sc.nextInt();
      int[][] g = new int[n][n]; // a weighted graph and its size
      for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++){
         // p[i][j] = -1;
          g[i][j] = INF;
          if(i==j){
            g[i][j] = 0;
          }
        }
      }
      for (int x = 0; x < m; x++) {
        i = sc.nextInt();
        j = sc.nextInt();
        gas = sc.nextInt();
        g[i - 1][j - 1] = Math.min(g[i-1][j-1],gas);
        g[j - 1][i - 1] = Math.min(g[j-1][i-1],gas);

      }
      for (k = 0; k < n; k++) {
        for (i = 0; i < n; i++) {
          for (j = 0; j < n; j++) {
            int newD = g[i][k] + g[k][j];
            if (newD < g[i][j]) {
              g[i][j] = newD;
              g[j][i] = newD;
            }
          }
        }
      }
      i=0;
      Move[] m1 = new Move[z];
      int p = z;
      while(p>0){
        m1[i] = new Move(sc.nextInt()-1,sc.nextInt()-1);
        i++;
        p--;
      }
      long[][] dp = new long[z][2];
      for(i = 0; i<m1.length;i++) {
          dp[i][0] = dp[i][1] = 1000000001;
      }

      int l = 0;
      dp[l][0] = g[0][m1[l].s] + g[m1[l].s][m1[l].d];
      if (l+1 < m1.length) {
          dp[l][1] = g[0][m1[l].s] + g[m1[l].s][m1[l+1].s] + g[m1[l+1].s][m1[l].d];
      }

      for (i = 1; i < m1.length; i++) {
          long x = dp[i-1][0] + g[m1[i-1].d][m1[i].s] + g[m1[i].s][m1[i].d];
          long y = dp[i-1][1] + g[m1[i-1].d][m1[i].d];
          dp[i][0] = Math.min(x, y);
          if (i+1 < m1.length) {
              x = dp[i-1][1] + g[m1[i-1].d][m1[i+1].s] + g[m1[i+1].s][m1[i].d];
              y = dp[i-1][0] + g[m1[i-1].d][m1[i].s] + g[m1[i].s][m1[i+1].s] + g[m1[i+1].s][m1[i].d];
              dp[i][1] = Math.min(x, y);
          }
      }
      long res = Math.min(dp[m1.length-1][0], dp[m1.length-1][1]) >= 1000000001 ? -1 :
        Math.min(dp[m1.length-1][0], dp[m1.length-1][1]);
      System.out.println("Case #" + tcase + ": " + res);
      tcase++;
      t--;
    }

  }
}


