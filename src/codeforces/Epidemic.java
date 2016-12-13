package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Epidemic {

  public static int offset = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    // String[] st = str.split(" ");
    // int n = Integer.parseInt(st[0]);
    String s = br.readLine();
    System.out.println("S is " + s);
    String k = br.readLine();
    System.out.println(k);
    int i;
    String s2 = br.readLine();
    String[] s1 = s.split(" ");
    List<Integer> mList = new ArrayList<Integer>();
    List<Integer> mListFinal = new ArrayList<Integer>();
    // int maxm = Integer.parseInt(s1[0]);
    int sumO = 0;
    int e = -1;
    boolean equal = true;
    for (i = 0; i < s1.length; i++) {
      mList.add(Integer.parseInt(s1[i]));
      sumO += mList.get(i);
      if (mList.get(i) != e) {
        equal = false;
      }
      // maxm = Math.max(maxm, mList.get(i));
    }
    String[] sFinal = s2.split(" ");
    int sumF = 0;
    for (i = 0; i < sFinal.length; i++) {
      mListFinal.add(Integer.parseInt(sFinal[i]));
      sumF += mListFinal.get(i);
    }
    if (sumO != sumF || equal)
      System.out.println("NO");
    else {
      // solution may or may not exist
      // Iterator<Integer> it1 = mList.iterator();
      // Iterator<Integer> it2 = mListFinal.iterator();
      List<Integer> indices = new ArrayList<Integer>();
      indices.add( -1);// always add startIndex
      int j = 0;
      int pIdx = 0;
      int currSum = 0;
      for (i = 0; i < mList.size() && j < mListFinal.size(); i++) {
        int fSum = mListFinal.get(j);
        currSum += mList.get(i);
        if (currSum == fSum) {
          // match occurs
          if (allSame(mList, pIdx, i)) {
            System.out.println("NO");
            System.exit(0);
          }
          indices.add(i);
          j++;
          currSum = 0;
          fSum = 0;
        }
        if (currSum > fSum) {
          System.out.println("NO");
          System.exit(0);
        }

      }
      System.out.println("YES");
      printSolution(indices, mList, mListFinal);

    }

  }

  private static boolean allSame(List<Integer> mList, int s, int e) {
    // boolean equal = true;
    for (int i = s; i < e - 1; i++) {
      if (mList.get(i) != mList.get(i + 1)) {
        return false;
      }
    }
    return true;
  }

  private static void printSolution(List<Integer> indices, List<Integer> mList, List<Integer> mListFinal) {
    int i = 0;
    // boolean[] vis = new boolean[mList.size()];
    while (i < indices.size() - 1) {
      int s = indices.get(i);
      int e = indices.get(i + 1);
      findMoves(mList, s + 1, e);
      i++;
    }

  }

  private static void findMoves(List<Integer> mListOrig, int s, int e) {
    List<Integer> mList = new ArrayList<Integer>(mListOrig);
    int idx = findMax(mList, s, e);
    int val;
    int c = 0;
    while (c < e - s) {
      if (idx - 1 >= s && mList.get(idx - 1) < mList.get(idx)) {
        val = mList.get(idx - 1) + mList.get(idx);
        mList.set(idx, val);
        System.out.println(idx + 1 - offset + "L");
        mList.remove(idx - 1);
        offset++;
        idx = idx- 1;
      } else {
        if (idx + 1 <= e && mList.get(idx + 1) < mList.get(idx)) {
          val = mList.get(idx + 1) + mList.get(idx);
          mList.set(idx, val);
          mList.remove(idx + 1);
        //idx = idx + 1;
          System.out.println(idx - offset + 2 + "R");
          offset++;
        }
      }
      c++;
    }

  }

  private static int findMax(List<Integer> mList, int s, int e) {
    int i;
    int maxm = s;
    int val = 0;
    for (i = s + 1; i <= e; i++) {
      if (mList.get(maxm) <= mList.get(i)) {
        maxm = i;
        val = mList.get(maxm);
      }
    }

    if (maxm == e) {
      // last element high
      while (mList.get(maxm) == val) {
        maxm--;
      }
      maxm++;
    }
    return maxm;

  }

}
