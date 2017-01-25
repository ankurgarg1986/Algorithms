package graphs;

import java.util.LinkedList;
import java.util.Queue;

class Point {

  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Sol {

  Point p;
  int dist;

  public Sol(Point p, int dist) {
    this.p = p;
    this.dist = dist;
  }
}

public class ShortestPathMaze {

  static int r = 9;
  static int c = 10;

  public static void main(String[] args) {
    int[][] mat = { { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                   { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                   { 1, 1, 1, 0, 1, 1, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                   { 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, { 1, 1, 0, 0, 0, 0, 1, 0, 0, 1 } };
    Point source = new Point(0, 0);
    Point dest = new Point(3, 4);
    int dist = BFS(mat, source, dest);

    if (dist != 999)
      System.out.println("Shortest Path is " + dist);
    else
      System.out.println("Shortest Path doesn't exist");
  }

  private static int BFS(int[][] mat, Point source, Point dest) {
    int ans = 0;
    boolean[][] vis = new boolean[r][c];
    int i, j;
    for (i = 0; i < r; i++) {
      for (j = 0; j < c; j++)
        vis[i][j] = false;
    }
    Queue<Sol> q = new LinkedList<Sol>();
    q.add(new Sol(source, 0));
    while ( !q.isEmpty()) {
      Sol s = q.poll();
      if ( !vis[s.p.x][s.p.y]) {
        int d = s.dist;
        if (s.p.x == dest.x && s.p.y == dest.y) {
          return s.dist;
        }
        vis[s.p.x][s.p.y] = true;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        for (int k = 0; k < 4; k++) {
          i = s.p.x + dx[k];
          j = s.p.y + dy[k];
          if (isValid(i, j, r, c) && !vis[i][j] && mat[i][j] == 1) {
            q.add(new Sol(new Point(i, j), d + 1));
          }

        }
      }
    }
    return 999;
  }

  private static boolean isValid(int i, int j, int r, int c) {
    return (i >= 0 && i < r && j >= 0 && j < c);
  }

}
