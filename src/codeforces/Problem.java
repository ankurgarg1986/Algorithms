package codeforces;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Created by vishakha on 13-10-2016.
 */
public class Problem {
    public static boolean right = true;
    public static int ending;
    public static int n;
    public static int[] start;
    public static int[] end;

    public static void main(String[] args) {
        getInput();
        ArrayList<Integer> listOfIndices = findIndices();

        System.out.println("YES");

        for (int i = listOfIndices.size() - 2; i >= 0; i--) {
//            System.out.println(listOfIndices.get(i - 1) + 1);
            int currIdx = listOfIndices.get(i) + 1;
            if (currIdx == listOfIndices.get(i + 1)) {
                continue;
            }

            int maxIdx = getLargestNum(start, currIdx, listOfIndices.get(i + 1));

            currIdx = maxIdx;
            int rightLimit = listOfIndices.get(i + 1);

            if (!right) {
                System.out.println(currIdx + 1 + " L");
                currIdx--;
                maxIdx--;
                rightLimit--;
                right = true;
            }

            while (currIdx < rightLimit) {
//                System.out.println(currIdx + " " + rightLimit);
                System.out.println(maxIdx + 1 + " R");
                currIdx++;
            }

            currIdx = maxIdx;
            while (currIdx > listOfIndices.get(i) + 1) {
//                System.out.println(currIdx + " " + listOfIndices.get(i) + 1);
                System.out.println(currIdx + 1 + " L");
                currIdx--;
            }

        }
//            System.out.println();
    }

    public static void getInput() {
        FastReader sc = new FastReader(System.in);
        n = sc.nextInt();
        int sum = 0;
        start = new int[n];
        boolean allEqual = true;

        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            sum += start[i];
            if (i != 0 && start[i] != start[i - 1] && allEqual) {
                allEqual = false;
            }
        }

        ending = sc.nextInt();
        int finalSum = 0;
        end = new int[ending];
        for (int i = 0; i < ending; i++) {
            end[i] = sc.nextInt();
            finalSum += end[i];
        }

        if (Arrays.equals(start, end)) {
            System.out.println("YES");
            System.exit(0);
        }

        if (finalSum !=  sum || allEqual) {
            System.out.print("NO");
//            System.out.println("whaaat");
            System.exit(0);
        }
    }

    public static ArrayList<Integer> findIndices() {
        int idx = 0;
        int prevIdx = -1;
        ArrayList<Integer> listOfIndices = new ArrayList<Integer>();
        listOfIndices.add(-1);

        for (int i = 0; i < ending; i++) {
            int curr = end[i];
            int currSum = 0;
            while (idx < n) {
                currSum += start[idx];
                if (currSum == curr) {
                    if (prevIdx != idx - 1 && allSameInRange(start, prevIdx + 1, idx)) {
//                        System.out.println(prevIdx + " " + idx);
                        System.out.println("NO");
//                        System.out.println("haha1");
                        System.exit(0);
                    }
                    listOfIndices.add(idx);
                    prevIdx = idx;
                    idx++;
                    break;
                }
                idx++;
            }
            if (currSum != curr) {
//                System.out.println(currSum + " " + curr);
                System.out.println("NO");
//                System.out.println("haha2");
                System.exit(0);
            }
        }
        return  listOfIndices;
    }

    public static boolean allSameInRange(int[] a, int lo, int hi) {
        boolean ans = true;
        for (int i = lo + 1; i <= hi; i++) {
            if (a[i] != a[i - 1]) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    public static int getLargestNum(int[] a, int lo, int hi) {
        int ans = lo;
        int max = a[lo];
        for (int i = lo + 1; i <= hi; i++) {
            if (a[i] >= max) {
                max = a[i];
                ans = i;
            }
        }
        if (ans == hi) {
            right = false;
            while (a[ans] == max) {
                ans--;
            }
            ans++;
        }
        return ans;
    }
}

class FastReader1 {
  private boolean finished = false;

  private InputStream stream;
  private byte[] buf = new byte[1024];
  private int curChar;
  private int numChars;
  private SpaceCharFilter filter;

  public FastReader1(InputStream stream) {
      this.stream = stream;
  }

  public int read() {
      if (numChars == -1) {
          throw new InputMismatchException();
      }
      if (curChar >= numChars) {
          curChar = 0;
          try {
              numChars = stream.read(buf);
          } catch (IOException e) {
              throw new InputMismatchException();
          }
          if (numChars <= 0) {
              return -1;
          }
      }

      return buf[curChar++];
  }

  public int peek() {
      if (numChars == -1) {
          return -1;
      }
      if (curChar >= numChars) {
          curChar = 0;
          try {
              numChars = stream.read(buf);
          } catch (IOException e) {
              return -1;
          }
          if (numChars <= 0) {
              return -1;
          }
      }
      return buf[curChar];
  }

  public int nextInt() {
      int c = read();
      while (isSpaceChar(c))
          c = read();
      int sgn = 1;
      if (c == '-') {
          sgn = -1;
          c = read();
      }
      int res = 0;
      do {
          if (c == ',') {
              c = read();
          }
          if (c < '0' || c > '9') {
              throw new InputMismatchException();
          }
          res *= 10;
          res += c - '0';
          c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
  }

  public long nextLong() {
      int c = read();
      while (isSpaceChar(c))
          c = read();
      int sgn = 1;
      if (c == '-') {
          sgn = -1;
          c = read();
      }
      long res = 0;
      do {
          if (c < '0' || c > '9') {
              throw new InputMismatchException();
          }
          res *= 10;
          res += c - '0';
          c = read();
      } while (!isSpaceChar(c));
      return res * sgn;
  }

  public String nextString() {
      int c = read();
      while (isSpaceChar(c))
          c = read();
      StringBuilder res = new StringBuilder();
      do {
          res.appendCodePoint(c);
          c = read();
      } while (!isSpaceChar(c));
      return res.toString();
  }

  public boolean isSpaceChar(int c) {
      if (filter != null) {
          return filter.isSpaceChar(c);
      }
      return isWhitespace(c);
  }

  public static boolean isWhitespace(int c) {
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
  }

  private String readLine0() {
      StringBuilder buf = new StringBuilder();
      int c = read();
      while (c != '\n' && c != -1) {
          if (c != '\r') {
              buf.appendCodePoint(c);
          }
          c = read();
      }
      return buf.toString();
  }

  public String nextLine() {
      String s = readLine0();
      while (s.trim().length() == 0)
          s = readLine0();
      return s;
  }

  public String nextLine(boolean ignoreEmptyLines) {
      if (ignoreEmptyLines) {
          return nextLine();
      } else {
          return readLine0();
      }
  }

  public BigInteger nextBigInteger() {
      try {
          return new BigInteger(nextString());
      } catch (NumberFormatException e) {
          throw new InputMismatchException();
      }
  }

  public char nextCharacter() {
      int c = read();
      while (isSpaceChar(c))
          c = read();
      return (char) c;
  }

  public double nextDouble() {
      int c = read();
      while (isSpaceChar(c))
          c = read();
      int sgn = 1;
      if (c == '-') {
          sgn = -1;
          c = read();
      }
      double res = 0;
      while (!isSpaceChar(c) && c != '.') {
          if (c == 'e' || c == 'E') {
              return res * Math.pow(10, nextInt());
          }
          if (c < '0' || c > '9') {
              throw new InputMismatchException();
          }
          res *= 10;
          res += c - '0';
          c = read();
      }
      if (c == '.') {
          c = read();
          double m = 1;
          while (!isSpaceChar(c)) {
              if (c == 'e' || c == 'E') {
                  return res * Math.pow(10, nextInt());
              }
              if (c < '0' || c > '9') {
                  throw new InputMismatchException();
              }
              m /= 10;
              res += (c - '0') * m;
              c = read();
          }
      }
      return res * sgn;
  }

  public boolean isExhausted() {
      int value;
      while (isSpaceChar(value = peek()) && value != -1)
          read();
      return value == -1;
  }

  public String next() {
      return nextString();
  }

  public SpaceCharFilter getFilter() {
      return filter;
  }

  public void setFilter(SpaceCharFilter filter) {
      this.filter = filter;
  }

  public interface SpaceCharFilter {
      public boolean isSpaceChar(int ch);
  }
}