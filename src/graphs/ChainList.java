package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ChainList {

  static int c = 26;
  static Map<Character, HashSet<Character>> g = new HashMap<Character, HashSet<Character>>();
  static int[] in = new int[26];
  static int[] out = new int[26];
  static Map<Character, Boolean> visited = new HashMap<Character, Boolean>();

  public static void main(String[] args) {
    String[] arr = { "aaa", "abb", "bac" };
    chain(arr);
  }

  private static void chain(String[] arr) {
    int i;
    HashSet<Character> al;
    for (i = 0; i < arr.length; i++) {
      String str = arr[i];
      char s1 = str.charAt(0);
      char s2 = str.charAt(str.length() - 1);
      if (g.get(s1) == null) {
        al = new HashSet<Character>();
        al.add(s2);
        g.put(s1, al);
      } else {
        al = g.get(s1);
        al.add(s2);
        g.put(s1, al);
      }
      in[s1 - 'a']++;
      out[s2 - 'a']++;
      visited.put(s1, false);
      visited.put(s2, false);
    }
    for (i = 0; i < 26; i++) {
      if (in[i] != out[i])
        System.out.println("Not Possible");
        return;
    }
    // graph is now constructed
    dfs(g, arr[0].charAt(0));
    for (Entry e : visited.entrySet()) {
      if (e.getValue().equals(false)) {
        System.out.println("Not Possible");
        return;
      }
    }
    System.out.println("possible");
    return;
  }

  private static void dfs(Map<Character, HashSet<Character>> g, char ch) {
    if (visited.get(ch) == true) {
      return;
    }
    visited.put(ch, true);
    HashSet<Character> val = g.get(ch);
    if (val != null) {

      Iterator<Character> it = val.iterator();
      while (it.hasNext()) {
        char key = it.next();
        dfs(g, key);
      }
    }
  }

}
