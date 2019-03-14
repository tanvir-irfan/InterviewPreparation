import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {3,2,4,1};
		
//		int [] newA = Arrays.copyOf(nums, 2);
//		newA = Arrays.copyOfRange(nums, 2, 4);
//		newA = Arrays.copyOfRange(nums, 2, 422);
		List<Integer> res = new PancakeSort().pancakeSort(nums);
		
//		System.out.println(Arrays.toString(nums));
	}

//	public List<Integer> pancakeSort(int[] A) {
//        List<Integer> ans = new ArrayList<>();
//        int N = A.length;
//
//        Integer[] B = new Integer[N];
//        for (int i = 0; i < N; ++i)
//            B[i] = i+1;
//        Arrays.sort(B, (i, j) -> A[j-1] - A[i-1]);
//
//        for (int i: B) {
//            for (int f: ans)
//                if (i <= f)
//                    i = f+1 - i;
//            ans.add(i);
//            ans.add(N--);
//        }
//
//        return ans;
//    }
	
	public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= A.length; i++) {
        	int j = 0;
        	for(j = 0; j < A.length; j++) {
        		if(A[j] == i) break;
        	}
        	if(j == A.length  - i) continue;
        	
        	//sort(A, j);
        	Arrays.sort(A,0, j);
        	ans.add(j + 1);
        	sort(A, A.length - i);
        	ans.add(A.length - i + 1);
        }
        ans.add(A.length);
        return ans;
    }
    
    private void sort(int[] A, int k) {
    	int[] tmp = A.clone();
    	for(int i = 0; i <= k; i++) {
    		A[i] = tmp[k-i];
    	}
    	for(int i = 0; i < A.length; i++)
    		System.out.print(A[i] + " ");
    	System.out.println("");
    }
	
}
