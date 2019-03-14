import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		GroupAnagrams ga = new GroupAnagrams();
		
		System.out.println(ga.generateHash("bob"));
		System.out.println(ga.generateHash("boo"));
	}

	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        
        if(strs == null || strs.length == 0) {
            return res;
        }
        
        HashMap<String, ArrayList<String>> memory = new HashMap<>();
        
        
        for(int i = 0; i < strs.length; i++) {
            String hash = generateHash(strs[i]);
            ArrayList<String> temp;
            
            if(memory.containsKey(hash)) {
                temp = memory.get(hash);
            } else {
                temp = new ArrayList<>();
            }
            
            temp.add(strs[i]);
            memory.put(hash, temp);
        }
        
        for(Map.Entry<String, ArrayList<String>> pair : memory.entrySet() ) {
            res.add(pair.getValue());
        }
        
        return res;
    }
    
	public String generateHash(String str) {
        int [] freq = new int[26];
        
        char[] s = str.toCharArray();
        
        for(int i = 0; i < s.length; i++) {
            freq[(int)(s[i] - 'a')]++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) {
                char ch = (char)('a' + i);
                sb.append(ch).append(freq[i]);
            }
        }
        
        return sb.toString();
    }
}
