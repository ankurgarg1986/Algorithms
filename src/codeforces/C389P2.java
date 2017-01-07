package codeforces;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class C389P2 {

  public static void main(String[] args) {
    FastReader sc = new FastReader(System.in);
    String s = sc.nextString();
    int n = s.length();
    String t = sc.nextString();
    char[] s1 = s.toCharArray();
    char[] t1 = t.toCharArray();
    int i = 0, j = 0;
    int ans = 0;
    //Map
    HashSet<Character> se = new HashSet<Character>();
    HashMap<Character, Character> ansMap = new HashMap<Character, Character>();
    while (i < n) {
      if (s1[i] != t1[j]) {
        if(se.contains(s1[i]) || se.contains(t1[j])){
          i++;
          j++;
          continue;
        }
        ansMap.put(s1[i], t1[j]);
        se.add(s1[i]);
        se.add(t1[j]);
        char ch = t1[i];
        char ch1 = s1[i];
        //t1[i] = s1[i];
        for (j = 0; j < n  ; j++) {
          if ( t1[j] == ch1) {
             t1[j] = ch;
          }
          else  if ( t1[j] == ch) {
            t1[j] = ch1;
         }
        }
        j = i;
        ans++;
      }
      i++;
      j++;
    }
    s = String.valueOf(s1);
    t = String.valueOf(t1);
    if (s.equalsIgnoreCase(t)) {
      System.out.println(ans);
      for (char ch1 : ansMap.keySet())
        System.out.println(ch1 + " " + ansMap.get(ch1));
    }else{
      System.out.println(-1);
    }

  }

}
