import java.util.ArrayList;

public class RandomAttendanceTrie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RandomAttendanceTrie  r = new RandomAttendanceTrie();
		ArrayList<Integer> B = new ArrayList<>();
		B.add(2);
		B.add(5);
		
		r.solve(12, B);
	}

	private long poz(int n) {
        long res = n;
        long k = 1;
        n /= 10;
        while (n > 0) {
            res += (n % 10) * k + 1;
            n /= 10;
            k = k * 10 + 1;
        }
        return res;
    }
    
    private long max(int n) {
        long res = 0;
        while (n > 0) {
            res = res * 10 + 9;
            n /= 10;
        }
        return res;
    }
    
    private String find(long p, long max) {
        // System.out.println("-> " + p + " " + max);
        if (max < 10)
            return "" + p;
        
        long groupSize = max / 9;
        long group = p / groupSize;
        long offset = p % groupSize;
        if (offset == 0)
            return "" + group;
        else
            return "" + group + find(offset - 1, max / 10);
    }
    
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        long pozA = poz(A);
        long max = max(A);
        for (int b : B) {
            long p = b - 1 + max / 9;
            if (p <= pozA) {
                res.add(Integer.parseInt(find(p, max)));
            } else {
                res.add(Integer.parseInt(find(p - A - 1, max / 10)));
                // System.out.println(A+" "+b+" "+p+" "+max+" "+pozA);
            }
        }
        return res;
    }
	
	/////////////////////////////////////////////////////////////////////////
	
//	public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
//		Trie tr = new Trie();
//		
//		for(int i = 1; i <= A; i++) {
//			tr.insert(i + "");
//		}
//		
//		ArrayList<Integer> res = new ArrayList<>();
//		
//		for(int roll : B) {
//			res.add(tr.search(roll));
//		}
//		return res;
//    }
//    
//    private class TrieNode{
//        int name;
//        boolean isValid;
//        int totalChildBelow;
//        
//        TrieNode[] children;
//        
//        TrieNode() {
//        	this(0, false, 0);
//        }
//        
//        TrieNode(int name) {
//            this(name, false, 1);
//        }
//        
//        TrieNode(int name, boolean isValid, int totC) {
//            this.name = name;
//            this.isValid = isValid;
//            this.totalChildBelow = totC;
//            children = new TrieNode[10];
//        }
//        
//        public String toString() {
//            StringBuilder sb = new StringBuilder();
//            sb.append(this.name).append("[ ");
//            
//            for(TrieNode t : this.children) {
//                if(t != null) {
//                    sb.append(t.name + " ");
//                }
//            }
//            
//            sb.append("] ").append(this.totalChildBelow);
//            
//            return sb.toString();
//        }
//    }
//    
//    private class Trie{
//        private TrieNode root;
//        
//        Trie(){
//            root = new TrieNode();
//        }
//        
//        public void insert(String roll) {
//        	root.totalChildBelow++;
//        	insert(root, roll, 0);
//        }
//        private void insert(TrieNode root, String roll, int index) {
//            
//            int cInd = (int)(roll.charAt(index) - '0');
//            TrieNode child = root.children[cInd];
//            
//            if(child == null) {
//                root.children[cInd] = new TrieNode(cInd, false, 0);
//            }
//            
//            if(index == roll.length() - 1) {
//                
//            	root.children[cInd].isValid = true;
//            	root.children[cInd].totalChildBelow++;
//                return;
//            }
//            
//            root.children[cInd].totalChildBelow++;
//            
//            insert(root.children[cInd], roll, index + 1);
//        }
//        
//        public int search(int roll) {
//        	String rollS = search(root, roll, "");
//        	
//        	return Integer.parseInt(rollS);
//        }
//        
//        private String search(TrieNode root, int roll, String prefix) {
//        	
//        	if(roll < 0) {
//        		return prefix + root.name;
//        	}
//        	
//        	for(TrieNode t : root.children) {
//        		if(t != null) {
//        			if(t.totalChildBelow >= roll) {
//        				if(t.isValid) {
//        					roll--;
//        				}
//        				if(roll == 0) {
//        					return prefix + t.name;
//        				} else {
//        					return search(t, roll, prefix + t.name);
//        				}
//        			} else {
//        				roll -= t.totalChildBelow;
//        			}
//        		}
//        	}
//        	
//        	return prefix;
//        }
//    }
}
