package codeforces;


import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C380 {
  public static void main(String[] args) {
    InputReader in = new InputReader();
    PrintWriter out = new PrintWriter(System.out);
    final long start = System.currentTimeMillis();
    new Task1().solve(in, out);
    @SuppressWarnings("unused")
    final long duration = System.currentTimeMillis() - start;
    out.close();
  }
  
  static class Pair implements Comparable<Pair>{
    Integer cost, fuel;
    public Pair(int cost, int fuel){
      this.cost = cost;
      this.fuel = fuel;
    }
    
    public int compareTo(Pair x){
      if(this.fuel>x.fuel) return 1;
      else if(this.fuel<x.fuel) return -1;
      else {
        return x.cost.compareTo(this.cost);
      }
    }
  }

  static class Task1 {
    int[] gas;
    int k, n, s, t;
    public void solve(InputReader in, PrintWriter out) {
      n = in.nextInt();   //number of cars
      k = in.nextInt();   //number of gas stations
      s = in.nextInt();   //total distance
      t = in.nextInt();   //total time
      
      Pair[] cars = new Pair[n];
      for(int i=0; i<n; i++){
        int cost = in.nextInt(), fuel = in.nextInt();
        cars[i] = new Pair(cost, fuel);
      }
      
      gas = new int[k];
      for(int i=0; i<k; i++){
        gas[i] = in.nextInt();
      }
      
      Arrays.parallelSort(cars);
      Arrays.parallelSort(gas);
      
      //select cars in nlogn time and then check whether its possible to reach or not
      int lo=0, hi=n-1, mid = (n-1)/2;
      while(lo<=hi){
        mid = lo+(hi-lo)/2;
        if(check(cars[mid])){
          hi = mid-1;
        } else {
          lo = mid+1;
        }
      }
      
      if(hi<n-1){
        int min = cars[hi+1].cost;
        for(int i=hi+1; i<n; i++){
          min = Math.min(min, cars[i].cost);
        }
        out.println(min);
      }
      else out.println(-1);
    }
    
    boolean check(Pair x){
      int pos = 0, time=0;
      for(int i=0; i<k; i++){
        //cover this distance in min time possible
        int distance = gas[i]-pos;
        if(x.fuel<distance){
          return false;
        }
        time += Math.max(distance, (3*distance - x.fuel));
        pos = gas[i];
        //System.out.print(time+" ");
      }
      int distance = s-pos;
      if(x.fuel<distance){
        return false;
      }
      time += Math.max(distance, (3*distance - x.fuel));
      //System.out.println(time+" "+x.fuel);
      if(time<=t) return true;
      else return false;
    }
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader() {
      reader = new BufferedReader(new InputStreamReader(System.in));
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public String nextLine() {
      String s = null;
      try {
        s = reader.readLine();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      return s;
    }

    public String nextParagraph() {
      String line = null;
      String ans = "";
      try {
        while ((line = reader.readLine()) != null) {
          ans += line;
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      return ans;
    }

  }
}
