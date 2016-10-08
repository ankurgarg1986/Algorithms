package graphs;

import java.util.LinkedList;
import java.util.Queue;

class QueueEle {
	int x;
	int y;
	int time;

	public QueueEle(int x, int y, int time) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
	}

}

public class RotOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		int ans = rotOranges(arr);
		if (ans == -1)
			System.out.println("All oranges cannot rot\n");
		else
			System.out
					.println("Time required for all oranges to rot => " + ans);
	}

	/**
	 * Function to compute Min time taken for All Oranges to Rot
	 * 
	 * @param arr
	 * @return
	 */
	private static int rotOranges(int[][] arr) {
		int ans = -1;
		int x = arr.length;// rows
		int y = arr[0].length;// col
		boolean[][] vis = new boolean[x][y];
		int i, j;
		boolean flag = true;
		Queue<QueueEle> q = new LinkedList<QueueEle>();
		for (i = 0; i < x; i++) {
			for (j = 0; j < y; j++) {
				vis[i][j] = false;
				if (arr[i][j] == 2) {
					QueueEle qe = new QueueEle(i, j, 0);
					q.add(qe);
				}
				if (arr[i][j] == 1)
					flag = false;
			}
		}
		if (flag)
			return 0;
		while (!q.isEmpty()) {
			QueueEle qe = q.poll();
			int a = qe.x;
			int b = qe.y;
			int t = qe.time;
			if (!vis[a][b]) {
				vis[a][b] = true;
				int[] dx = { -1, 1, 0, 0 };
				int[] dy = { 0, 0, -1, 1 };
				for (i = 0; i < 4; i++) {
					a = a + dx[i];
					b = b + dy[i];
					if (isSafe(a, b,x,y)) {
						if (arr[a][b] == 1) {
							arr[a][b] = 2;
							q.add(new QueueEle(a, b, t + 1));
						}
					}
				}
			}
		}

		return 0;
	}

	private static boolean isSafe(int a, int b,int x,int y) {
		// TODO Auto-generated method stub
		return ( a>=0 && a<x && b>=0 && b<y );
		//return false;
	}
}
