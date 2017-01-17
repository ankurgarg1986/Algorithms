package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

class Cell {
  
  int si;
  int sj;
  int ei;
  int ej;
  
  public Cell(int si, int sj, int ei, int ej) {
    this.si = si;
    this.sj = sj;
    this.ei = ei;
    this.ej = ej;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ei;
    result = prime * result + ej;
    result = prime * result + si;
    result = prime * result + sj;
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
    Cell other = (Cell) obj;
    if (ei != other.ei)
      return false;
    if (ej != other.ej)
      return false;
    if (si != other.si)
      return false;
    if (sj != other.sj)
      return false;
    return true;
  }
  
}

public class PalindromicPathCount {

  static Map<Cell, Integer> mp = new HashMap<Cell, Integer>();

  public static void main(String[] args) {
    char[][] mat = { { 'a', 'a', 'a', 'b' }, { 'b', 'a', 'a', 'b' }, { 'a', 'b', 'b', 'a' } ,{'b', 'b', 'a', 'a' },{'b', 'a', 'b', 'a' } };
    int r = 5;
    int c = 4;
    System.out.println(getPalindromicPaths(mat, 0, 0, r - 1, c - 1, r, c));

  }

  private static int getPalindromicPaths(char[][] mat, int si, int sj, int ei, int ej, int r, int c) {
    int ans = 0;
    if (si < 0 || si > r || sj < 0 || sj > c)
      return 0;
    if (ei < 0 || ej < 0 || ei < si || ej < sj)
      return 0;
    if (mat[si][sj] != mat[ei][ej])
      return 0;
    if (Math.abs(ei - si) + Math.abs(ej - sj) <= 1)
      return 1;
    if(mp.get(new Cell(si,sj,ei,ej)) != null){
      return mp.get(new Cell(si,sj,ei,ej));
    }
    ans += getPalindromicPaths(mat, si + 1, sj, ei - 1, ej, r, c);
    ans += getPalindromicPaths(mat, si + 1, sj, ei, ej - 1, r, c);
    ans += getPalindromicPaths(mat, si, sj + 1, ei - 1, ej, r, c);
    ans += getPalindromicPaths(mat, si, sj + 1, ei, ej - 1, r, c);
    if(mp.get(new Cell(si,sj,ei,ej)) == null){
      mp.put(new Cell(si,sj,ei,ej),ans);// == null
    }
    return ans;
  }

}
