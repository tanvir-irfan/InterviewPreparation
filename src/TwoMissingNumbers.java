
public class TwoMissingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int[]{9,6,3,5,1,4,2};
		
		TwoMissingNumbers mn = new TwoMissingNumbers();
		
		int [] res = mn.twoMissing(nums);
		System.out.println(res.length);
	}

	// Determine the two numbers missing from an array. Returns an array of 
	// length 2
	public static int[] twoMissing(int[] arr) {
	    int size = arr.length + 2;
	       
	    // 1 + 2 + ... + N-1 + N = N * (N + 1) / 2
	    long totalSum = size * (size + 1) / 2;
	       
	    // Sum up the input array
	    long arrSum = 0;
	    for (int i : arr) arrSum += i;
	        
	    // totalSum - arrSum = the sum of the two results. Therefore we know 
	    // that since our two results are not equal, one result is
	    // > (sum of two results) / 2 and the other is 
	    // < (sum of two results) / 2
	    int pivot = (int) ((totalSum - arrSum) / 2);
	       
	    // Use the same technique as oneMissing() on each half of the array.
	    int totalLeftXor = 0;
	    int arrLeftXor = 0;
	    int totalRightXor = 0;
	    int arrRightXor = 0;
	        
	    for (int i = 1; i <= pivot; i++) totalLeftXor ^= i;
	    for (int i = pivot + 1; i <= size; i++) totalRightXor ^= i;
	    for (int i : arr) {
	        if (i <= pivot) arrLeftXor ^= i;
	        else arrRightXor ^= i;
	    }
	        
	    return new int[]{totalLeftXor ^ arrLeftXor, totalRightXor ^ arrRightXor};
	}
}
