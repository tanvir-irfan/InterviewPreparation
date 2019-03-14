import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.List;
import java.util.Base64.Decoder;


class Result {

    /*
     * Complete the 'decode' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY codes
     *  2. STRING encoded
     */

    public static String decode(List<String> codes, String encoded) {
    // Write your code here
        Trie tr = new Trie();
        tr.buildTrie(codes);

        String res = tr.search(encoded);

        return res;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    static class Trie {

        class TrieNode {
            Character name;
            
            //HashMap<Character, TrieNode> children;
            TrieNode[] children;
            boolean isWord;
            String value; // only has value when isWord == true;

            TrieNode() {
                this(null);
            }

            TrieNode(Character ch, boolean isWord) {
                this(ch, isWord, "");
            }

            TrieNode(Character ch, boolean isWord, String value) {
                this.name = ch;
                //this.children = new HashMap<>();
                this.children = new TrieNode[2];
                this.isWord = isWord;
                this.value = value;
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

        public void buildTrie(List<String> dict) {
            for (String s : dict) {
                // format:
                // d    100000
                // [newline]    111111
                String [] charWithCode = s.split("\\s+");
                this.insert(charWithCode[0], charWithCode[1]);
            }
        }

        /** Inserts a code into the trie. */
        public void insert(String value, String code) {
            TrieNode curNode = root;

            for (int i = 0; i < code.length(); i++) {
                Character ch = code.charAt(i);

                //TrieNode child = curNode.children.get(ch);
                int index = Integer.parseInt(ch + "");
                TrieNode child = curNode.children[index];

                if (child == null) {
                    child = new TrieNode(ch);
                    curNode.children[index] =  child;
                }

                curNode = child;
            }

            curNode.isWord = true;
            curNode.value = value;
        }

        /** Returns String represented by the encoded String. */
        public String search(String encoded) {
            char [] encodedA = encoded.toCharArray();
            
            StringBuilder sb = new StringBuilder();
            
            TrieNode curNode = root;

            for (int i = 0; i < encodedA.length; i++) {
                Character ch = encodedA[i];

                //TrieNode child = curNode.children.get(ch);
                TrieNode child = curNode.children[Integer.parseInt(ch + "")];

                if(child.isWord) {
                    String value = child.value;
                    if(value.equals("[newline]")) {
                        sb.append("\n");
                    } else {
                        sb.append(value);
                    }
                    curNode = root;
                    continue;
                }
                curNode = child;
            }
            return sb.toString();
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int codesCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> codes = new ArrayList<>();
//
//        for (int i = 0; i < codesCount; i++) {
//            String codesItem = bufferedReader.readLine();
//            codes.add(codesItem);
//        }
//
//        String encoded = bufferedReader.readLine();
//
//        String result = Result.decode(codes, encoded);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    	
    	List<String> codes = new ArrayList<>();
//    	codes.add("A	0");
//    	codes.add("B	111");
//    	codes.add("C	1100");
//    	codes.add("D	1101");
//    	codes.add("R	10");
    	
    	System.out.println(Result.decode(codes, ""));
    	
    	System.out.println("hello".equals('\n'));
    	
    }
}