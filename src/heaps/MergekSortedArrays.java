package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

class Elem{
	
	int index;
	int pos;
	int val;
	
	public Elem(int i, int j,int val) {
		this.index = i;
		this.pos = j;
		this.val = val;
	}
	
}

public class MergekSortedArrays {

	public static void main(String[] args) {
		 int[][] arr =  {{2, 6, 12, 34},
                 {1, 9, 20, 1000},
                 {23, 34, 90, 2000}};
          int k= 3;
          int n = 4;
          mergekSorted(arr,k,n);

	}

	private static void mergekSorted(int[][] arr, int k, int n) {
		PriorityQueue<Elem> pq = new PriorityQueue<Elem>(11,new Comparator<Elem>(){

			@Override
			public int compare(Elem o1, Elem o2) {
				return o1.val - o2.val;
			}
			 
		});
		int[] res = new int[n*k];
		int i;
		for(i=0;i<k;i++){
			Elem e = new Elem(i,0,arr[i][0]);
			pq.add(e);
		}
		int j = 0;
		//added k elements
		while(!pq.isEmpty()){
			 Elem e = pq.poll();
			 int p = e.pos;
			 i = e.index;
			 res[j] =e.val;
			 j++;
			 if(p<n-1){
				//still elements are there
				 Elem e1 = new Elem(i,++p,arr[i][p]);
				 pq.add(e1);
			 }
		}
		for(i=0;i<n*k;i++){
			System.out.print(res[i] + " ");
		}
	}

}
