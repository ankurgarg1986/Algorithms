package topcoderProblems;

import java.util.PriorityQueue;

/**
 * 
 * @author agarg Problem from TCCC 2004 Round 4 . Detailed Statement can be
 *         found here
 *         https://community.topcoder.com/stat?c=problem_statement&pm=
 *         2274&rd=5009 This is an example of shortest path problem and how we
 *         can use Dijiktra to solve this
 * 
 */

class Position implements Comparable<Position> {
	int x; // x co-ordinate
	int y; // y co -ordinate
	int time;// current time taken to reach this position
	int bombsLeft;

	public Position(int x, int y, int time, int bombsLeft) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
		this.bombsLeft = bombsLeft;
	}

	@Override
	public int compareTo(Position p) {
		// TODO Auto-generated method stub
		if (this.time > p.time)
			return 1;
		if (this.time < p.time)
			return -1;
		return 0;
	}
}

public class BombMan {

	int m;
	int n;
	boolean[][][] visited;
	PriorityQueue<Position> pq = new PriorityQueue<Position>();

	private void insertIntoPQ(int x, int y,Position pos,String[] maze) {
		int time = pos.time;
		time++;
		int b = pos.bombsLeft;
		if(x < 0 || x >= m || y <0 || y >=n || b<0 ) return;
		if(maze[x].charAt(y) == '#')
		{
			time = time+2;
			b--;
		}
		if(b<0) return;
		if(visited[x][y][b]) return;
	    pq.add(new Position(x,y,time,b));	
  }

	public int shortestPath(String[] maze, int bombs) {

		int i = 0, j = 0;
		int sX = 0, sY = 0;
		int eX = 0, eY = 0;
		m = maze.length;
		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, -1, 0, 1 };
		n = maze[0].length();
		 visited = new boolean[m][n][bombs + 1];
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				if (maze[i].charAt(j) == 'B') {
					sX = i;
					sY = j;
					pq.add(new Position(i, j, 0, bombs)); // Adding the starting
															// position to
															// Priority Queue
				}
				if (maze[i].charAt(j) == 'E') {
					eX = i;
					eY = j;
				}
				for (int k = 0; k <= bombs; k++) {
					visited[i][j][k] = false;
				}

			}
		}
		int newX;
		int newY;
		while (!pq.isEmpty()) {
			Position pos = pq.poll();
			if (pos.x == eX && pos.y == eY)
				return pos.time;
			if(visited[pos.x][pos.y][pos.bombsLeft]) continue;
			visited[pos.x][pos.y][pos.bombsLeft] = true;
			for (i = 0; i < 4; i++) {
				newX = pos.x + dx[i];
				newY = pos.y + dy[i];
				insertIntoPQ(newX, newY, pos,maze);
			}

		}

		return -1;
	}

	// BEGIN CUT HERE
	public static void main(String[] args) {
		try {
			eq(0,
					(new BombMan()).shortestPath(new String[] { ".....B.",
							".#####.", ".#...#.", ".#E#.#.", ".###.#.",
							"......." }, 1), 8);
			eq(1, (new BombMan()).shortestPath(new String[] { "B.#.#.#...E" },
					2), -1);
			eq(2,
					(new BombMan()).shortestPath(new String[] { "..#####",
							"B.#####", "..#####", "#######", "####...",
							"####.E." }, 4), 17);
			eq(3, (new BombMan()).shortestPath(new String[] {
					".#.#.#.#B#...#.#...#.#...#.#...#.#...#.#.#.......",
					".#.#.#.#.#.###.###.#.###.#.#.###.###.#.#.#.###.##",
					".#.#.#...#.#.#.#.#.#...#.....#.#.#...#...#.#.#...",
					".#.#.###.#.#.#.#.#.###.#.#####.#.###.###.#.#.###.",
					".............#.#...#...#.....#.#.#...#.#.#.....#.",
					"##.#######.###.#.#####.#.#####.#.###.#.#.#.#.####",
					".#.#.....#...#...#.#...#...#.#.#...#...#...#.....",
					".#######.#.#####.#.#.#.#.###.#.###.#.#####.#.####",
					".#.#.#.#...#.#.#.#.#.#.......#...#.#...#.#.#.....",
					".#.#.#.###.#.#.#.#.#####.#####.###.###.#.#.######",
					".....#...#.#...#...#...#...#...#...#.#.#.........",
					"####.###.#.###.###.#.###.#.#.###.###.#.#.########",
					".......#.........#.#.#.#.#.#.#.#.........#...#...",
					".#.###.#########.#.#.#.#.###.#.#####.#.#.#.###.##",
					".#.#.........#.#.#.#.#.....#.#.#.....#.#.........",
					"############.#.#.#.#.#.#####.#.#.################",
					".#...........#...#.#.#.#...#.#.#...#.#.#.....#...",
					".#####.#####.###.#.#.#.#.###.#.#.###.#.#.#####.##",
					".......#...#.#.#.....#...#...#.#.#.#.#...........",
					"##########.#.#.#####.#.###.###.#.#.#.#.##########",
					".....#...#.....#.#...#.......#.#...#.......#.....",
					"##.#.###.#.###.#.#.#.#.#####.#.#.###.#######.####",
					"...#...#...#.......#.....#.#...#...#.......#.....",
					"####.#.#.#########.#.###.#.#####.###.#.#######.##",
					".#...#...#.........#.#.....#.........#.#.#.#.....",
					".#####.#.#.###.#######.#.###.#.#########.#.#.####",
					".......#.#.#...#.......#.....#.#.#.......#.#.#.#.",
					"########.#.#.#.#####.#.###.#.###.#.#######.#.#.#.",
					".........#.#.#.#.....#...#.#.........#.#.........",
					"################.#.#.#.#.#.#.#.#######.#.########",
					".................#.#.#.#.#.#.#...........#.......",
					"########.#####.#.###.#.#.#####.###.#.#####.###.##",
					".........#...#.#...#.#.#...#.....#.#.........#...",
					".#####.#####.#.###.#.###.#.#.#.#.#.#####.#.###.#.",
					".#.....#.........#.#.#...#.#.#.#.#.#.....#...#.#.",
					"####.#####.###.#.#.#.#.#.#.###.###.#.#.#.#.#####.",
					".....#.....#.#.#.#.#.#.#.#.#...#...#.#.#.#...#...",
					"####.#.#.###.#.#.###.#.###.#.#.#####.#.#.#.######",
					".....#.#.#.#...#...#.#...#.#.#...#...#.#.#.......",
					"##########.#.#.#.#####.###.#.#.###.#.###.#####.##",
					"...#.#...#...#.#.....#.#...#.#...#.#.#.......#...",
					".#.#.#.#.#.#.#.#.#.#.###.#.#########.###.#.#.#.#.",
					".#.#...#...#.#.#.#.#...#.#...#.......#...#.#.#.#.",
					"##.###.#.#.###.#.#.#.#.#####.#.#.#.###.#.########",
					".......#.#...#.#.#.#.#.#.....#.#.#...#.#.........",
					"####.#######.#.#####.#.###.#.#.###.#.#.#.########",
					"E..#.......#.#.....#.#.#.#.#.#.#...#.#.#.........",
					"##.#.#.#.###.###.###.###.#.#.###.#.#.#.#.#######.",
					".....#.#...#.#.....#.#.....#...#.#.#.#.#.....#..." }, 3),
					76);
		} catch (Exception exx) {
			System.err.println(exx);
			exx.printStackTrace(System.err);
		}
	}

	private static void eq(int n, int a, int b) {
		if (a == b)
			System.err.println("Case " + n + " passed.");
		else
			System.err.println("Case " + n + " failed: expected " + b
					+ ", received " + a + ".");
	}

	@SuppressWarnings("unused")
	private static void eq(int n, char a, char b) {
		if (a == b)
			System.err.println("Case " + n + " passed.");
		else
			System.err.println("Case " + n + " failed: expected '" + b
					+ "', received '" + a + "'.");
	}

	@SuppressWarnings("unused")
	private static void eq(int n, long a, long b) {
		if (a == b)
			System.err.println("Case " + n + " passed.");
		else
			System.err.println("Case " + n + " failed: expected \"" + b
					+ "L, received " + a + "L.");
	}

	private static void eq(int n, boolean a, boolean b) {
		if (a == b)
			System.err.println("Case " + n + " passed.");
		else
			System.err.println("Case " + n + " failed: expected " + b
					+ ", received " + a + ".");
	}

	private static void eq(int n, String a, String b) {
		if (a != null && a.equals(b))
			System.err.println("Case " + n + " passed.");
		else
			System.err.println("Case " + n + " failed: expected \"" + b
					+ "\", received \"" + a + "\".");
	}

	private static void eq(int n, int[] a, int[] b) {
		if (a.length != b.length) {
			System.err.println("Case " + n + " failed: returned " + a.length
					+ " elements; expected " + b.length + " elements.");
			return;
		}
		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i]) {
				System.err
						.println("Case "
								+ n
								+ " failed. Expected and returned array differ in position "
								+ i);
				print(b);
				print(a);
				return;
			}
		System.err.println("Case " + n + " passed.");
	}

	private static void eq(int n, long[] a, long[] b) {
		if (a.length != b.length) {
			System.err.println("Case " + n + " failed: returned " + a.length
					+ " elements; expected " + b.length + " elements.");
			return;
		}
		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i]) {
				System.err
						.println("Case "
								+ n
								+ " failed. Expected and returned array differ in position "
								+ i);
				print(b);
				print(a);
				return;
			}
		System.err.println("Case " + n + " passed.");
	}

	private static void eq(int n, String[] a, String[] b) {
		if (a.length != b.length) {
			System.err.println("Case " + n + " failed: returned " + a.length
					+ " elements; expected " + b.length + " elements.");
			return;
		}
		for (int i = 0; i < a.length; i++)
			if (!a[i].equals(b[i])) {
				System.err
						.println("Case "
								+ n
								+ " failed. Expected and returned array differ in position "
								+ i);
				print(b);
				print(a);
				return;
			}
		System.err.println("Case " + n + " passed.");
	}

	private static void print(int a) {
		System.err.print(a + " ");
	}

	private static void print(long a) {
		System.err.print(a + "L ");
	}

	private static void print(String s) {
		System.err.print("\"" + s + "\" ");
	}

	private static void print(int[] rs) {
		if (rs == null)
			return;
		System.err.print('{');
		for (int i = 0; i < rs.length; i++) {
			System.err.print(rs[i]);
			if (i != rs.length - 1)
				System.err.print(", ");
		}
		System.err.println('}');
	}

	private static void print(long[] rs) {
		if (rs == null)
			return;
		System.err.print('{');
		for (int i = 0; i < rs.length; i++) {
			System.err.print(rs[i]);
			if (i != rs.length - 1)
				System.err.print(", ");
		}
		System.err.println('}');
	}

	private static void print(String[] rs) {
		if (rs == null)
			return;
		System.err.print('{');
		for (int i = 0; i < rs.length; i++) {
			System.err.print("\"" + rs[i] + "\"");
			if (i != rs.length - 1)
				System.err.print(", ");
		}
		System.err.println('}');
	}

	private static void nl() {
		System.err.println();
	}
	// END CUT HERE
}
