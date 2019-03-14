
public class ReverseVowel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ReverseVowel().reverseVowels("leetcode"));
	}
	
	public String reverseVowels(String s) {
        char [] str = s.toCharArray();
        
        int l = 0;
        int h = str.length - 1;
        
        while (l <= h) {
            while (l <= h && !isVowel(str[l])) {
            	l++;
            }
            while (l <= h && !isVowel(str[h])) {
            	h--;
            }
            
            if(l < h) {
               swap(str, l, h); 
            }
            
            l++;
            h--;
        }
        
        return new String(str);
    }
    
	private void swap (char [] str, int l, int r) {
		str[l] ^= str[r];
        str[r] ^= str[l];
        str[l] ^= str[r];
	}
	
    private boolean isVowel(char ch) {
        return ch == 'a'
            || ch == 'A'
            || ch == 'e'
            || ch == 'E'
            || ch == 'i'
            || ch == 'I'
            || ch == 'o'
            || ch == 'O'
            || ch == 'u'
            || ch == 'U';
    }

}
