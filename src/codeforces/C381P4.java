package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class C381P4 {

  public static void main(String[] args) {
    // FastReader sc = new FastReader(System.in);
    InputReader sc = new InputReader(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int i = 0;
    int j;
    int d = 1000000001;
    int n = sc.nextInt();
    int[] a = new int[n];
    // int[] ans = new int[n];
    while (i < n) {
      a[i] = sc.nextInt();
      i++;
    }
    int[] x1 = new int[1000001];
    int[][] g = new int[200003][200003];
    for (i = 0; i < 200003; i++) {
      for (j = 0; j < 200003; j++) {
        g[i][j] = d;
      }
    }
    i = 1;
    while (i < n) {
      int x = sc.nextInt();
      g[x - 1][i] = sc.nextInt();
      i++;
    }
    int k = 0;
    for (k = 0; k < 200003; k++) {
      for (i = 0; i < 200003; i++) {
        for (j = 0; j < 200003; j++) {
          g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
        }
      }
    }
    for (i = 0; i < n; i++) {
      int ans = 0;
      for (j = 0; j < n; j++) {
        if (g[i][j] <= a[j])
          ans++;
      }
      out.print(ans + " ");
    }
    out.flush();

    // for (i = 0; i < n; i++) {
    // System.out.print(ans[i] + " ");
    // }
  }

  static class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public InputReader(InputStream stream) {
      this.stream = stream;
    }

    private int[] nextInts(int n) {
      int[] ret = new int[n];
      for (int i = 0; i < n; i++) {
        ret[i] = nextInt();
      }
      return ret;
    }

    private int[][] nextIntTable(int n, int m) {
      int[][] ret = new int[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          ret[i][j] = nextInt();
        }
      }
      return ret;
    }

    private long[] nextLongs(int n) {
      long[] ret = new long[n];
      for (int i = 0; i < n; i++) {
        ret[i] = nextLong();
      }
      return ret;
    }

    private long[][] nextLongTable(int n, int m) {
      long[][] ret = new long[n][m];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          ret[i][j] = nextLong();
        }
      }
      return ret;
    }

    private double[] nextDoubles(int n) {
      double[] ret = new double[n];
      for (int i = 0; i < n; i++) {
        ret[i] = nextDouble();
      }
      return ret;
    }

    private int next() {
      if (numChars == -1)
        throw new InputMismatchException();
      if (curChar >= numChars) {
        curChar = 0;
        try {
          numChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (numChars <= 0)
          return -1;
      }
      return buf[curChar++];
    }

    public char nextChar() {
      int c = next();
      while (isSpaceChar(c))
        c = next();
      if ('a' <= c && c <= 'z') {
        return (char) c;
      }
      if ('A' <= c && c <= 'Z') {
        return (char) c;
      }
      throw new InputMismatchException();
    }

    public String nextToken() {
      int c = next();
      while (isSpaceChar(c))
        c = next();
      StringBuilder res = new StringBuilder();
      do {
        res.append((char) c);
        c = next();
      } while ( !isSpaceChar(c));
      return res.toString();
    }

    public int nextInt() {
      int c = next();
      while (isSpaceChar(c))
        c = next();
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = next();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9')
          throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = next();
      } while ( !isSpaceChar(c));
      return res * sgn;
    }

    public long nextLong() {
      int c = next();
      while (isSpaceChar(c))
        c = next();
      long sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = next();
      }
      long res = 0;
      do {
        if (c < '0' || c > '9')
          throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = next();
      } while ( !isSpaceChar(c));
      return res * sgn;
    }

    public double nextDouble() {
      return Double.valueOf(nextToken());
    }

    public boolean isSpaceChar(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {

      public boolean isSpaceChar(int ch);
    }
  }
}
