
public class QuickPartition {

	public static void main(String[] args) {
		int [] arr = {4,2,6,8,5,7,10,1};
		
		QuickPartition qp = new QuickPartition();
		
		int res = qp.quickPartition(arr, 3);
		System.out.println(res);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public int quickPartition(int [] arr, int pivot) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) {
			while(left <= right && arr[left] <= pivot) {
				left++;
			}
			
			while(left < right && arr[right] > pivot) {
				right--;
			}
			
			if(left >= right) {
				break;
			}
			
			swap(arr, left, right);
			left++;
			right--;
		}
		
		return left;
	}
	
	private void swap(int [] arr, int left, int right) {
		if(left >= right) {
			return;
		}
		
		arr[left] ^= arr[right];
		arr[right] ^= arr[left];
		arr[left] ^= arr[right];
	}
}
