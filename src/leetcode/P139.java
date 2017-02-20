package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Word Break
 * 
 * @author agarg
 *
 */
public class P139 {

  public static boolean wordBreak(String s, List<String> wordDict) {
    int i, j;
    int n = s.length();
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (i = 1; i <= n; i++) {
      for (j = 0; j < i; j++) {
        if (dp[j] == true && wordDict.contains(s.substring(j, i))) {
          dp[i] = true;
          break;
        }
      }
    }
    return dp[n];
  }

  public static boolean wordBreakBfs(String s, List<String> wordDict) {
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(0);
    int j;
    int n = s.length();
    Set<Integer> set = new HashSet<Integer>();
    while ( !q.isEmpty()) {
      int x = q.poll();
      if ( !set.contains(x)) {
        set.add(x);
        for (j = x; j < n; j++) {
          String s1 = s.substring(x, j + 1);
          if (wordDict.contains(s1)) {
            q.add(j + 1);
            if (j + 1 == n)
              return true;
          }
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    List<String> l = new ArrayList<String>();
    l.add("le");
    l.add("leet");
    l.add("code");
    System.out.println(wordBreak("leetcode", l));
  }
}
