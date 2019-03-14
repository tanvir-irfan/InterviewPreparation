
public class SumOfTwoInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumOfTwoInteger s = new SumOfTwoInteger();
		
		System.out.println(s.getSum(-1, 2));
	}

	public int getSum(int a, int b) {
        char[] strA = reverseBinaryString(a).toCharArray();
        char[] strB = reverseBinaryString(b).toCharArray();
        
        int carry = 0;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 32; i++) {
        	int bitA = (int)(strA[i] - '0');
        	int bitB = (int)(strB[i] - '0');
            int sum = bitA ^ bitB ^ carry;
            carry =  ((bitA ^ bitB) & carry) | (bitA & bitB);
            sb.append(sum);
        }
            
         return Integer.parseInt(sb.reverse().toString(), 2);
    }
    
    private String reverseBinaryString(int a) {
        String str = Integer.toBinaryString(a);
        int len = str.length();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 32 - len; i++) {
            sb.append('0');
        }
        
        return sb.append(str).reverse().toString();
    }
	
}
