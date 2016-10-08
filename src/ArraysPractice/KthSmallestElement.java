package ArraysPractice;

public class KthSmallestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthSmallestElement ob = new KthSmallestElement();
		int arr[] = { 12, 3, 5, 7, 4, 19, 26 };
		int n = arr.length, k = 7;
		System.out.println("K'th smallest element is "
				+ ob.kthSmallest(arr, n-1, 0, k));
	}

	private int kthSmallest(int[] arr, int r, int l, int k) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int p = randomPartition(arr,n,r,l);
		if(p-l==k-1) return arr[p];
		if(p-l>k-1){
			return kthSmallest(arr,p-1,l,k); 
		}else{
			return kthSmallest(arr,r,p+1,k-p+l-1);
		}
	}

	private int randomPartition(int[] arr, int n,int r, int l) {
		int mid = (r-l+1)/2;
		swap(arr,l+mid,r);
		int x = arr[r];
		int i=l;int j=l;
		while(j<r){
			if(arr[j]<=x){
				swap(arr,i,j);
				i++;
			}
			j++;
		}
		swap(arr,i,r);
		return i;
	}

	private void swap(int[] arr, int x, int y) {
	    int temp = arr[x];
	    arr[x] = arr[y];
	    arr[y] = temp;
	    return;
	}

}
