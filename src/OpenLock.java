import java.util.LinkedList;;
public class OpenLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] dead = {"8887","8889","8878","8898","8788","8988","7888","9888"};
		String target = "8888";
		
		System.out.println(new OpenLock().openLock(dead, target));
	}
	
    public int openLock(String[] deadends, String target) {
        Trie dead = new Trie();
        
        for(String str : deadends) {
        	dead.insert(str);
        }
        
        Trie visited = new Trie();
        
        String init = "0000";
        
        
        
        return BFS(init, target, dead, visited);
    }
    
    private int BFS(String init, String target, Trie dead, Trie visited) {
        LinkedList <String> q = new LinkedList<>();
        
        int count = 0;
        q.addLast(init);
        
        visited.insert(init);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                String cur = q.removeFirst();
                
                System.out.println(cur);
                
                if(cur.equals(target)) {
                    return count;
                }
                
                for(String next : generate(cur)) {
                    if(!visited.search(next) && !dead.search(next)) {
                        q.addLast(next);
                        visited.insert(next);
                    }
                }
                
                
            }
            count++;
        }
        
        return count++;
    }
    
    private String [] generate(String curStr) {
        String [] res = new String[8];
        StringBuilder sb = new StringBuilder(curStr);
        
        for(int i = 0; i < curStr.length(); i++) {
            int cur = (int)(sb.charAt(i) - '0');
            int temp = cur;
            
            int inc = ((++cur) % 10);
            sb.setCharAt(i, (char)(inc + '0'));
            
            res[2 * i] = sb.toString();
            
            int dec = temp;
            
            if(temp == 0) {
                dec = 9;
            } else {
                dec--;
            }
            sb.setCharAt(i, (char)(dec + '0'));
            res[2 * i + 1] = sb.toString();
            
            sb.setCharAt(i, (char)(temp + '0'));
        }
        
        return res;
    }
}

