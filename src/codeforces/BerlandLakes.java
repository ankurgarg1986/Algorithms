package codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class BerlandLakes{
  public static int n;
  public static int rs = 0;
  
   public static void main(String[] args) {
      getInput();
    
  }
   
   private static void getInput() {
     FastReader sc = new FastReader(System.in);
     n = sc.nextInt();
     int m  = sc.nextInt();
     int k = sc.nextInt();
     int i,j;
     char[][] g = new char[n][m];
     for(i=0;i<n;i++){
       String s = sc.nextLine();
       for(j=0;j<s.length();j++){
         g[i][j] = s.charAt(j);
       }
     }
    findIslands(g,n,m,k);
    
    
  }

  private static void findIslands(char[][] g,int n,int m,int k) {
       int c = 0;
       boolean[][] vis = new boolean[n][m];
       int i,j;
       PriorityQueue<Lake> pq = new PriorityQueue<Lake>();
       //List<Integer> len = new ArrayList<Integer>();
       for(i=0;i<n;i++)
       {
         for(j=0;j<m;j++)
            vis[i][j] = false;
       }
       for(i=0;i<n;i++){
         for(j=0;j<m;j++){
           if(vis[i][j] == false && g[i][j] == '.' && isNotBorder(i,j,n,m)){
             vis[i][j] = true; 
             Coordinates sCoordinate = new Coordinates(i,j);
              Lake l = new Lake();
              int res =  1 + findIslandsUtil(g,vis,i,j,n,m,l);
              if(res != 0){
                  //this is  a valid lake
                   //add to the priority queue
                l.sCoordinate = sCoordinate;
                if(res == 1){
                  l.eCoordinates = l.sCoordinate;
                }
                l.len = res;  
                pq.add(l);
                
              }
           }
         }
       }
       //System.out.println(pq.size());
       while(pq.size() > k){
          Lake l1 = pq.remove();
          closeLakeCoordinates(g,l1.sCoordinate.x,l1.sCoordinate.y,n,m);      
       }
       
       
       System.out.println(rs);
      
       printNewGraph(g,n,m);
       
  }

  private static void printNewGraph(char[][] g,int n,int m) {
      for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
           System.out.print(g[i][j]);
        }
        System.out.println();
      }
    
  }

  private static void closeLakeCoordinates(char[][] g,int i,int j,int n,int m) {
      int[] dx =  {0,-1,1,0,0};
      int[] dy = {0,0,0,-1,1};
      for(int k=0;k<5;k++){
        int x = dx[k] + i;
        int y = dy[k] + j;
        if(isValid(x,y,n,m) && g[x][y]=='.'){
            g[x][y] = '*';
            rs ++;
            closeLakeCoordinates(g,x,y,n,m);
        }
      }
  }

  private static int findIslandsUtil(char[][] g, boolean[][] vis, int i, int j, int n, int m,Lake l) {
    int[] dx =  {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int ans = 0;
    for(int k=0;k<4;k++){
        int x = dx[k] + i;
        int y = dy[k] + j;
        if(isValid(x,y,n,m) && vis[x][y]== false){
          if(g[x][y]=='.'){
            if(isNotBorder(x,y,n,m)){
             vis[x][y] = true;
             Coordinates c1 = new Coordinates(x,y);
             l.eCoordinates = c1;
             int res = findIslandsUtil(g,vis,x,y,n,m,l);
             if(res == -1) return -1;
             else ans = 1 + res;
            } else{
              return -1;
            }
          }
         
        }
    }
    return ans;
  }

  private static boolean isValid(int x, int y, int n, int m) {
    return (x >= 0 && y>=0 && x<n && y<m);
  }

  private static boolean isNotBorder(int i, int j,int n,int m) {
    if( i==0  || i==n-1 || j==0 || j==m-1  ) return false;
    return true;
  }
}   

class Coordinates{
  public int x;
  public int y;
  public Coordinates(int x,int y){
    this.x = x;
    this.y = y;
  }
}

class Lake implements Comparable<Lake>{
  int len;
  Coordinates sCoordinate;
  Coordinates eCoordinates;
  
  
//  public Lake(int len, Coordinates sCoordinate, Coordinates eCoordinates) {
//    super();
//    this.len = len;
//    this.sCoordinate = sCoordinate;
//    this.eCoordinates = eCoordinates;
//  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + len;
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Lake other = (Lake) obj;
    if (len != other.len)
      return false;
    return true;
  }
  
  @Override
  public int compareTo(Lake l) {
     return this.len - l.len;
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
  