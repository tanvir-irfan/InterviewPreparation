import java.util.LinkedList;

public class _WorkingDaysWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,1,1,1,1,1,1,1};
		int k = 0;
		
		System.out.println(new _WorkingDaysWindow().maxSubarrayAtMostKWorkingDays(nums, k));
		
		System.out.println(new _WorkingDaysWindow().maxSubarrayAtMostWorkingDaysMine(nums, k));
	}

	
	public int maxSubarrayAtMostKWorkingDays(int[] arr, int k) {
	    int maxLen = 0;
	    for (int lo = 0, hi = 0, workingDays = 0; hi < arr.length; hi++) {
	        workingDays += arr[hi];
	        for (; workingDays > k; lo++) {
	            workingDays -= arr[lo];
	        }
	        maxLen = Math.max(maxLen, hi - lo + 1);
	    }
	    return maxLen;
	}
	
	public int maxSubarrayAtMostWorkingDaysMine(int [] arr, int k) {
		int maxLen = 0;
		
		int low = 0;
		int workDays = 0;
		
		LinkedList<Integer> q = new LinkedList<>();
		
		for(int high = 0; high < arr.length; high++) {
			workDays += arr[high];
			
			if(arr[high] == 1) {
				q.addFirst(high);
			}
			
			if(workDays > k) {
				low = q.removeLast() + 1;
				workDays--;
				maxLen = Math.max(maxLen, high - low );
			} else {
				maxLen = Math.max(maxLen, high - low + 1);
			}
			
		}
		
		return maxLen;
	}
}
