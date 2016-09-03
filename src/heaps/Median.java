package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 5, 15, 1, 3, 2, 8, 7,10 };
		int len = a.length;

		// In lieu of A, we can also use data read from a stream
		System.out.println(printMedian(a, len));

	}

	private static int printMedian(int[] a, int n) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,
				new Comparator<Integer>() {
					@Override
					public int compare(Integer a, Integer b) {
						// TODO Auto-generated method stub
						return b - a;
					}
				});
		int median = 0;
		if (n == 1)
			return median;
		if (a[0] < a[1]) {
			minHeap.add(a[1]);
			maxHeap.add(a[0]);
		} else {
			minHeap.add(a[0]);
			maxHeap.add(a[1]);
		}
		int minHeapSize = 1;
		int maxHeapSize = 1;
		median = (a[0] + a[1]) / 2;
		for (int i = 2; i < n; i++) {
			if (minHeapSize == maxHeapSize) {
				if (median > a[i]) {
					maxHeap.add(a[i]);
					maxHeapSize++;
				} else {
					minHeap.add(a[i]);
					minHeapSize++;
				}
			}else if(minHeapSize > maxHeapSize){
				//minHeap is more
				if(median < a[i]){
					int elem = minHeap.poll();
					maxHeap.add(elem);
					maxHeapSize++;
					minHeap.add(a[i]);
				}else{
					maxHeap.add(a[i]);
					maxHeapSize++;
				}
			}else{
				//maxHeap is more
				if(median > a[i]){
					int elem = maxHeap.poll();
					minHeap.add(elem);
					minHeapSize++;
					maxHeap.add(a[i]);
				}else{
					minHeap.add(a[i]);
					minHeapSize++;
				}
			}
			if(minHeapSize == maxHeapSize){
				median = (minHeap.peek() + maxHeap.peek())/2;
			}else{
				if(minHeapSize > maxHeapSize){
					median = minHeap.peek();
				}else{
					median = maxHeap.peek();
				}
			}
		}
		return median;
	}

}
