
import java.util.List;
import java.util.ArrayList;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {186, 192, 193, 202, 204, 2, 3, 6, 10, 11, 12, 17, 21, 28, 29, 30, 31, 32, 37, 38, 39, 40, 41, 47, 49, 50, 51, 52, 55, 57, 58, 59, 60, 65, 67, 68, 71, 72, 74, 77, 78, 80, 82, 83, 88, 89, 90, 94, 100, 107, 108, 109, 111, 112, 114, 115, 116, 118, 119, 121, 123, 124, 126, 129, 133, 134, 135, 137, 138, 144, 147, 148, 150, 151, 154, 156, 159, 161, 163, 165, 166, 167, 168, 169, 174, 178, 180, 182, 183, 185};
		
		int b = 143;
		List<Integer> a = new ArrayList<>();
		for(int c : arr) {
			a.add(c);
		}
		
		int index = new SearchInRotatedArray().search(a, b);
		
		System.out.println(index);
	}

	public int search(final List<Integer> a, int b) {

		if (a == null || a.size() == 0) {
			return -1;
		}

		int size = a.size();

		int low = 0;
		int high = size - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			int aLow = a.get(low);
			int aMid = a.get(mid);
			int aHigh = a.get(high);

			if (aMid == b) {
				return mid;
			} else if (aMid < aHigh) {
				if (b > aMid && b <= aHigh) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else if (aMid > aLow) {
				if (b >= aLow && b < aMid) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			
			if(low == high) {
				return a.get(low) == b ? low : -1;
			}
		}

		return -1;
	}

}
