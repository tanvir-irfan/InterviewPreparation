
public class TestConcepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestConcepts t = new TestConcepts();
			
		int [] nums = {2,0,2,1,1,0};
		
		t.sortColors(nums);
	}

	public void sortColorsOnePass(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        
        while(mid <= high) {
        	switch(nums[mid]) {
        	case 0:
        		swap(nums, low, mid);
        		low++;
        		mid++;
        		break;
        	case 1:
        		mid++;
        		break;
        	case 2:
        		swap(nums, mid, high);
        		high--;
        		break;
        	}
        }
        
        return;
    }
	
	private void swap(int[] nums, int i, int j) {
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}
	
	public void sortColors(int[] nums) {
        int [] freq = new int[3];
        
        for(int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(i < nums[0]) {
            	freq[i] = 0;
            } else if(i < nums[0] + nums[1]) {
            	freq[i] = 1;
            } else {
            	freq[i] = 2;
            }
        }
        
        return;
    }
	
}
