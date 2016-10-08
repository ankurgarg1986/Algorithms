package queues;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Interval{
	
	int sTime;
	int eTime;
	
	public Interval(int i, int j) {
		// TODO Auto-generated constructor stub
		this.sTime = i;
		this.eTime = j;
	}
}
public class MinMeetingRooms {

	
	private static int minMeetingRooms(Interval[] intervals) {
		 if(intervals==null||intervals.length==0)
		        return 0;
		 
		    Arrays.sort(intervals, new Comparator<Interval>(){
		        public int compare(Interval i1, Interval i2){
		            return i1.sTime-i2.sTime;
		        }
		    });
		 
		    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		    int count=1;
		    queue.offer(intervals[0].eTime);
		 
		    for(int i=1; i<intervals.length; i++){
		        if(intervals[i].sTime<queue.peek()){
		            count++;
		 
		        }else{
		            queue.poll();
		        }
		 
		        queue.offer(intervals[i].eTime);
		    }
		 
		    return count;
	}
	
	public static void main(String[] args) {
		Interval[] inte = new Interval[6];
		inte[0] = new Interval(0,8);
		inte[1] = new Interval(14,18);
		inte[2] = new Interval(3,5);
		inte[3] = new Interval(2,7);
		inte[4] = new Interval(5,9);
		inte[5] = new Interval(10,17);
		System.out.println(minMeetingRooms(inte));
		System.out.println(minMeetingRoomsQueue(inte));
		

	}

	private static int minMeetingRoomsQueue(Interval[] inte) {
		int c = 0;
		Arrays.sort(inte,new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.eTime - o2.eTime;
			}
			
		});
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(inte[0].eTime);
		c++;
		for(int i=1;i<inte.length;i++){
			if(inte[i].sTime < q.peek()){
				c++;
			}else{
				q.poll();
			}
			q.add(inte[i].eTime);
		}
		return c;
	}

	

}
