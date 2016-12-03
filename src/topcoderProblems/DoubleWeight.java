package topcoderProblems;

public class DoubleWeight {

  public int minimalCost(String[] w1, String[] w2) {
    int n = w1.length;
    int[][] g = new int[n][n];
    int i, j, k;
    for (i = 0; i < n; i++) {
      String s1 = w1[i];
      String s2 = w2[i];
      for (j = 0; j < s1.length(); j++) {
        if (s1.charAt(j) != '.' && s2.charAt(j) != '.')
          g[i][j] = (s1.charAt(j) - '0' ) * (s2.charAt(j) - '0' );
        else
          g[i][j] = 0;

      }
    }
    for (k = 0; k < n; k++) {
      for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
          g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
        }
      }
    }
    return g[0][1];
  }

  public static void main(String[] args) {
    long time;
    int answer;
    boolean errors = false;
    int desiredAnswer;
    time = System.currentTimeMillis();
    answer = new DoubleWeight().minimalCost(new String[] { "..14", "..94", "19..", "44.." }, new String[] { "..94",
                                                                                                           "..14",
                                                                                                           "91..",
                                                                                                           "44.." });
    System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
    desiredAnswer = 64;
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    System.out.println("Desired answer:");
    System.out.println("\t" + desiredAnswer);
    if (answer != desiredAnswer) {
      errors = true;
      System.out.println("DOESN'T MATCH!!!!");
    } else
      System.out.println("Match :-)");
    System.out.println();
    time = System.currentTimeMillis();
    answer = new DoubleWeight().minimalCost(new String[] { "..14", "..14", "11..", "44.." }, new String[] { "..94",
                                                                                                           "..94",
                                                                                                           "99..",
                                                                                                           "44.." });
    System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
    desiredAnswer = 36;
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    System.out.println("Desired answer:");
    System.out.println("\t" + desiredAnswer);
    if (answer != desiredAnswer) {
      errors = true;
      System.out.println("DOESN'T MATCH!!!!");
    } else
      System.out.println("Match :-)");
    System.out.println();
    time = System.currentTimeMillis();
    answer = new DoubleWeight().minimalCost(new String[] { "..", ".." }, new String[] { "..", ".." });
    System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
    desiredAnswer = -1;
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    System.out.println("Desired answer:");
    System.out.println("\t" + desiredAnswer);
    if (answer != desiredAnswer) {
      errors = true;
      System.out.println("DOESN'T MATCH!!!!");
    } else
      System.out.println("Match :-)");
    System.out.println();
    time = System.currentTimeMillis();
    answer = new DoubleWeight().minimalCost(new String[] { ".....9", "..9...", ".9.9..", "..9.9.", "...9.9", "9...9." },
                                            new String[] { ".....9", "..9...", ".9.9..", "..9.9.", "...9.9", "9...9." });
    System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
    desiredAnswer = 2025;
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    System.out.println("Desired answer:");
    System.out.println("\t" + desiredAnswer);
    if (answer != desiredAnswer) {
      errors = true;
      System.out.println("DOESN'T MATCH!!!!");
    } else
      System.out.println("Match :-)");
    System.out.println();
    time = System.currentTimeMillis();
    answer = new DoubleWeight().minimalCost(new String[] { ".4...1", "4.1...", ".1.1..", "..1.1.", "...1.1", "1...1." },
                                            new String[] { ".4...1", "4.1...", ".1.1..", "..1.1.", "...1.1", "1...1." });
    System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0 + " seconds");
    desiredAnswer = 16;
    System.out.println("Your answer:");
    System.out.println("\t" + answer);
    System.out.println("Desired answer:");
    System.out.println("\t" + desiredAnswer);
    if (answer != desiredAnswer) {
      errors = true;
      System.out.println("DOESN'T MATCH!!!!");
    } else
      System.out.println("Match :-)");
    System.out.println();

    if (errors)
      System.out.println("Some of the test cases had errors :-(");
    else
      System.out.println("You're a stud (at least on the test data)! :-D ");
  }

}