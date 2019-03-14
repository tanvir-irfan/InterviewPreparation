
public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A man, a plan, a canal: Panama";
		System.out.println(new Palindrome().isPalindrome(s));
	}
	
	public boolean isPalindrome(String s) {
        int wI = 0;
        s = s.toLowerCase();
        
        char[] str = s.toCharArray();
        
        for(int i = 0; i < str.length; i++) {
            if( (str[i] >= 'a' && str[i] <= 'z') || (str[i] >= '0' && str[i] <= '9')) {
                str[wI++] = str[i];
            }
        }
        
        for(int i = 0; i < wI; i++) {
            if(str[i] != str[wI - 1 - i]) {
                return false;
            }
        }
        
        return true;
    }
}
