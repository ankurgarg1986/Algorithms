package trie;

// Java Program to Implement a Phone
// Directory Using Trie Data Structure
import java.util.HashMap;

class TrieNode {

  // Each Trie Node contains a Map 'child'
  // where each alphabet points to a Trie
  // Node.
  HashMap<Character, TrieNode> child;

  // 'isLast' is true if the node represents
  // end of a contact
  boolean isLast;

  // Default Constructor
  public TrieNode() {
    child = new HashMap<Character, TrieNode>();

    // Initialize all the Trie nodes with NULL
    for (char i = 'a'; i <= 'z'; i++)
      child.put(i, null);

    isLast = false;
  }
}

public class PhoneNumber {

  TrieNode root;

  // Insert all the Contacts into the Trie
  public void insertIntoTrie(String contacts[]) {
    root = new TrieNode();
    for (int i = 0; i < contacts.length; i++) {
      String s = contacts[i];
      insertIntoTrieUtil(root, s);
    }
  }

  private void insertIntoTrieUtil(TrieNode root, String s) {
    int i;
    TrieNode tn = null;
    for (i = 0; i < s.length(); i++) {
      HashMap<Character, TrieNode> tChild = root.child;
      if (tChild.get(s.charAt(i)) == null) {
        // node does not exist
        tn = new TrieNode();
        tChild.put(s.charAt(i), tn);
      } else {
        tn = tChild.get(s.charAt(i));
      }
      if (i == s.length() - 1)
        root.isLast = true;
      root = tn;
    }

  }

  // Display suggestions after every character enter by
  // the user for a given string 'str'
  void displayContacts(String str) {
    int i;
    TrieNode curr = root;
    String prefix = "";
    for (i = 0; i < str.length(); i++) {
      prefix += str.charAt(i);
      char ch = str.charAt(i);
      TrieNode t = curr.child.get(ch);
      System.out.println("Words present for prefix " + prefix + " are ");
      if (t != null) {
        getWordsWithThisPrefix(t, prefix);
        curr = t;
      } else {
        System.out.println("No prefix found for " + prefix);
      }
    }
  }

  private void getWordsWithThisPrefix(TrieNode t, String prefix) {
    if (t.isLast) {
      System.out.println(prefix);
      return;
    }
    HashMap<Character, TrieNode> hm = t.child;
    for (char ch : hm.keySet()) {
      TrieNode t1 = hm.get(ch);
      if (t1 != null) {
        getWordsWithThisPrefix(t1, prefix + ch);
      }
    }
  }

  public static void main(String args[]) {
    PhoneNumber trie = new PhoneNumber();

    String contacts[] = { "gforgeeks", "geeksquiz" };

    trie.insertIntoTrie(contacts);

    String query = "gekk";

    // Note that the user will enter 'g' then 'e' so
    // first display all the strings with prefix as 'g'
    // and then all the strings with prefix as 'ge'
    trie.displayContacts(query);
  }

}
