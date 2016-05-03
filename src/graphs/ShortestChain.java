package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 
 * @author agarg
 *  Solution to Shortest Chain problem as mentioned here
 *  http://www.geeksforgeeks.org/length-of-shortest-chain-to-reach-a-target-word/
 */
class QueueElement {
	int len;
	String word;

	public QueueElement(String word, int len) {
		// super();
		this.len = len;
		this.word = word;
	}

}

public class ShortestChain {

	public static void main(String[] args) {
		List<String> dict = new ArrayList<String>();
		dict.add("poon");
		dict.add("plee");
		dict.add("same");
		dict.add("poie");
		dict.add("plie");
		dict.add("poin");
		dict.add("plea");
		String s = "toon";
		String e = "plea";
		System.out.println("Length of shortest chain is : "
				+ shortestChainLength(s, e, dict));

	}

	/**
	 * Method to compute length of Shortest Chain
	 * 
	 * @param s
	 * @param e
	 * @return
	 */
	private static int shortestChainLength(String s, String e, List<String> dict) {
		// int res;
		Queue<QueueElement> q = new LinkedList<QueueElement>();
		q.add(new QueueElement(s, 1));
		while (!q.isEmpty()) {
			QueueElement elem = q.poll();
			if (elem.word.equalsIgnoreCase(e)) {
				return elem.len;
			}
			int l = dict.size();
			for(int i=0;i<l;i++)
			{
				String str = dict.get(i);
				if (isSimilar(str, elem.word)) {
					q.add(new QueueElement(str, elem.len + 1));
					dict.remove(i);
					l--;
				}
			}

		}
		return -1;
	}

	private static boolean isSimilar(String next, String elem) {

		int c = 0;
		for (int i = 0; i < next.length(); i++) {
			if (next.charAt(i) != elem.charAt(i)) {
				c++;
			}
		}
		return ( (c == 1) ? true : false);
	}

}
