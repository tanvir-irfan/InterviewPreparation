import java.util.ArrayList;
import java.util.List;

public class RainWater {

	private static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] h = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
//		System.out.println(new RainWater().trap(h));
//		int [] arr = {1,2,3,4};
//		List<int[]> res = new ArrayList<>();
//		new RainWater().permutation(arr, 0, arr.length - 1, res);
//		
//		System.out.println(count);
		
		RainWater rw = new RainWater();
		
		System.out.println(rw.intToRoman(3999));
	}

	public String intToRoman(int num) {
        int values[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String str[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length; i++) {
            while(num >= values[i]) {
                num -= values[i];
                sb.append(str[i]);
            }
        }
        
        return sb.toString();
    }
	
	public int trap(int[] height) {
        if(height.length < 3) return 0;
        
        int [] maxleft = new int [height.length];        
        
        maxleft[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            if(height[i] > maxleft[i-1]) {
                maxleft[i] = height[i];
            } else {
                maxleft[i] = maxleft[i-1];
            }
        }
        
        int [] maxright = new int [height.length];
        maxright[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--) {
            if(height[i] > maxright[i+1]) {
                maxright[i] = height[i];
            } else {
                maxright[i] = maxright[i+1];
            }
        }
        
        int res = 0;
        for(int i = 1; i < height.length - 1; i++) {
            int temp = Math.min (maxleft[i], maxright[i]);
            
            if(temp > height[i]) res += temp - height[i];
        }
        return  res;
    }
	
	public void permutation(int [] arr, int start, int end, List<int[]> res) {
		count++;
		if(start == end) {			
			res.add(arr.clone());
			return;
		}
		
		for(int i = start; i <= end; i++) {
			swap(arr, i, start);
			permutation(arr, start + 1, end, res);
			swap(arr, i, start);
		}
	}
	
	private void swap(int[] arr, int x, int y) {
		if(x == y) {
			return;
		}
		
		arr[x] ^= arr[y];
		arr[y] ^= arr[x];
		arr[x] ^= arr[y];
	}

}
