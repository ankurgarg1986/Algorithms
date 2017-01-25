package graphs;

public class MinCostPath {

  static int m = 2;
  static int n = 2;
  static int val = 9999;

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // int[][] a = { { 31, 100, 65, 12, 18 }, { 10, 13, 47, 157, 6 }, { 100, 113, 174, 11, 33 }, { 88, 124, 41, 20, 140
    // },
    // { 99, 32, 111, 41, 20 } };
    int[][] a = { { 31, 100 }, { 10, 13 } };
    boolean[][] vis = new boolean[m][n];
    System.out.println(shortestGrid(a, 0, 0, m, n, vis));
  }

  private static int shortestGrid(int[][] a, int sx, int sy, int m, int n, boolean[][] vis) {
    // int ans = 0;

    if (sx == m - 1 && sy == n - 1)
      return a[sx][sy];
    vis[sx][sy] = true;
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    int i, j, k;
    for (i = sx; i < m; i++) {
      for (j = sy; j < n; j++) {
        if (i != m - 1 || j != m - 1) {
          for (k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n && vis[x][y] == false) {
              val = Math.min(val, a[i][j] + shortestGrid(a, x, y, m, n, vis));
            }
          }
        }
        // ans += val;
      }
    }
    return val;
  }

}
