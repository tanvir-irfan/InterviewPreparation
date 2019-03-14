import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class _WordLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] wordListS = { "hot","dot","dog","lot","log","cog" };

		List<String> wordList = Arrays.asList(wordListS);

		System.out.println(new _WordLadder().ladderLength("hit", "cog", wordList));
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		HashMap<String, List<String>> memory = new HashMap<>();

		for (String s : wordList) {
			addToDictionary(s, memory);
		}

		HashSet<String> visited = new HashSet<>();
		
		LinkedList<String> q = new LinkedList<>();
		q.addLast(beginWord);
		
		visited.add(beginWord);

		int distance = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				String curWord = q.removeFirst();
				
				List<String> neighboursGroup = generateAllWords(curWord);
				
				for(String nextGroup : neighboursGroup) {
					List<String> allNeighbours = memory.get(nextGroup);
					
					if(allNeighbours == null) {
						continue;
					}
					
					if (allNeighbours.contains(endWord)) {
						return distance + 1;
					} else {
						for (String nextWord : allNeighbours) {
							if (!visited.contains(nextWord)) {
								q.addLast(nextWord);
								visited.add(nextWord);
							}
						}
					}
				}
				
			}
			distance++;
		}

		return 0;
	}

	private void addToDictionary(String word, HashMap<String, List<String>> memory) {

		for (String key : generateAllWords(word)) {
			if (memory.containsKey(key)) {
				List<String> list = memory.get(key);
				list.add(word);
			} else {
				List<String> list = new ArrayList<>();
				list.add(word);
				memory.put(key, list);
			}
		}
	}

	private List<String> generateAllWords(String word) {
		List<String> res = new ArrayList<>();

		char[] wordCh = word.toCharArray();

		for (int i = 0; i < wordCh.length; i++) {
			char ch = wordCh[i];
			wordCh[i] = '*';
			String key = new String(wordCh);

			wordCh[i] = ch;
			
			res.add(key);
		}
		
		return res;
	}
}
