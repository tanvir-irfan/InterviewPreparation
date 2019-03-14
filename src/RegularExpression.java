
public class RegularExpression {

	
	public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
	
	public boolean isMatchR(String s, String p) {
        if(s == null || p == null || p.charAt(0) == '*') return false;
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }
    
    public boolean isMatch(char[] s, int sI, char[] p, int pI) {
        
        if( pI == p.length && sI < s.length ) {
            return false;
        }
        
        if (sI == s.length && pI < p.length) {
        	if( p.length - pI == 1) {
        		return false;
        	} else if(p[pI + 1] == '*') {
        		return isMatch(s, sI, p, pI + 2);
        	} else {
        		return false;
        	}
        }
        
        if( (sI == s.length && pI == p.length) || 
           (sI == s.length - 1 && pI == p.length - 1 && s[sI] == p[pI])) {
            return true;
        }
        
        if(isNextAsteric(p, pI)) {
            char cur = p[pI];
            
            if(cur == '.') {
                // current character is a '.'.
                //e.g. p = ".*"
                return isMatch(s, sI, p, pI + 2) || isMatch(s, sI + 1, p, pI + 2) || isMatch(s, sI + 1, p, pI);
            } else {
                // current character is [a-z]
                //e.g. p = "a*"
            	
            	return isMatch(s, sI, p, pI + 2) || (p[pI] == s[sI] && isMatch(s, sI + 1, p, pI + 2)) || (p[pI] == s[sI] && isMatch(s, sI + 1, p, pI));
            }
            
        } else {
            if(s[sI] == p[pI]) {
               return isMatch(s, sI + 1, p, pI + 1);
            }

            if(p[pI] == '.') {
               return isMatch(s, sI + 1, p, pI + 1);
            }
        }
        
        return false;
    }
    
    private boolean isNextAsteric(char [] p, int pI) {
        return pI < p.length - 1 && p[pI + 1] == '*' ;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaaaaaaaaaaaab";
		String p = "a*a*a*a*a*a*a*a*a*a*a*a*b";
		
		System.out.println(new RegularExpression().isMatch(s, p));
	}

}
