import java.util.HashMap;

class MapSum {
    
    Trie trie;
    
    /** Initialize your data structure here. */
    public MapSum() {
        trie = new Trie();
    }
    
    public void insert(String key, int val) {
        trie.insert(key, val);
    }
    
    public int sum(String prefix) {
    	Trie.TrieNode res = trie.search(prefix);
        return res == null ? 0 : res.value;
    }
    
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		MapSum ms = new MapSum();
		
		ms.insert("aa", 3);
		
		System.out.println(ms.sum("a"));
		
		ms.insert("ab", 2);
		System.out.println(ms.sum("a"));
		
	}
    
    ////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////SUPPORTING TRIE CLASS///////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////
    
    
    class Trie {
    
        class TrieNode {
            Character name;
            int value;
            HashMap<Character, TrieNode> children;
            boolean isWord;

            TrieNode() {
                this(null);
            }

            TrieNode(Character ch) {
                this(ch, false);
            }            
            
            TrieNode(Character ch, boolean isWord) {                
                this(ch, false, 0);
            }
            
            TrieNode(Character ch, boolean isWord, int val) {
                this.name = ch;
                this.children = new HashMap<>();
                this.isWord = isWord;
                this.value = val;
            }
            
            public void increaseVal (int val) {
                this.value += val;
            }

        }

        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
             root = new TrieNode(null);
        }

        /** Inserts a key, val into the trie. */
        public void insert(String key, int val) {
            
        	TrieNode prevN = search(key);
        	
            int prevValue = (prevN != null && prevN.isWord) ? prevN.value : -1;
            
            // if key does not exists then new value is increased by 'val'.
            // however, if key does exists, then we increase the previous value by the difference!
            int valIncreased = (prevValue == -1) ? val : (val - prevValue);
            
            TrieNode curNode = root;

            for(int i = 0; i < key.length(); i++) {
                Character ch = key.charAt(i);

                TrieNode child = curNode.children.get(ch);

                if(child == null) {
                    child = new TrieNode(ch, i == (key.length() - 1), valIncreased);
                    curNode.children.put(ch, child);
                } else {
                	child.increaseVal(valIncreased);
                }

                curNode = child;
            }

            curNode.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public TrieNode search(String word) {
            TrieNode curNode = root;

            for(int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);

                TrieNode child = curNode.children.get(ch);

                if(child == null) {
                    return null;
                }                        

                curNode = child;
            }            

            return curNode;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode curNode = root;

            for(int i = 0; i < prefix.length(); i++) {
                Character ch = prefix.charAt(i);

                TrieNode child = curNode.children.get(ch);

                if(child == null) {
                    return false;
                }

                curNode = child;
            }
            return true;
        }
    
    
    
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */