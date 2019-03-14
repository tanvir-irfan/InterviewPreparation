import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

	public static void main(String[] args) {
		int [] list = {1,2,3};
		
		MedianFinder mf = new MedianFinder();
		
		mf.addNum(1);
		System.out.println(mf.findMedian());
		mf.addNum(2);
		System.out.println(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
		
	}

	
	private PriorityQueue<Integer> leftMaxQ, rightMinQ;
    /** initialize your data structure here. */
    public MedianFinder() {
        leftMaxQ = new PriorityQueue<>(Collections.reverseOrder());
        rightMinQ = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftMaxQ.size() == 0 || leftMaxQ.peek() >= num) {
        	leftMaxQ.add(num);
        } else {
        	rightMinQ.add(num);
        }
        
        adjustSize();
    }
    
    private void adjustSize() {
        PriorityQueue<Integer> bQ = rightMinQ.size() > leftMaxQ.size() ? rightMinQ : leftMaxQ;
        PriorityQueue<Integer> sQ = rightMinQ.size() < leftMaxQ.size() ? rightMinQ : leftMaxQ;
        
        if(bQ.size() - sQ.size() >= 2) {
            sQ.add(bQ.poll());
        }
    }
    
    public double findMedian() {
        PriorityQueue<Integer> bQ = rightMinQ.size() > leftMaxQ.size() ? rightMinQ : leftMaxQ;
        PriorityQueue<Integer> sQ = rightMinQ.size() > leftMaxQ.size() ? leftMaxQ : rightMinQ;
        
        if(bQ.size() != sQ.size()) {
            return bQ.peek();
        } else {
            return (bQ.peek() + sQ.peek()) / 2.0;
        }
    }
}
