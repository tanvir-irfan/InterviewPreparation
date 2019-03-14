import java.util.List;
import java.util.ArrayList;

public class _MedianOfTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1 = {0, 23};
		int [] arr2 = {};
		
		_MedianOfTwoSortedArray md = new _MedianOfTwoSortedArray();
		
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		
		for(Integer i : arr1) {
			a.add(i);
		}
		
		for(Integer i : arr2) {
			b.add(i);
		}
		
		double  res = md.findMedianSortedArrays(a, b);
		
		System.out.println(res);
	}

	// DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
        
        if((A == null || A.size() == 0) && (B == null || B.size() == 0)) {
            return 0.0;
        }
        
        int i1S = A.size();
        int i2S = B.size();
        
//        System.out.println(i1S);
//        System.out.println(i2S);
        
        int totalSize = i1S + i2S;
        
        if(totalSize % 2 == 0) {
            return (findKth(A, 0, B, 0, totalSize / 2) +  findKth(A, 0, B, 0, (totalSize + 2) / 2)) / 2.;
        } else {
            return (findKth(A, 0, B, 0, (totalSize + 2) / 2));
        }
    }
    
    public int findKth(final List<Integer> A, int startA, final List<Integer> B, int startB, int k) { 
        
        if((A == null || A.size() == 0) && (B == null || B.size() == 0)) {
            return 0;
        } else if(A == null || A.size() == 0 && (B != null || B.size() != 0)) {
            return B.get(k - 1);
        } else if(B == null || B.size() == 0  && (A != null || A.size() != 0)){
            return A.get(k - 1);
        }
        
        if (startA >= A.size()) { 
            return B.get(startB + k - 1); 
        } 
         
        if (startB >= B.size()) { 
            return A.get(startA + k - 1); 
        } 
         
        if (k == 1) { 
            return Math.min(A.get(startA), B.get(startB)); 
        } 
         
        int indexA = startA + k / 2 - 1; 
        int indexB = startB + k / 2 - 1; 
        int keyA = indexA < A.size() ? A.get(indexA) : Integer.MAX_VALUE; 
        int keyB = indexB < B.size() ? B.get(indexB) : Integer.MAX_VALUE; 
         
        if (keyA < keyB) { 
            return findKth(A, startA + k / 2, B, startB, k - k / 2); 
        } else { 
            return findKth(A, startA, B, startB + k / 2, k - k / 2); 
        } 
    }
	
//	public double findMedianSortedArrays(int[] input1, int[] input2) {
//        int x = input1.length;
//        int y = input2.length;
//        
//        if(x > y) {
//        	// this ensures the first array is either smaller or at least equal in size.
//            return findMedianSortedArrays(input2, input1);
//        }
//        
//        int low = 0;
//        int high = x;
//        while (low <= high) {
//            int partitionX = (low + high)/2;
//            int partitionY = (x + y + 1)/2 - partitionX;
//
//            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
//            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
//            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
//            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];
//
//            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
//            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];
//
//            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
//                //We have partitioned array at correct place
//                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
//                // or get max of left for odd length combined array size.
//                if ((x + y) % 2 == 0) {
//                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
//                } else {
//                    return (double)Math.max(maxLeftX, maxLeftY);
//                }
//            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
//                high = partitionX - 1;
//            } else { //we are too far on left side for partitionX. Go on right side.
//                low = partitionX + 1;
//            }
//        }
//
//        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
//        throw new IllegalArgumentException();
//    }
}
