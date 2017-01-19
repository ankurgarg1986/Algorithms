package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;


public class C382P3 {

  public static void main(String[] args) {
    FastReader sc = new FastReader(System.in);
    int n = sc.nextInt();
    int n1 = sc.nextInt();
    int n2 = sc.nextInt();
    int[] a = new int[n];
    int i;
    for(i=0;i<n;i++){
      a[i] = sc.nextInt();
    }
    Arrays.sort(a);
    int b = Math.min(n1, n2);
    double val = 0;
    for(i=1;i<=b;i++){
       val += a[n-i];
    }
    val = val/b;
    double val1 = 0;
    int c = Math.max(n1,n2);
    while(i<=c + b){
      val1 += a[n-i];
      i++;
    }
    val1 = val1/c;
    System.out.println(val + val1);
  }

}

//class FastReader {
//
//  private boolean finished = false;
//
//  private InputStream stream;
//  private byte[] buf = new byte[1024];
//  private int curChar;
//  private int numChars;
//  private SpaceCharFilter filter;
//
//  public FastReader(InputStream stream) {
//    this.stream = stream;
//  }
//
//  public int read() {
//    if (numChars == -1) {
//      throw new InputMismatchException();
//    }
//    if (curChar >= numChars) {
//      curChar = 0;
//      try {
//        numChars = stream.read(buf);
//      } catch (IOException e) {
//        throw new InputMismatchException();
//      }
//      if (numChars <= 0) {
//        return -1;
//      }
//    }
//
//    return buf[curChar++];
//  }
//
//  public int peek() {
//    if (numChars == -1) {
//      return -1;
//    }
//    if (curChar >= numChars) {
//      curChar = 0;
//      try {
//        numChars = stream.read(buf);
//      } catch (IOException e) {
//        return -1;
//      }
//      if (numChars <= 0) {
//        return -1;
//      }
//    }
//    return buf[curChar];
//  }
//
//  public int nextInt() {
//    int c = read();
//    while (isSpaceChar(c))
//      c = read();
//    int sgn = 1;
//    if (c == '-') {
//      sgn = -1;
//      c = read();
//    }
//    int res = 0;
//    do {
//      if (c == ',') {
//        c = read();
//      }
//      if (c < '0' || c > '9') {
//        throw new InputMismatchException();
//      }
//      res *= 10;
//      res += c - '0';
//      c = read();
//    } while ( !isSpaceChar(c));
//    return res * sgn;
//  }
//
//  public long nextLong() {
//    int c = read();
//    while (isSpaceChar(c))
//      c = read();
//    int sgn = 1;
//    if (c == '-') {
//      sgn = -1;
//      c = read();
//    }
//    long res = 0;
//    do {
//      if (c < '0' || c > '9') {
//        throw new InputMismatchException();
//      }
//      res *= 10;
//      res += c - '0';
//      c = read();
//    } while ( !isSpaceChar(c));
//    return res * sgn;
//  }
//
//  public String nextString() {
//    int c = read();
//    while (isSpaceChar(c))
//      c = read();
//    StringBuilder res = new StringBuilder();
//    do {
//      res.appendCodePoint(c);
//      c = read();
//    } while ( !isSpaceChar(c));
//    return res.toString();
//  }
//
//  public boolean isSpaceChar(int c) {
//    if (filter != null) {
//      return filter.isSpaceChar(c);
//    }
//    return isWhitespace(c);
//  }
//
//  public boolean isWhitespace(int c) {
//    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
//  }
//
//  private String readLine0() {
//    StringBuilder buf = new StringBuilder();
//    int c = read();
//    while (c != '\n' && c != -1) {
//      if (c != '\r') {
//        buf.appendCodePoint(c);
//      }
//      c = read();
//    }
//    return buf.toString();
//  }
//
//  public String nextLine() {
//    String s = readLine0();
//    while (s.trim().length() == 0)
//      s = readLine0();
//    return s;
//  }
//
//  public String nextLine(boolean ignoreEmptyLines) {
//    if (ignoreEmptyLines) {
//      return nextLine();
//    } else {
//      return readLine0();
//    }
//  }
//
//  public BigInteger nextBigInteger() {
//    try {
//      return new BigInteger(nextString());
//    } catch (NumberFormatException e) {
//      throw new InputMismatchException();
//    }
//  }
//
//  public char nextCharacter() {
//    int c = read();
//    while (isSpaceChar(c))
//      c = read();
//    return (char) c;
//  }
//
//  public double nextDouble() {
//    int c = read();
//    while (isSpaceChar(c))
//      c = read();
//    int sgn = 1;
//    if (c == '-') {
//      sgn = -1;
//      c = read();
//    }
//    double res = 0;
//    while ( !isSpaceChar(c) && c != '.') {
//      if (c == 'e' || c == 'E') {
//        return res * Math.pow(10, nextInt());
//      }
//      if (c < '0' || c > '9') {
//        throw new InputMismatchException();
//      }
//      res *= 10;
//      res += c - '0';
//      c = read();
//    }
//    if (c == '.') {
//      c = read();
//      double m = 1;
//      while ( !isSpaceChar(c)) {
//        if (c == 'e' || c == 'E') {
//          return res * Math.pow(10, nextInt());
//        }
//        if (c < '0' || c > '9') {
//          throw new InputMismatchException();
//        }
//        m /= 10;
//        res += (c - '0') * m;
//        c = read();
//      }
//    }
//    return res * sgn;
//  }
//
//  public boolean isExhausted() {
//    int value;
//    while (isSpaceChar(value = peek()) && value != -1)
//      read();
//    return value == -1;
//  }
//
//  public String next() {
//    return nextString();
//  }
//
//  public SpaceCharFilter getFilter() {
//    return filter;
//  }
//
//  public void setFilter(SpaceCharFilter filter) {
//    this.filter = filter;
//  }
//
//  public interface SpaceCharFilter {
//
//    public boolean isSpaceChar(int ch);
//  }
//}
