package leetcodeContest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class Obj implements Comparable<Obj> {

  int p;
  int c;

  public Obj(int p, int c) {
    super();
    this.p = p;
    this.c = c;
  }

  @Override
  public int compareTo(Obj o) {
    int diff = o.p - this.p;
    if (diff == 0) {
        diff = o.c - this.c;
    }
    return diff;
  }

}

public class Contest18Hard {

  public static int findMaximizedCapital(int k, int w, int[] p, int[] c) {
    int i;
    PriorityQueue<Obj> pq = new PriorityQueue<Obj>();
    List<Obj> ol = new ArrayList<Obj>();
    for (i = 0; i < p.length; i++) {
      Obj o = new Obj(p[i], c[i]);
      if (w >= c[i]) {
        pq.add(o);
      } else {
        ol.add(o);
      }
    }
    while ( !pq.isEmpty() && k > 0) {
      Obj obj1 = pq.poll();
      w += obj1.p;
      Iterator<Obj> it = ol.listIterator();
      while (it.hasNext()) {
        Obj obj2 = it.next();
        if (w >= obj2.c) {
          pq.add(obj2);
          it.remove();
        }
      }
      k--;

    }
    return w;

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] p = { 1, 2, 3 };
    int[] c = { 11, 12, 13 };
    System.out.println(findMaximizedCapital(11, 11, p, c));
  }

}
