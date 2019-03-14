

import java.util.Comparator;
import java.util.PriorityQueue;

public class _RunningMedian {

	private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
	private static PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
		@Override
		public int compare(Integer a, Integer b) {		
			return -1 * a.compareTo(b);
		}
	});

	public static void main(String args[] ) throws Exception {

		int [] list = {1,2,3};
		
		double [] listOfMedian = getListOfMedians(list);			

		for(int i = 0; i < listOfMedian.length; i++) {
			System.out.println(listOfMedian[i]);
		}
	}

	public static double [] getListOfMedians(int [] list) {
		double [] listOfMedian = new double[list.length];	
		for(int i = 0; i < list.length; i++) {
			addNumberToHeap(list[i]);
			adjustHeapSize();
			listOfMedian[i] = getMedian();
		}

		return listOfMedian;
	}

	private static void addNumberToHeap(int num) {
		if(minHeap.size() == 0 || minHeap.peek() >= num) {
			minHeap.add(num);
		} else {
			maxHeap.add(num);
		}
	}

	private static void adjustHeapSize() {			
		PriorityQueue<Integer> bigH = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
		PriorityQueue<Integer> smallH = minHeap.size() < maxHeap.size() ? minHeap : maxHeap;

		if( (bigH.size() - smallH.size() >=2)) {
			smallH.add(bigH.poll());
		}
	}
	
	private static double getMedian() {
		PriorityQueue<Integer> bigH = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
		PriorityQueue<Integer> smallH = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;
		double median;
		if(bigH.size() != smallH.size()) {
			median = bigH.peek();
		} else {
			median=  ( smallH.peek() + bigH.peek() ) / 2.0;
		}
		
		return median;
	}
}
