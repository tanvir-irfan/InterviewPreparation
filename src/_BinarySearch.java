import java.io.IOException;
import java.util.Arrays;

public class _BinarySearch {

	public static int binarySearch(int arr[], int key) {
		if(arr == null || arr.length == 0) {
			return -1;
		} 
		
		int low = 0;
		int high = arr.length - 1;
		
		while(high >= low) {
			int mid = low + (high - low) / 2;
			if(arr[mid] == key) {
				return mid;
			} else if(arr[mid] > key) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return -(low + 1);
	}
	
	public static int binarySearchLeft(int arr[], int key) {
		if(arr == null || arr.length == 0) {
			return -1;
		} 
		
		int low = 0;
		int high = arr.length - 1;
		
		while(high > low) {
			int mid = low + (high - low) / 2;
			if(arr[mid] >= key) {
				high = mid;
			} else {
				low = mid + 1;
			}
			
			if(high == low) {
				return arr[high] == key ? high : -(low + 1);
			}
		}
		
		return -(low + 1);
	}
	
	public static int binarySearchRight(int arr[], int key) {
		if(arr == null || arr.length == 0) {
			return -1;
		} 
		
		int low = 0;
		int high = arr.length - 1;
		
		while(high > low) {
			int mid = low + (int)Math.ceil( (high - low) / 2d);
			if(arr[mid] <= key) {
				low = mid;
			} else {
				high = mid - 1;
			}
			
			if(high == low) {
				return arr[high] == key ? high : (-high - 2);
			}
		}
		
		return (-low - 1);
	}

	public static void main(String args[]) throws IOException {
		int []nums = {40};
		
		int key = 40;
		
		System.out.println(_BinarySearch.binarySearch(nums, key));
	}

}
