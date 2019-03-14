import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] list = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		
		double [] listOfMedian = new SlidingWindowMedian().getListOfMedians(list, k);			
		
		
//		for(int i = 0; i < listOfMedian.length; i++) {
//			System.out.println(listOfMedian[i]);
//		}
	}

	private double [] getListOfMedians(int [] list, int k) {
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		double [] res = new double [list.length - k + 1];
		for(int i = 0; i <= k - 2; i++) {
			maxHeap.add(list[i]);
		}
		
		double med = 0.0;
		for(int i = k - 1; i < list.length; i++) {
			
			maxHeap.add(list[i]);
			
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
			
			if(maxHeap.size() % 2 == 1) {
				med = maxHeap.peek();
			}
			
			if(maxHeap.peek() > list[i]) {
				maxHeap.poll();
				maxHeap.add(list[i]);
			}
		}
		
		return res;
	}
}
