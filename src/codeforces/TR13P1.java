package codeforces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



public class TR13P1 {

  public static void main(String[] args) {
    FastReader sc = new FastReader(System.in);
    int n  = sc.nextInt();
    Map<Integer,ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>();
    Map<Integer,ArrayList<ArrayList<Integer>>> hm1 = new HashMap<Integer,ArrayList<ArrayList<Integer>>>();
    int[] dp = new int[n+1];
    dp[0]= 0;
    dp[1] = 1;
    ArrayList<Integer> l = new ArrayList<Integer>();
    l.add(1);
    hm.put(1,l);
    dp[2] = 1;
    l = new ArrayList<Integer>();
    l.add(2);
    hm.put(2, l);
    int i,j;
    ArrayList<ArrayList<Integer>> ans  = new ArrayList<ArrayList<Integer>>();
    for(i=3;i<=n;i++) {
        dp[i] = 2;
        l = new ArrayList<Integer>();
        l.add(1);
        l.add(i-1);
        ans.add(l);
        hm.put(i,l);
        hm1.put(i,ans);
    }
    for(i=3;i<=n;i++){
//      l = new ArrayList<Integer>();
//      hm.put(i, l);
      for(j=1;j<i;j++){
//         if(i-j !=j){
//           l = new ArrayList<Integer>();
//           l.add(i-j);
//           l.add(j);
//           hm.put(i, l);
//           dp[i] = Math.max(dp[i], l.size());
//         }
         if(i-j !=j && !hm.get(i-j).contains(j) &&  !hm.get(j).contains(i-j) && (hm.get(i-j).size() + hm.get(j).size() > l.size())){
           l = new ArrayList<Integer>();
           l.addAll(hm.get(i-j));
           l.addAll(hm.get(j));
           hm.put(i,l);
           dp[i] = Math.max(dp[i], l.size());
         }
      }
    }
    System.out.println(dp[n]);
    ArrayList<Integer> ll = hm.get(n);
    Iterator<Integer> it = ll.listIterator();
    while(it.hasNext()){
      System.out.print(it.next() + " ");
    }

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

