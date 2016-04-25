package graphs;

import java.util.LinkedList;
import java.util.Queue;

class QueueEntry {
	int v;
	int dist;

	public QueueEntry(int v, int d) {
		// TODO Auto-generated constructor stub
		this.v = v;
		this.dist = d;
	}
}

public class SnakeLadder {

	private static int getMinDiceThrows(int[] moves, int N) {
		int ans = 0;
		Queue<QueueEntry> q = new LinkedList<QueueEntry>();
		QueueEntry qe = new QueueEntry(0, 0);
		q.add(qe);
		int i = 0;
		boolean[] visited = new boolean[N];
		QueueEntry q1 = null;
		for (i = 0; i < N; i++)
			visited[i] = false;
		while (!q.isEmpty()) {
			 q1 = q.poll();
			if (q1.v == N - 1) {
				break;
			}

			for (i = q1.v + 1; i <= q1.v + 6 && i<N; i++) {
				if(!visited[i])
				{
                    visited[i] = true;
					if(moves[i] == -1)
                    {
                    	q.add(new QueueEntry(i,q1.dist + 1));
                    }
                    else
                    {
                    	if(!visited[moves[i]])
                    	  q.add(new QueueEntry(moves[i],q1.dist+1));
                    }
				}
			}

		}
		return q1.dist;

	}

	public static void main(String[] args) {
		int N = 30;
		int[] moves = new int[30];
		for (int i = 0; i < N; i++)
			moves[i] = -1;

		// Ladders
		moves[2] = 21;
		moves[4] = 7;
		moves[10] = 25;
		moves[19] = 28;

		// Snakes
		moves[26] = 0;
		moves[20] = 8;
		moves[16] = 3;
		moves[18] = 6;

		System.out.println("Min Dice throws required is "
				+ getMinDiceThrows(moves, N));
		// return 0;
	}

}
