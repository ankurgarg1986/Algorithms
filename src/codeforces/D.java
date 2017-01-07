package codeforces;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class D {

  public static void main(String[] args) throws Exception {
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    Scanner s = new Scanner(System.in);

    String[] split = f.readLine().split("\\s+");
    int n = Integer.parseInt(split[0]);

    /*
     * There are two cases when handling this problem: Gonna call the current string s1. if s1 is not a palindrome:
     * Gotta check if the reverse of s1 is present and if it is, make concatenations until the sum becomes less than
     * zero. if s1 is a palindrome: Here there are two cases. Either one of these strings can function alone (and in the
     * middle of the string; there can only be one of these) Or these strings go together to form a pair. So it can
     * either be s1...s1 or just ...s1... When making pairs with a palindrome string, it's necessary to keep track of
     * the smallest value used overall. If that smallest value is negative, we essentially remove it by setting an extra
     * variable to zero (if the smallest value were to be positive, then this extra variable would have that value).
     * Then we iterate over all palindromic strings and find the maximum one which is suitable to be in the middle.
     */

    TreeMap<String, Type> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      split = f.readLine().split("\\s+");
      String w = split[0];
      int val = Integer.parseInt(split[1]);
      if ( !map.containsKey(w)) {
        map.put(w, new Type(w));
        map.get(w).values = new PriorityQueue<>(new Comp());
        map.get(w).isPalindrome = w.equals(palin(w));
      }
      map.get(w).values.add(val);
    }

    int res = 0;
    int minPalindrome = 0;
    for (Entry<String, Type> str : map.entrySet()) {
      Type use = str.getValue();
      if (use.isPalindrome && use.values.size() < 2) { // cannot make any palindromic pairs
        continue;
      }
      String reverse = palin(str.getKey());
      if ( !map.containsKey(reverse))
        continue; // cant make any pairs with this
      Type rev = map.get(reverse);

      while ( !use.values.isEmpty() && !rev.values.isEmpty()) {
        if (use.isPalindrome && use.values.size() == 1)
          break;
        int v1 = use.values.poll(), v2 = rev.values.poll();
        if (v1 + v2 >= 0) { // this is an improvement
          res += v1 + v2;
          if (use.isPalindrome) { // keep track of minimum palindrome usages
            minPalindrome = Math.min(minPalindrome, v1);
            minPalindrome = Math.min(minPalindrome, v2);
          }
        } else { // not an improvement so go ahead and add it back in.
          use.values.add(v1);
          rev.values.add(v2);
          break;
        }
      }
    }
    int max = Math.max(0, -minPalindrome); // If minPalindrome is negative, then multiplying by -1 is essentially
                                           // undoing its addition into res (its not optimal).
    for (Entry<String, Type> str : map.entrySet()) { // look for the largest palindromic value to add for by itself
      if (str.getValue().values.isEmpty() == false && str.getValue().isPalindrome)
        max = Math.max(max, str.getValue().values.peek());
    }

    System.out.println(Math.max(0, res + max));
  }

  private static String palin(String string) {
    return new StringBuilder(string).reverse().toString();
  }

  static class Comp implements Comparator<Integer> {

    public int compare(Integer o1, Integer o2) {
      return o2 - o1;
    }
  }
}

class Type {

  PriorityQueue<Integer> values; // sorts from largest to smallest
  boolean isPalindrome; // whether or not this is a palindrome
  String word; // the actual word

  public Type(String s) {
    word = s;
    isPalindrome = false;
  }
}
