package topcoderProblems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author agarg
 * Solution to 500 point Problem asked in DivII of SRM 687 .
 * 
 * Idea is to store indexes of all occurences of QUACK in different lists.
 * We then check if indexes of Q occur before U , U before A and so on . If its not the case the input is not valid and return -1.
 * To ascertain whether the substring is from same duck we have considered or is different can be done if K index occurs before Q.
 * So if there is any Q in the string after the Index of K that can come from the same duck instead of new one . 
 * This way one can find minimum no of ducks required .
 */
public class Quacking {
	public static int quack(String s) {
		int res = 0;
		int i = 0;
		List<Integer> QList = new LinkedList<Integer>();
		List<Integer> UList = new LinkedList<Integer>();
		List<Integer> AList = new LinkedList<Integer>();
		List<Integer> CList = new LinkedList<Integer>();
		List<Integer> KList = new LinkedList<Integer>();
		// Map<char,Integer> tm = new TreeMap<char,Integer>();//Map to Store
		// Indexes of quack in increasing order
		for (i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'q') {
				QList.add(i);
			} else if (s.charAt(i) == 'u') {
				UList.add(i);
			}
			if (s.charAt(i) == 'a') {
				AList.add(i);
			}
			if (s.charAt(i) == 'c') {
				CList.add(i);
			}
			if (s.charAt(i) == 'k') {
				KList.add(i);
			}
		}
		if (QList.size() != UList.size() || UList.size() != AList.size()
				|| AList.size() != CList.size() || CList.size() != KList.size()) {
			return -1;
		}
		// int s = QList.size();
		i = 0;
		boolean flag = false;
		while (QList.size() > 0) {
			int qIndex = QList.remove(i);
			int uIndex = UList.remove(i);
			int aIndex = AList.remove(i);
			int cIndex = CList.remove(i);
			int kIndex = KList.remove(i);
			if (qIndex < uIndex && uIndex < aIndex && aIndex < cIndex
					&& cIndex < kIndex) {
				flag = false;
				// if any i exists in qIndex after kIndex
				for (int j = 0; j < QList.size(); j++) {
					if (kIndex < QList.get(j)) {
						i = j;
						flag = true;
						break;
					}
				}
				if (!flag) {
					res++;
					i = 0;// start from beginning
				}
			} else {
				return -1;
			}
		}

		return res;
	}
}
