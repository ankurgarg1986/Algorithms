package leetcode;

import java.util.LinkedList;

/**
 * 
 * @author agarg
 * Solution to Problem 317 (Hard) in leetCode.
 */
class GridPoint {

  int i;
  int j;
  int val;

  public GridPoint(int i, int j, int val) {
    super();
    this.i = i;
    this.j = j;
    this.val = val;
  }

}

public class P317 {

  public static int shortestDistance(int[][] g) {
    int i = 0;
    int j = 0;
    int m = g.length;
    int c = 1;
    int n = g[0].length;
    int[][] vis = new int[m][n];
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        g[i][j] = -1 * g[i][j];
        vis[i][j] = 0;
      }
    }

    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        if (g[i][j] == -1) {
          bfs(g, i, j, 1, m, n, c, vis);
          markUnreachable(c, vis, g);
          c += 1;
        }
      }
    }
    int ans = 999999;
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        if (g[i][j] > 0) {
          ans = Math.min(ans, g[i][j]);
        }
      }
    }
    if (ans == 999999)
      return -1;
    return ans;

  }

  private static void markUnreachable(int c, int[][] vis, int[][] g) {
    int i, j;
    int m = g.length;
    int n = g[0].length;
    for (i = 0; i < m; i++) {
      for (j = 0; j < n; j++) {
        if (g[i][j] >= 0) {
          if (vis[i][j] != c) {
            // not reachable from here
            g[i][j] = -2;
          }
        }
      }
    }

  }

  private static void bfs(int[][] g, int i, int j, int val, int m, int n, int c, int[][] vis) {
    LinkedList<GridPoint> q = new LinkedList<GridPoint>();
    q.add(new GridPoint(i, j, val));
    while ( !q.isEmpty()) {
      GridPoint p = q.poll();
      bfsHelper(g, p.i, p.j, p.val, m, n, vis, c, q);
    }
  }

  private static void bfsHelper(int[][] g, int i, int j, int val, int m, int n, int[][] vis, int count,
                                LinkedList<GridPoint> q) {
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    for (int k = 0; k < 4; k++) {
      int x = i + dx[k];
      int y = j + dy[k];
      if (inBound(x, y, m, n) && g[x][y] >= 0 && vis[x][y] != count) {
        g[x][y] += val;
        q.add(new GridPoint(x, y, val + 1));
        vis[x][y] = count;
      }
    }

  }

  private static boolean inBound(int x, int y, int m, int n) {

    return (x >= 0 && y >= 0 && x < m && y < n);
  }

  public static void main(String[] args) {
    // int[][] g = { { 1, 0, 2, 0, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 } };
     int[][] g = {{0,2,1},{1,0,2},{0,1,0}};
//    int[][] g = { { 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 1 }, { 0, 1, 1, 0, 0, 1 }, { 1, 0, 0, 1, 0, 1 },
//                 { 1, 0, 1, 0, 0, 1 }, { 1, 0, 0, 0, 0, 1 }, { 0, 1, 1, 1, 1, 0 } };
    System.out.println(shortestDistance(g));
  }
}
