package ArraysPractice;

public class NearKSort {

	public static void main(String[] args) {
		 int k = 3;
		 int[] arr = {2, 6, 3, 12, 56, 8};
		 int n = arr.length;
		 sortK(arr,n,k);
	}

	private static void sortK(int[] arr, int n,int k) {
		int i= 0;
		int[] heap = new int[k+1];
		for(i=0;i<=(k-2)/2;i++){
		    createHeap(arr,i,k,heap);
		}
		int j = 0;
		int val;
		while(i<n){
			val = extractMin(arr,j,j+k);//inclusive
			System.out.println(val);
			//insertIntoHeap(arr,arr[i],k);
			i++;
			j++;
		}
	}

	private static int extractMin(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	//	createHeap(arr,i,j-1);
		return t;
	}

	private static void createHeap(int[] arr, int i, int k,int[] heap) {
	   int l = 2*i + 1;
	   int r = 2*i + 2;
	   int s = i;
	   int val = arr[s];
	   if(l<=k && arr[s] > arr[l]){
		   s = l;
	   }
	   if(r<=k && arr[s] > arr[r]){
		   s = r;
	   }
	   if(val != arr[s]){
		   int temp = arr[i];
		   arr[i] = arr[s];
		   arr[s]  = temp;
		 //  createHeap(arr,s,k);
	   }
	   
		
	}
}
