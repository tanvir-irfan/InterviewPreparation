// https://leetcode.com/problems/3sum/description/

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class _ThreeSum {

	public static void main(String[] args) {
		int[] nums = {0,1,-2};

		List<List<Integer>> res = new _ThreeSum().threeSum(nums);

		for (int i = 0; i < res.size(); i++) {
			List<Integer> triplet = res.get(i);

			int count = 0;
			System.out.print("[ ");
			for (Integer n : triplet) {
				count++;
				System.out.print(n + "" + (count < triplet.size() ? "\t" : ""));
			}
			System.out.println(" ]");
		}
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null || nums.length < 3) {
            return res;
        }
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            int comp = -1 * nums[i];
            
            int j = i + 1;
            int k = nums.length - 1;
            
            if(nums[j] > comp) {
                continue;
            }
            
            while(j < nums.length - 1 && k > j) {
                if( nums [j] + nums[k] == comp) {
                    Integer [] arr = {nums[i], nums[j], nums[k]};
                    res.add(Arrays.asList(arr));
                    j++;
                    k--;
                }
                
                if(nums [j] + nums[k] > comp) {
                    k--;
                }
                if(nums [j] + nums[k] < comp) {
                    j++;
                }
            }
            
            while(i + 1 < nums.length - 2 && nums[i] == nums [i + 1]) {
            	i++;
            }
        }
        
        return res;
	}

	static int[] getArrayInput() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		int[] nums = new int[count];

		for (int i = 0; i < count; i++) {
			nums[i] = sc.nextInt();
		}
		sc.close();
		return nums;

	}
}
