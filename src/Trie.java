import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Trie {
    
	class TrieNode {
	    Character name;
	    HashMap<Character, TrieNode> children;
	    boolean isWord;
	    
	    TrieNode() {
	    	this(null);
	    }
	    
	    TrieNode(Character ch, boolean isWord) {
	        this.name = ch;
	        this.children = new HashMap<>();
	        this.isWord = isWord;
	    }
	    
	    TrieNode(Character ch) {
	    	this(ch, false);
	    }

	}
	
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
         root = new TrieNode(null);
    }
    
    public void buildTrie (List<String> dict) {
        for( String s : dict) {
            this.insert(s);
        }
    }
    
    public void buildTrie (String [] dict) {
        for( String s : dict) {
            this.insert(s);
        }
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = root;
        
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            
            TrieNode child = curNode.children.get(ch);
            
            if(child == null) {
                child = new TrieNode(ch, i == (word.length() - 1));
                curNode.children.put(ch, child);
            }
            
            curNode = child;
        }
        
        curNode.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public String replace(String word) {
    	TrieNode curNode = root;
        
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            
            TrieNode child = curNode.children.get(ch);
            
            if(child == null) {
                return word;
            }
            
            if(child.isWord) {
            	return word.substring(0, i+1);
            }
            
            curNode = child;
        }
        
        return word;
    }
    
    public String replaceSentence(String sentence) {
    	String [] all = sentence.split("\\s");
        
        for(int i = 0; i < all.length; i++) {
            all[i] = this.replace(all[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : all) {
            sb.append(s).append(" ");
        }
        
        return sb.toString().trim();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode curNode = root;
        
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            
            TrieNode child = curNode.children.get(ch);
            
            if(child == null) {
                return false;
            }
            
            curNode = child;
        }
        return curNode.isWord;
    }
    
    /** Returns if the word is in the trie. 
     * can search a literal word or a regular expression string containing only letters a-z or '.'.
     * A '.' means it can represent any one letter.
     * */
    public boolean searchRegX(String word) {
        return searchRegX (root, word, 0);
    }
    
    private boolean searchRegX(TrieNode curNode, String word, int index) {
        //TrieNode curNode = root;
        
        for(int i = index; i < word.length(); i++) {
            Character ch = word.charAt(i);
            
            if(ch == '.') {
            	if(i == word.length() - 1) {
            		return hasChildAsWord(curNode);
            	} else {
            		for(Map.Entry<Character, TrieNode> pair : curNode.children.entrySet()) {
                		if(searchRegX(pair.getValue(), word, i+1))
                			return true;
                	}
            		return false;
            	}
            } else {
            	TrieNode child = curNode.children.get(ch);
                
                if(child == null) {
                    return false;
                }
                
                curNode = child;
            }                        
        }
        return curNode.isWord;
    }
    
    private boolean hasChildAsWord(TrieNode node) {
    	
    	for(Map.Entry<Character, TrieNode> pair : node.children.entrySet()) {
    		if(pair.getValue().isWord)
    			return true;
    	}
    	
    	return false;
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
    
    
    public static void main(String [] s) {
    	Trie tr = new Trie();
    	
    	String [] dict = {"e","k","c","harqp","h","gsafc","vn","lqp","soy","mr","x","iitgm","sb",
    			"oo","spj","gwmly","iu","z","f","ha","vds","v","vpx","fir","t","xo","apifm",
    			"tlznm","kkv","nxyud","j","qp","omn","zoxp","mutu","i","nxth","dwuer","sadl","pv",
    			"w","mding","mubem","xsmwc","vl","farov","twfmq","ljhmr","q","bbzs","kd","kwc","a",
    			"buq","sm","yi","nypa","xwz","si","amqx","iy","eb","qvgt","twy","rf","dc","utt",
    			"mxjfu","hm","trz","lzh","lref","qbx","fmemr","gil","go","qggh","uud","trnhf","gels",
    			"dfdq","qzkx","qxw"};
    	
    	tr.buildTrie(dict);
    	
    	String sentence = "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb "
    			+ "bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm "
    			+ "gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg "
    			+ "hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft "
    			+ "uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv "
    			+ "jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh "
    			+ "zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs "
    			+ "bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna "
    			+ "ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb "
    			+ "bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj "
    			+ "uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp";
//    	for(String str : dict) {
//    		System.out.println( str + ": " + tr.search(str));
//    	}
    	//System.out.println(tr.replaceSentence(sentence));
    	
    	
    	
    	System.out.println(tr.searchRegX("harqp"));
    	System.out.println(tr.searchRegX("harq."));
    	System.out.println(tr.searchRegX("har.p"));
    	System.out.println(tr.searchRegX("ha..p"));
    	System.out.println(tr.searchRegX("har.."));
    	System.out.println(tr.searchRegX("h....p"));
    }
}