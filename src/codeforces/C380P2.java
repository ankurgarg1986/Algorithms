package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class C380P2 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    FastReader sc = new FastReader(System.in);
    int r = sc.nextInt();
    int c = sc.nextInt();
    int i, j;
    int[][] a = new int[r][c];
    for (i = 0; i < r; i++) {
      for (j = 0; j < c; j++) {
        a[i][j] = sc.nextInt();
      }
    }
    int ans = 0;
    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, 1, -1 };
    String[] dir = {"D","U","R","L"};
    for (i = 0; i < r; i++) {
      for (j = 0; j < c; j++) {
        if (a[i][j] == 0) {
          // cell can be used to place light
          for (int k = 0; k < 4; k++) {
            int x = dx[k] + i;
            int y = dy[k] + j;
            if (isValid(x, y, r, c) && actorPresent(a,i,j,r,c,dir[k])) {
              ans++;
            }

          }
        }
      }
    }
    System.out.println(ans);
  }

  private static boolean actorPresent(int[][] a, int x, int y, int r, int c, String d) {
    if (d.equals("R")) {
        for(int i=y;i<c;i++){
            if(a[x][i] == 1) return true;
        }
    }
    if (d.equals("L")) {
      for(int i=y;i>=0;i--){
        if(a[x][i] == 1) return true;
      }
    }
    if (d.equals("D")) {
      for(int i=x;i<r;i++){
        if(a[i][y] == 1) return true;
      }
    }
    if (d.equals("U")) {
      for(int i=x;i>=0;i--){
        if(a[i][y] == 1) return true;
      }
    }
    return false;
  }

  private static boolean isValid(int x, int y, int r, int c) {
    return (x >= 0 && x < r && y >= 0 && y < c);
  }

}


