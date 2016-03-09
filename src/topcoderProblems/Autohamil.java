package topcoderProblems;

import java.util.*;

/**
 * 
 * @author agarg
 *  Solution to problem 3 (Div II SRM 684) 
 *  Problem statement => https://community.topcoder.com/stat?c=problem_statement&pm=14183&rd=16688&rm=328231&cr=22936232
 *  Idea is to build a graph and compute transitive closure for it  with an extra check.
 *  Extra check is for checking if 2 nodes are connected to each other or not after reachability matrix has been
 *  computed for it .
 *  I also tried to solve it by doing a DFS but doing that you need to check for some extra information which I couldnt figure
 *  out.  Will update here once I have it.
 *  
 */
public class Autohamil {
	public static String check(int[] z0, int[] z1) {
		int n = z0.length;// no of States
		int[][] adj = new int[n][n];
		int i = 0, j = 0;
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				adj[i][j] = 0;
			}
		}
		boolean[] visited = new boolean[n];
		for (i = 0; i < n; i++)
			visited[i] = false;
		int x, y;
		for (i = 0; i < n; i++) {
			x = z0[i]; // for reading 0
			y = z1[i]; // for reading 1
			adj[i][x] = 1;
			adj[i][y] = 1;
		}
		int k;
		for (k = 0; k < n; k++) {
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					if (adj[i][j] != 1) {
						if (adj[i][k] == 1 && adj[k][j] == 1) {
							adj[i][j] = 1;
						}
					}
				}
			}
		}

		//Important , do not miss this out
		for (i = 0; i < n; i++) {
			adj[i][i] = 1;
		}

		for (i = 1; i < n; i++) {
			if (adj[0][i] != 1) {
				return "Does not exist";
			}
		}
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if (adj[i][j] == 0 && adj[j][i] == 0) {
					return "Does not exist";
				}
			}
		}
		return "Exists";
	}

	public static void main(String[] args) {
		int[] z0 = { 1, 2, 2 };
		int[] z1 = { 2, 2, 2 };
		System.out.println(check(z0, z1));
	}

}


