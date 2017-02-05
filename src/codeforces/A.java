package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class A {



  static int arr1[],arr2[],n,l;
  public static void main(String[] args) throws IOException {
    Scanner sc=new Scanner(System.in);
    PrintWriter out=new PrintWriter(System.out);
     n=sc.nextInt();
     l=sc.nextInt();
     arr1=new int [n];
     arr2=new int [n];
    for (int i = 0; i < n; i++) {
      arr1[i]=sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      arr2[i]=sc.nextInt();

    }
    Arrays.sort(arr2);
    for (int i = 0; i < l; i++) {
      if(valid()){
        System.out.println("YES");return;
      }
    }
    System.out.println("NO");



    out.flush();
    
    
  }
static boolean valid(){
  for (int i = 0; i < n; i++) {
    arr1[i]+=1;
    arr1[i]%=l;
  }
  int[] arr3=arr1.clone();
  Arrays.sort(arr3);
  for (int i = 0; i <n ; i++) {
    if(arr3[i]!=arr2[i])return false;
  }

return true;
}



static class Scanner 
{
  StringTokenizer st;
  BufferedReader br;

  public Scanner(InputStream s){  br = new BufferedReader(new InputStreamReader(s));}

  public String next() throws IOException 
  {
    while (st == null || !st.hasMoreTokens()) 
      st = new StringTokenizer(br.readLine());
    return st.nextToken();
  }

  public int nextInt() throws IOException {return Integer.parseInt(next());}
  
  public long nextLong() throws IOException {return Long.parseLong(next());}

  public String nextLine() throws IOException {return br.readLine();}
  
  public double nextDouble() throws IOException
  {
    String x = next();
    StringBuilder sb = new StringBuilder("0");
    double res = 0, f = 1;
    boolean dec = false, neg = false;
    int start = 0;
    if(x.charAt(0) == '-')
    {
      neg = true;
      start++;
    }
    for(int i = start; i < x.length(); i++)
      if(x.charAt(i) == '.')
      {
        res = Long.parseLong(sb.toString());
        sb = new StringBuilder("0");
        dec = true;
      }
      else
      {
        sb.append(x.charAt(i));
        if(dec)
          f *= 10;
      }
    res += Long.parseLong(sb.toString()) / f;
    return res * (neg?-1:1);
  }
  
  public boolean ready() throws IOException {return br.ready();}


}
}