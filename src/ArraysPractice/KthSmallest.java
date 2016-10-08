package ArraysPractice;

import java.util.Deque;
import java.util.LinkedList;

//Java program to find k'th smallest element in expected
//linear time
public class KthSmallest
{
 // This function returns k'th smallest element in arr[l..r]
 // using QuickSort based method.  ASSUMPTION: ALL ELEMENTS
 // IN ARR[] ARE DISTINCT
 int kthSmallest(int arr[], int l, int r, int k)
 {
     // If k is smaller than number of elements in array
     if (k > 0 && k <= r - l + 1)
     {
         // Partition the array around a random element and
         // get position of pivot element in sorted array
         int pos = randomPartition(arr, l, r);

         // If position is same as k
         if (pos-l == k-1)
             return arr[pos];

         // If position is more, recur for left subarray
         if (pos-l > k-1)
             return kthSmallest(arr, l, pos-1, k);

         // Else recur for right subarray
         return kthSmallest(arr, pos+1, r, k-pos+l-1);
     }

     // If k is more than number of elements in array
     return Integer.MAX_VALUE;
 }

 // Utility method to swap arr[i] and arr[j]
 void swap(int arr[], int i, int j)
 {
     int temp = arr[i];
     arr[i] = arr[j];
     arr[j] = temp;
 }

 // Standard partition process of QuickSort().  It considers
 // the last element as pivot and moves all smaller element 
 // to left of it and greater elements to right. This function
 // is used by randomPartition()
 int partition(int arr[], int l, int r)
 {
     int x = arr[r], i = l;
     for (int j = l; j <= r - 1; j++)
     {
         if (arr[j] <= x)
         {
             swap(arr, i, j);
             i++;
         }
     }
     swap(arr, i, r);
     return i;
 }

 // Picks a random pivot element between l and r and 
 // partitions arr[l..r] arount the randomly picked 
 // element using partition()
 int randomPartition(int arr[], int l, int r)
 {
     int n = r-l+1;
     int pivot = (int)(Math.random()) % n;
     swap(arr, l + pivot, r);
     return partition(arr, l, r);
 }
 
 
 // Driver method to test above
 public static void main(String args[])
 {
   
     KthSmallest ob = new KthSmallest();
    // int arr[] = {12, 3, 5, 7, 4, 19, 26};
     int[] arr = {7,2,4};
     int k = 2;
     Deque<Integer> q = new LinkedList<Integer>();
     int i = 0;
     int n = arr.length;
     int[] ans = new int[n-k+1];
//     if( n==0) {
//          int[] ans1 = new int[0];
//          return ans1;
//     }
     for(i=0;i< k;i++){
          while(!q.isEmpty() && arr[i] >= arr[q.peekLast()]){
               q.pollLast();
          }
        q.addLast(i);
     }
     for(i=k;i<arr.length;i++){
       ans[i-k] = arr[q.peekFirst()];
       while(!q.isEmpty() && i-k >= q.peekFirst()){
           q.pollFirst();
       }
       while(!q.isEmpty() && arr[i] >= arr[q.peekLast()]){
           q.pollLast();
       }
       q.addLast(i);
     }
     if(!q.isEmpty()) ans[n-k] = arr[q.peekFirst()];
     for( i=0;i<ans.length;i++)
        System.out.println(ans[i]);
     
     int k1 = 3;
     System.out.println("K'th smallest element is "+
                        ob.kthSmallest(arr, 0, n-1, k1));
 }
}
