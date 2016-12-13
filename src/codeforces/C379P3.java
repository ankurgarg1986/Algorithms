package codeforces;


import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class C379P3 {

  public static void main(String[] args) {
    FastReader sc = new FastReader(System.in);
    
    long n = sc.nextLong();
    int m = sc.nextInt();
    int k = sc.nextInt();
    long x = sc.nextLong();
    long t = sc.nextLong();
    int i, j;
    long c;
    long ans = n * x;// using 0 potions
    long[] t1 = new long[m];
    long[] p1 = new long[m];
    for (i = 0; i < m; i++) {
      t1[i] = sc.nextLong();
    }
    for (i = 0; i < m; i++) {
      p1[i] = sc.nextLong();
      if (t - p1[i] >= 0) {
        ans = Math.min(ans, n * t1[i]);
      }
    }
    long[] c2 = new long[k+1];
    for (i = 1; i < k+1; i++) {
      c2[i] = sc.nextLong();
    }
    long[] p2 = new long[k+1];
    for (i = 1; i < k+1; i++) {
      p2[i] = sc.nextLong();
      if (t - p2[i] >= 0) 
         ans = Math.min(ans, (n - c2[i]) * x);
    }
    
    for (j = 0; j < m; j++) {
      long rem = t - p1[j];
      if(rem > 0) {
         c = binSearch(rem,p2,0,k,c2);
         ans = Math.min(ans,(n-c)*t1[j]);
      }
    
    }

    System.out.println(ans);

  }

  private static long binSearch(long rem, long[] p2, int l, int h,long[] c2) {
    int mid = 0;
    while(l<h){
       mid = l + (h-l+1)/2;
      if(rem == p2[mid]) return c2[mid];
      if(rem < p2[mid]) h = mid-1;
      else l = mid;
     
   }
   if(p2[l] > rem ) return 0;
   return c2[l];
    
  }

}

 class FastReader {
 private boolean finished = false;

 private InputStream stream;
 private byte[] buf = new byte[1024];
 private int curChar;
 private int numChars;
 private SpaceCharFilter filter;

 public FastReader(InputStream stream) {
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

 public boolean isWhitespace(int c) {
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
