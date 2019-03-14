
public class RemoveDuplicate2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,1,1,2,2,3,3};
		
		System.out.println(new RemoveDuplicate2().removeDuplicates(nums));
	}
	
	public int removeDuplicates(int[] nums) {
        if(nums == null) {
            return 0;
        }
        if(nums.length <= 2) {
            return 2;
        }
        
        int curN = nums[0];
        int count = 1;
        int wI = 1;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == curN) {
                count++;
                if(count > 2) {
                    while(nums[i] == curN) {
                        i++;
                    }
                    
                    count = 1;
                    curN = nums[i];
                    nums[wI++] = curN;
                } else {
                    nums[wI++] = nums [i];
                }
            } else {
            	count = 1;
                curN = nums[i];
                nums[wI++] = curN;
            }
        }
        
        return wI;
    }

}
