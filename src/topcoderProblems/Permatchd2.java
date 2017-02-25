package topcoderProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Permatchd2 {

  public int fix(String[] graph)
  {
    int i,j;
    int n = graph.length;
    int edgeCount  = 0;
    int totalEdges =0;
    List<Integer> eCount = new ArrayList<Integer>();
    boolean[] vis = new boolean[n];
    for(i=0;i<n;i++){
      if(!vis[i]){
        edgeCount = dfs(vis,graph,i)/2;
        totalEdges += edgeCount;
        eCount.add(edgeCount);
      }
    }
    int ans = 0;
    if(totalEdges == n*(n-1)/2 && totalEdges %2 ==1) return -1;
    for(i=0;i<eCount.size();i++){
      ans += eCount.get(i)%2;
    }
    return ans;
  }

  private int dfs(boolean[] vis, String[] g, int i) {
//    Queue<Integer> q = new LinkedList<Integer>();
//    q.add(idx);
//     int c = 0;
//     while(!q.isEmpty()){
//       int i = q.poll();
       vis[i] = true;
       int sum =0;
       for(int j=0;j<g.length;j++){
         if(g[i].charAt(j) == 'Y'){    
             sum +=1;
             if(!vis[j]) sum += dfs(vis,g,j);
           
         }
       }

     return sum;
    
  }
  
  
  public static void main(String[] args)
  {
    long time;
    int answer;
    boolean errors = false;
    int desiredAnswer;
    
    time = System.currentTimeMillis();
    answer = new Permatchd2().fix(new String[]{"NNNNNNNNNYNNNNNNNNNNNNNNN", "NNNYNYNNNYNNNNNYNNNNNYNNN",
                                               "NNNNNYNNNNNNYNNNNNYNNNNNN", "NYNNNNYNNNNNYYYNNNNNNNNNN", 
                                               "NNNNNNNNNNNNNNNNNNYNNNNNN", "NYYNNNNNNNNNNNNNNNNNNNNNN",
                                               "NNNYNNNNNNNNNNNNNNNNNNNNN", "NNNNNNNNNYNYYNNNNNNNYNNYN",   
                                               "NNNNNNNNNNNNNNNNNNNNNNYNN", "YYNNNNNYNNNNNNYNYNNNNYNNY", 
                                               "NNNNNNNNNNNYYNNNNNNNYNNNN", "NNNNNNNYNNYNNNYNNNNYNNNNN", 
                                               "NNYYNNNYNNYNNNNNNNNNYNNNN", "NNNYNNNNNNNNNNNNNNNNNNNNN", 
                                               "NNNYNNNNNYNYNNNNNNNYNNNNN", "NYNNNNNNNNNNNNNNNYNNYNNYY", 
                                               "NNNNNNNNNYNNNNNNNNNNNNNYN", "NNNNNNNNNNNNNNNYNNYNNYNNN",
                                               "NNYNYNNNNNNNNNNNNYNNNYNNN", "NNNNNNNNNNNYNNYNNNNNNYYYN", 
                                               "NNNNNNNYNNYNYNNYNNNNNNNNN", "NYNNNNNNNYNNNNNNNYYYNNYNN",
                                               "NNNNNNNNYNNNNNNNNNNYNYNNN", "NNNNNNNYNNNNNNNYYNNYNNNNN", 
                                               "NNNNNNNNNYNNNNNYNNNNNNNNN"});
    System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
    desiredAnswer = 1;
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    System.out.println("Desired answer:");
    System.out.println("\t" + desiredAnswer);
    if (answer != desiredAnswer)
    {
      errors = true;
      System.out.println("DOESN'T MATCH!!!!");
    }
    else
      System.out.println("Match :-)");
    System.out.println();
    time = System.currentTimeMillis();
    answer = new Permatchd2().fix(new String[]{"NYY", "YNN", "YNN"});
    System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
    desiredAnswer = 0;
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    System.out.println("Desired answer:");
    System.out.println("\t" + desiredAnswer);
    if (answer != desiredAnswer)
    {
      errors = true;
      System.out.println("DOESN'T MATCH!!!!");
    }
    else
      System.out.println("Match :-)");
    System.out.println();
    time = System.currentTimeMillis();
    answer = new Permatchd2().fix(new String[]{"NYY", "YNY", "YYN"});
    System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
    desiredAnswer = -1;
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    System.out.println("Desired answer:");
    System.out.println("\t" + desiredAnswer);
    if (answer != desiredAnswer)
    {
      errors = true;
      System.out.println("DOESN'T MATCH!!!!");
    }
    else
      System.out.println("Match :-)");
    System.out.println();
    time = System.currentTimeMillis();
    answer = new Permatchd2().fix(new String[]{"NYYY", "YNYY", "YYNN", "YYNN"});
    System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
    desiredAnswer = 1;
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    System.out.println("Desired answer:");
    System.out.println("\t" + desiredAnswer);
    if (answer != desiredAnswer)
    {
      errors = true;
      System.out.println("DOESN'T MATCH!!!!");
    }
    else
      System.out.println("Match :-)");
    System.out.println();
    time = System.currentTimeMillis();
    answer = new Permatchd2().fix(new String[]{"NYNNNN", "YNNNNN", "NNNYNN", "NNYNNN", "NNNNNY", "NNNNYN"});
    System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
    desiredAnswer = 3;
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    System.out.println("Desired answer:");
    System.out.println("\t" + desiredAnswer);
    if (answer != desiredAnswer)
    {
      errors = true;
      System.out.println("DOESN'T MATCH!!!!");
    }
    else
      System.out.println("Match :-)");
    System.out.println();
    time = System.currentTimeMillis();
    answer = new Permatchd2().fix(new String[]{"N"});
    System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
    desiredAnswer = 0;
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    System.out.println("Desired answer:");
    System.out.println("\t" + desiredAnswer);
    if (answer != desiredAnswer)
    {
      errors = true;
      System.out.println("DOESN'T MATCH!!!!");
    }
    else
      System.out.println("Match :-)");
    System.out.println();
    
    if (errors)
      System.out.println("Some of the test cases had errors :-(");
    else
      System.out.println("You're a stud (at least on the test data)! :-D ");
  }

}
