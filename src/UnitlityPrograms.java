import java.util.ArrayList;
import java.util.List;

public class UnitlityPrograms {
	public static void main(String []s) {
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		while(n != 0) {
//			System.out.println (isEven(n));
//			n = sc.nextInt();
//		}
		
//		for(int i = 2; i<= n; i++) {
//			if(isPrime(i)) {
//				System.out.println(i);
//			}
//		}
		//int [] nums = {5,7,7,7,8,8,10};
		//System.out.println(UnitlityPrograms.searchRange(nums, 8));
		
		int [] nums = {1, 2, 3, 14};
		List<List<Integer>> result = subsets(nums);
		System.out.println(result);
		
		changeNums(nums);
		result = subsets(nums);
		System.out.println(result);
	}
	
	private static void changeNums(int[] nums) {
		nums[0] = 10;
	}
	
	public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(S, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public static void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<Integer>(path));

        for(int i = index; i < s.length; i++){
            path.add(s[i]);
            dfs(s, i+1, path, result);
            path.remove(path.size()-1);
        }
    }
	
	public static boolean isEven(int n) {
		return (n&1) == 0;
	}
	
	public static boolean isPrime(int n) {
        switch(n) {
            case 1: return false;
            case 2: 
            case 3:
            return true;
        }
        int sq = ((int)Math.sqrt(n)) + 1;
        boolean res = true;
        for(int i = 2; i <= sq; i++) {
            if( n % i == 0) {
                res = false;
                break;
            }
        }
        
        return res;
    }
		
}
