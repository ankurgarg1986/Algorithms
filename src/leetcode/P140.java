package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P140 {

  public static List<String> wordBreak(String s, Set<String> wordDict) {
    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
  }

  // DFS function returns an array including all substrings derived from s.
  public static List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
    if (map.containsKey(s))
      return map.get(s);

    LinkedList<String> res = new LinkedList<String>();
    if (s.length() == 0) {
      res.add("");
      return res;
    }
    for (String word : wordDict) {
      if (s.startsWith(word)) {
        List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
        for (String sub : sublist)
          res.add(word + (sub.isEmpty() ? "" : " ") + sub);
      }
    }
    map.put(s, res);
    return res;
  }
  
  public static void main(String[] args) {
      String s = "catsanddog";
      Set<String> wordDict = new HashSet<String>();
      wordDict.add("cat");
      wordDict.add("cats");
      wordDict.add("and");
      wordDict.add("sand");
      wordDict.add("dog");
      wordBreak(s,wordDict);
  }
}
