package ArraysPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestUber {

  public static String GetSExpression(String s) {
    boolean[][] graph = new boolean[26][26];
    int i, j;
    for (i = 0; i < 26; i++) {
      for (j = 0; j < 26; j++)
        graph[i][j] = false;
    }
    Set<Character> set = new TreeSet<Character>();
    boolean flag = false;
    for (i = 1; i < s.length(); i += 6) {
      int a = s.charAt(i) - 'A';
      int b = s.charAt(i + 2) - 'A';
      if (graph[a][b])
        flag = true;
      graph[a][b] = true;
      set.add(s.charAt(i));
      set.add(s.charAt(i + 2));
    }

    for (i = 0; i < 26; i++) {
      int c = 0; 
      for (j = 0; j < 26; j++) {
        if (graph[i][j]) {
          c++;
          if (c > 2)
            return "E1";
        }
      }

    }
    if (flag)
      return "E2";
 
    /** check for E3 **/
    int numOfRoots = 0;
    char root = ' ';
    Iterator<Character> it = set.iterator();
    while (it.hasNext()) {
      Character ch = it.next();
      for (i = 0; i < 26; i++) {
        if (graph[i][ch - 'A'])
          break;
        if (i == 25) {
          //no lexiographical element found
          numOfRoots++;
          root = ch;
          boolean[] visited = new boolean[26];
          if (CheckForCycleDFS(ch, graph, visited))
            return "E3";
        }
      }
    }
    if (numOfRoots == 0)
      return "E3"; 
    if (numOfRoots > 1)
      return "E4"; 
    if (root == ' ')
      return "E5";
    return GetExpressionHelper(root, graph);

  }

  private static boolean CheckForCycleDFS(char node, boolean[][] graph, boolean[] visited) {
    if (visited[node - 'A']) 
      return true;
    visited[node - 'A'] = true;
    for (int i = 0; i < 26; i++) {
      if (graph[node - 'A'][i]) {
        if (CheckForCycleDFS((char) (i + 'A'), graph, visited))
          return true;
      }
    }
    return false;
  }

 
  private static String GetExpressionHelper(char root, boolean[][] graph) {
    String left = "", right = ""; 
    for (int i = 0; i < 26; i++) {
      if (graph[root - 'A'][i]) {
        left = GetExpressionHelper((char) (i + 'A'), graph);
        for (int j = i + 1; j < 26; j++) {
          if (graph[root - 'A'][j]) {
            right = GetExpressionHelper((char) (j + 'A'), graph);
            break;
          }
        }
        break;
      }
    }
    return "(" + root + left + right + ")";
  }

  public static void main(String[] args) {
    String s = "(A,B) (A,C) (B,D) (D,C)";
   // String s = "(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)";
    System.out.println(GetSExpression(s));
  }
}
