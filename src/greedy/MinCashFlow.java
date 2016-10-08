package greedy;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class MinCashFlow {

	public static void main(String[] args) throws IOException {

		Scanner s = new Scanner(System.in);
		int p = 1 ;
		while (true) {
			int n = s.nextInt();
			int i, j;
			int[][] graph = new int[n][n];
			int sum = 0;
			if(n==0) break;
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					int x = s.nextInt();
					sum += x;
					graph[i][j] = x;
				}
			}
			//BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
			//System.out.println("\n");
			 OutputStream log = new BufferedOutputStream ( System.out );
			 
			log.write((p + ". " ).getBytes());
			log.write((sum + " ").getBytes());
			int ans = minCashFlow(graph);
			log.write(ans);
			log.write(("\n").getBytes());
			p++;
		}
     }

	private static int minCashFlow(int[][] g) {
		int ans = 0;
		int n = g.length;
		int[] res = new int[n];
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if (g[i][j] != 0) {
					// i owes to j
					res[i] -= g[i][j];
					res[j] += g[i][j];
				}
			}
		}
		for (i = 0; i < n; i++) {
			if (res[i] > 0) {
				ans += res[i];
			}
		}
		// PrintOutput(res);
		return ans;

	}

}
