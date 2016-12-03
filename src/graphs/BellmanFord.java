package graphs;

import java.util.ArrayList;
import java.util.List;

class Gh {

  private int min = 9999;
  int v;// no of vertices
  int cE;// count of Edges
  List<E> edges;

  public Gh(int v, int cE) {
    this.v = v;
    this.cE = cE;
    this.edges = new ArrayList<E>();
  }

  public void addEdge(E e) {
    this.edges.add(e);
  }

  public int[] bellmanFord(int s) {
     int[] dist = new int[this.v];
     int i,u,v1,w1;
     for(i=0;i<this.v;i++)
        dist[i] = min;
     dist[0] = 0;
     for(i=0;i<this.v-1;i++){
         for(int j=0;j<this.edges.size();j++){
              E e = edges.get(j);
               u = e.s;
               v1 = e.d;
               w1 = e.w;
              dist[v1] = Math.min(dist[v1], dist[u] + w1); 
         }
     }
     
     //check for -ve weight cycle
     for(i=0;i<this.edges.size();i++){
         E e = edges.get(i);
         u = e.s;
         v1 = e.d;
         w1 = e.w;
         if(dist[v1] > dist[u] + w1){
           System.out.println("Negative weight Cycle ..Bellman Fails");
         }
         
     }
     return dist;
  }
  

}

// class to define Edge
class E {

  int s;
  int d;
  int w;

  public E(int s, int d, int w) {
    this.s = s;
    this.d = d;
    this.w = w;
  }

}

public class BellmanFord {

  public static void main(String[] args) {
    Gh g = new Gh(5,8);
    E e1 = new E(0, 0, -1);
    E e2 = new E(0, 2, 4);
    E e3 = new E(1, 2, 3);
    E e4 = new E(1, 3, 2);
    E e5 = new E(1, 4, 2);
    E e6 = new E(3, 2, 5);
    E e7 = new E(3, 1, 1);
    E e8 = new E(4, 3, -3);
    g.addEdge(e1);
    g.addEdge(e2);
    g.addEdge(e3);
    g.addEdge(e4);
    g.addEdge(e5);
    g.addEdge(e6);
    g.addEdge(e7);
    g.addEdge(e8);
    int[] ans  = g.bellmanFord(0);
    for(int i=0;i<ans.length;i++)
      System.out.println(ans[i] + " ");
  }

}
