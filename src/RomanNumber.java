import java.util.HashMap;

public class RomanNumber {

public int romanToInt(String s) {
        
        HashMap<String, Integer> cache = new HashMap<>();
        cache.put("I", 1);
        cache.put("V", 5);
        cache.put("X", 10);
        cache.put("L", 50);
        cache.put("C", 100);
        cache.put("D", 500);
        cache.put("M", 1000);
        cache.put("IV", 4);
        cache.put("IX", 9);
        cache.put("XL", 40);
        cache.put("XC", 90);
        cache.put("CD", 400);
        cache.put("CM", 900);
        
        int res = 0;
        
        String temp = "";
        int len = s.length();
        for(int i = 0; i < len; i++) {
            temp = (len - i >= 2) ? s.substring(i, i + 2) : s.charAt(i) + "";
            
            Integer value = cache.get(temp);
            if(temp.length() > 1 && value != null) {
                res += value;
                i++;
            } else {
                res += cache.get(temp.substring(0,1));
            }
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new RomanNumber().romanToInt("MIV"));
	}

}
