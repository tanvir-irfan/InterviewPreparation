import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval _1 = new Interval(1, 2);
		Interval _2 = new Interval(3, 6);
		Interval _3 = new Interval(10, 8);

		ArrayList<Interval> intervals = new ArrayList<>();

		intervals.add(_1);
		intervals.add(_2);
		
		_MergeIntervals m = new _MergeIntervals();
		
		ArrayList<Interval> res = m.insert(intervals, _3);
		
		System.out.println("Hello");
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		if (newInterval.start > newInterval.end) {
			Interval i = new Interval(newInterval.end, newInterval.start);
			intervals.add(i);
		} else {
			intervals.add(newInterval);
		}

		return merge(intervals);
	}

	public ArrayList<Interval> merge(List<Interval> intervals) {
		PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.size(), new IntervalComparator());
		ArrayList<Interval> res = new ArrayList<>();

		for (Interval i : intervals) {
			pq.add(i);
		}

		int curS = Integer.MIN_VALUE, curE = Integer.MIN_VALUE;

		while (!pq.isEmpty()) {
			Interval it = pq.poll();
			if (curS == Integer.MIN_VALUE) {
				curS = it.start;
				curE = it.end;
			} else {
				if (it.start > curE) {
					res.add(new Interval(curS, curE));
					curS = it.start;
					curE = it.end;
				} else {
					curE = it.end;
				}
			}
		}

		res.add(new Interval(curS, curE));
		
		return res;
	}

	static class IntervalComparator implements Comparator<Interval> {
		public int compare(Interval a, Interval b) {
			return a.start - b.start;
		}
	}

	static class Interval {
		int start;
		int end;

		Interval() {
			this(0, 0);
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
		
		public String toString() {
			return "[" + start + ", " + end + "]";
		}
	}

}
