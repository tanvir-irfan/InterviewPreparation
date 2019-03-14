
public class _IncreasingTriplet {

	public static void main(String[] args) {
		int [] nums = {5,1,5,5,2,5,4};
		
		System.out.println(new _IncreasingTriplet().increasingTriplet(nums));
	}

	
	public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }
        
        int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE, z = Integer.MIN_VALUE, temp = Integer.MIN_VALUE;
        
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            if(x == Integer.MIN_VALUE) {
                x = nums[i];
            } else if(y == Integer.MIN_VALUE) {
                if(nums[i] > x) {
                    y = nums[i];
                } else {
                    x = nums[i];
                }
            } else if(z == Integer.MIN_VALUE) {
                if(nums[i] > y) {
                    // we have an answer
                    return true;
                } else {
                    // we have two cases here.
                    // 1. temp variable is not set
                    //      - save anything that is < y. 
                    //      - why?
                    //          - current nums[i] > y 
                    //              - then we have our solution. check the if case couple of lines above.
                    //          - current nums[i] == y
                    //              - same value is stored in y. :-)
                    //          - temp = nums[i]. for future.
                    // 2. temp veriable is set
                    //      - we again have two cases
                    //      a) nims[i] > temp
                    //          - we have two cases
                    //          i) temp is > x
                    //              - we have our answer. :-)
                    //          ii) temp is <= x
                    //              - update x, x = temp
                    //              - update y, y = nums[i]
                    //              - update temp, temp = Integer.MIN_VALUE
                    //      b) nums[i] <= temp
                    //          - update temp with this new value
                	
                	if(temp == Integer.MIN_VALUE) {
                		if(nums[i] < y) {
                			temp = nums[i];
                		}
                	} else {
                		if(nums[i] > temp) {
                			if(temp > x) {
                				return true;
                			} else {
                				// temp <= x
                				x = temp;
                				y = nums[i];
                				temp = Integer.MIN_VALUE;
                			}
                		} else {
                			temp = nums[i];
                		}
                	}
                	
                }
            }
        }
        
        return false;
    }
}
