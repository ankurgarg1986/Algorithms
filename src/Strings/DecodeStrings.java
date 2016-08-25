package Strings;

import java.util.Stack;

public class DecodeStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I";
		String ans = ansdecode(s);
		System.out.println(ans);

	}

	private static String ansdecode(String s) {

		String ans = "";
		Stack<Integer> st = new Stack<Integer>();
		int len = s.length();
		int i = 0;
		int n = 1;
		while (i < len) {
			if (s.charAt(i) == 'I') {
				ans = ans + String.valueOf(n);
				while (!st.isEmpty()) {
					int v = st.pop();
					ans += String.valueOf(v);
				}
				n++;
				i++;
			} else if (s.charAt(i) == 'D') {
				st.push(n);
				n++;
				i++;
			}

		}
		ans += String.valueOf(n);
		while (!st.isEmpty()) {
			int v1 = st.pop();
			ans += String.valueOf(v1);
		}
		return ans;
	}

}
