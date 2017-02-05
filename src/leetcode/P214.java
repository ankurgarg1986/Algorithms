package leetcode;

/**
 * Absolutely Elegant solution for this problem 
 * as proposed  by https://discuss.leetcode.com/user/xcv58 
 * @author agarg
 *
 */
public class P214 {

  public static String shortestPalindrome(String s) {
    int j = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == s.charAt(j)) {
        j += 1;
      }
    }
    if (j == s.length()) {
      return s;
    }
    String suffix = s.substring(j);
    //System.out.println(suffix);
    return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;

  }

  public static void main(String[] args) {
    System.out.println(shortestPalindrome("aaacxdcbaa"));

  }

}
