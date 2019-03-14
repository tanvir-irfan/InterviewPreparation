
public class _KthElementOfTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] A = {1,3,5,7,9};
		int [] B = {2,4,6,8};

		_KthElementOfTwoSortedArray k = new _KthElementOfTwoSortedArray();
		
		int kth = k.findKth(A, 0, B, 0, 0);
		
		System.out.print(kth);
	}

	public int findKth(int[] A, int startA, int[] B, int startB, int k) {
		
		if(k <= 0 || k >= A.length + B.length) {
			throw new IllegalArgumentException();
		}
		
        if (startA >= A.length) { 
            return B[startB + k - 1]; 
        } 
         
        if (startB >= B.length) { 
            return A[startA + k - 1]; 
        } 
         
        if (k == 1) { 
            return Math.min(A[startA], B[startB]); 
        } 
         
        int indexA = startA + k / 2; 
        int indexB = startB + k / 2; 
        int keyA = indexA < A.length ? A[indexA] : Integer.MAX_VALUE; 
        int keyB = indexB < B.length ? B[indexB] : Integer.MAX_VALUE; 
         
        if (keyA < keyB) { 
            return findKth(A, startA + k / 2, B, startB, k - k / 2); 
        } else { 
            return findKth(A, startA, B, startB + k / 2, k - k / 2); 
        } 
    } 
}
