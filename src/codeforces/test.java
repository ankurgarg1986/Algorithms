package codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class test {
  private static class Pair {
    char a;
    char b;
    
    public Pair(char a, char b) {
      this.a = a;
      this.b = b;
    }
  }
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String input = br.readLine();
    String output = br.readLine();
    
    int[] keys = new int[26];
    for(int i=0; i<26; i++) {
      keys[i] = -1;
    }
    
    List<Pair> pairs = new ArrayList<Pair>();
    boolean possible = true;
    for(int i=0; i<input.length(); i++) {
      if(keys[input.charAt(i)-'a'] == -1) {
        if(keys[output.charAt(i) - 'a'] == -1) {
          if(input.charAt(i) == output.charAt(i)) {
            keys[input.charAt(i) - 'a'] = output.charAt(i) - 'a';
          } else {
            keys[input.charAt(i) - 'a'] = output.charAt(i) - 'a';
            keys[output.charAt(i) - 'a'] = input.charAt(i) - 'a';
            
            pairs.add(new Pair(input.charAt(i), output.charAt(i)));
          }
        } else {
          possible = false;
          break;
        }
      } if(keys[input.charAt(i) - 'a'] != (output.charAt(i) - 'a')) {
        possible = false;
        break;
      }
    }

    if(!possible) {
      System.out.println("-1");
    } else {
      System.out.println(pairs.size());
      for(int i=0; i<pairs.size(); i++) {
        System.out.println(pairs.get(i).a + " " + pairs.get(i).b);
      }
    }
  }
}