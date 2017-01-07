package codeforces;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C390P4 {
  
  public static void main(String[] args) {
    FastScanner sc = new FastScanner();
    int n  = sc.nextInt();int k = sc.nextInt();
    Interval[] in  = new Interval[n];
    int i;
    for(i=0;i<n;i++){
      in[i]= new Interval(sc.nextInt(),sc.nextInt(),i+1);
    }
    Arrays.sort(in,new SortComparable());
    PriorityQueue<Interval> pq = new PriorityQueue<Interval>();
    int ans = 0;
    int idx = n-1;
    for(i=0;i<n;i++){
      pq.add(in[i]);
      if(pq.size() > k){
        pq.poll();
      }
      if(pq.size() == k){
        Interval ix = pq.peek();
        if(ix.e - in[i].s + 1 > ans){
          ans = ix.e - in[i].s + 1 ;
          idx = i;
        }
      }
    }
    System.out.println(ans);
    pq = new PriorityQueue<Interval>();
    for(i=0;i<n;i++){
      pq.add(in[i]);
      if(pq.size() > k){
        pq.poll();
      }
      if(i == idx){
         int z = pq.size();
         for(int j=0;j<z;j++){
           Interval ix = pq.poll();
           System.out.print(ix.id  + " ");
         }
         return;
      }
    }
  }

}

class Interval implements Comparable<Interval>{
  int s;
  int e;
  int id;
  public Interval(int s,int e,int id){
    this.s = s;
    this.e =e;
    this.id = id;
  }
  @Override
  public int compareTo(Interval o) {
    return this.e - o.e;
  }
  
 
}
class SortComparable implements Comparator<Interval>{

@Override
public int compare(Interval o1, Interval o2) {
   return o1.s - o2.s;
}

}
class FastScanner {
  BufferedReader br;
  StringTokenizer st;

  public FastScanner() {
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  public FastScanner(String s) {
    try {
      br = new BufferedReader(new FileReader(s));
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public String nextToken() {
    while (st == null || !st.hasMoreTokens()) {
      try {
        st = new StringTokenizer(br.readLine());
      } catch (IOException e) {
      }
    }
    return st.nextToken();
  }

  public int nextInt() {
    return Integer.parseInt(nextToken());
  }

  public long nextLong() {
    return Long.parseLong(nextToken());
  }

  public double nextDouble() {
    return Double.parseDouble(nextToken());
  }
}


