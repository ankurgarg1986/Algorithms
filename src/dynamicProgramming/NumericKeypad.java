package dynamicProgramming;

class Pos {
	int x;
	int y;
}

public class NumericKeypad {

	public static void main(String[] args) {
		char[][] pad = { { '1', '2', '3' }, { '4', '5', '6' },
				{ '7', '8', '9' }, { '*', '0', '#' } };
		int n = 5;
		System.out.println(countWays(pad, n));

	}
	

	private static int countWays(char[][] pad, int n) {
		int ans = 0;
		if (n == 0)
			return 0;
		if (n == 1)
			return 10;
		int  j;
		// for(i=2;i<=n;i++)
		// {
		for (j = 0; j <= 9; j++) {
			Pos p = getPos(pad,j);
			ans = ans + countWaysHelper(p, pad, n);
		}
		// }
        return ans;
	}

	private static int countWaysHelper(Pos p, char[][] pad, int n) {
		if(n<=0) return 0;
		if(n==1) return 1;
		int dx[] = { 0, 0, -1, 0, 1};
		int dy[] = { 0,-1, 0, 1, 0};
		int i;
		int count = 0 ;
		
		for(i=0;i<5;i++)
		{
			int x =  p.x + dx[i];
			int y = p.y + dy[i];
			if(checkValid(x,y,pad))
			{
				Pos p1 = new Pos();
				p1.x = x;
				p1.y = y;
				count += countWaysHelper(p1,pad,n-1);
			}
		}
		return count;
	}

	private static boolean checkValid(int x, int y, char[][] pad) {
		int r = pad.length;
		int c = pad[0].length;
		if(x<0 || x>=r || y<0 || y>=c || pad[x][y] == '*' || pad[x][y] == '#')
		{
			return false;
		}
		return true;
	}

	private static Pos getPos(char[][] pad, int d) {
		Pos p = new Pos();
		int i, j;
		for (i = 0; i < pad.length; i++) {
			for (j = 0; j < pad[0].length; j++) {
				if (pad[i][j] - '0' == d) {
					p.x = i;
					p.y = j;
					return p;
				}
			}
		}
		return null;
	}

}
