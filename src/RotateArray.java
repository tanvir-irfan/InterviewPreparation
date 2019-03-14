
public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {1,2,3,4,5,6,7};
		//RotateArray.rotate(arr, 4);
		
		RotateArray.moveZeroes(arr);
		
		System.out.println(arr);
	}
	
	public static void moveZeroes(int[] nums) {        
        int leftI = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[leftI] = nums[i];
                if(leftI != i) nums[i] = 0;
                leftI++;
            }
        }
    }
	
	public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        
        if(k == 0) return;
        
        int left = 0;
        int right = k;
        int firstRight = k;
        int temp = nums[right];
        int count = 1;
        while(count < len) {
            temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right++;
            if(left >= firstRight) {
            	left = 0;
            }
            if(right >= len) {
                right = 0;
            }
            count++;
        }
    }
}
