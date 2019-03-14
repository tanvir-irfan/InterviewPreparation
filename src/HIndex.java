import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {0,1,2,4,4,4};
		Arrays.sort(nums);
		System.out.print(new HIndex().hIndex(nums));
		
	}
	
	public int hIndex_O_N(int[] citations) {
		Arrays.sort(citations);
        
        int len = citations.length;
        
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++) {
        	int numPaperRemaining = len - i;
            if(citations[i] >=  numPaperRemaining) {
            	int tempRes = numPaperRemaining;
            	
            	res = Math.max(res, tempRes);
            }
        }
        
        return res;
    }
	
	public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(n - mid == citations[mid]) return n - mid;
            else if(n - mid < citations[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return n - left;
    }

}
