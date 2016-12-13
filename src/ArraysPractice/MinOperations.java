package ArraysPractice;

import java.util.LinkedList;
import java.util.Queue;


class Elem{
  int moves;
  int val;
  public Elem(int i, int x) {
   this.moves = i;
   this.val = x;
  }
  
}
public class MinOperations {

  
  public static void main(String[] args) {
    int x = 2;
    int y = 5;
    System.out.println(minSteps(x,y));
  }

  private static int minSteps(int x, int y) {
    int ans = 9999;
    if(x==y) return 0;
    Elem e = new Elem(0,x);
    Queue<Elem> q = new LinkedList<Elem>();
    q.add(e);
    while(!q.isEmpty()){
        Elem e1 = q.poll();
        int a = 2*e1.val;
        int b =  e1.val - 1;
        int m = e1.moves + 1;
        if(a==y || b==y){
          System.out.println(m);
        }else{
          
        }
    }
    return ans;
  }
}
