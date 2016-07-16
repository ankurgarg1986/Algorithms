package codeChefSnackDown;

import java.util.HashSet;
import java.util.Set;

public class SharingCandies {

	public static int sharingCandies(int a, int b, int c, int d) {
		int ans = Math.abs(a - b);
		int i = 0;
		int j = 0;
		int X;// = a + c*i;
		int Y;// = b + d*i;
		Set<Integer> diff = new HashSet<Integer>();
		while (true) {
			X = a + c * i;
			Y = b + d * j;
			ans = Math.min(ans, Math.abs(X - Y));
			if (diff.contains(Math.abs(X - Y))) {
				break;
			}
			if (X < Y) {
				i++;
				// X = a+ c*i;
				diff.add(Y - X);
			} else {
				j++;
				diff.add(X - Y);
				// Y = b + d*i;
			}

		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = sharingCandies(1,2,2,3);
       System.out.println(ans);
	}

}
