import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PowerfulInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = new PowerfulInteger().powerfulIntegers(3,5,15);
	}
	
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
        ArrayList<Integer> pX = getPower(x, bound);
        ArrayList<Integer> pY = getPower(y, bound);
        
        
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for( int a : pX) {
            for(int b : pY) {
                long tempRes = (a+b);
                if(tempRes <= bound) {
                    if(set.add((int)tempRes)) {
                    	res.add((int)tempRes);
                    }
                }
            }
        }
        
        return res;
    }
    
    
    private ArrayList<Integer> getPower(int x, int bound) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        if(x < 2) {
            return res;
        }
        
        int tRes = x;
        while(tRes <= bound) {
            res.add(tRes);
            tRes *= x;
        }
        
        return res;
    }

}
