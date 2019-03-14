// https://leetcode.com/problems/2-keys-keyboard/description/

// Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

// Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
// Paste: You can paste the characters which are copied last time.

// Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. 
// Output the minimum number of steps to get n 'A'.

public class _TwoKeyKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_TwoKeyKeyboard t = new _TwoKeyKeyboard();
		
		System.out.println(t.minSteps(99));
	}
	
	public int minSteps(int n) {
        if(n == 0 || n == 1) {
            return 0;
        } else if(n <= 5) {
            return n;
        }
        
        int less = find (n);
        
        int res = 0;
        if( less == 1) {
            // less == 1 means the number is prime
            res = n;
        } else {
            res = (n / less) + minSteps(less);
        }
        
        return res;
        
    }
    
    private int find(int n) {
        int res = 1;
        for(int i = 2; i <= n/2; i++) {
            if(n % i == 0) {
                res = i;
            }
        }
        
        return res;
    }

}
