import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class _MinimumGenericMutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] wordListS = { };

		System.out.println(new _MinimumGenericMutation().minMutation("AACCGGTT", "AACCGGTA", wordListS));
	}

	public int minMutation(String start, String end, String[] bank) {

		if (bank == null || bank.length == 0) {
			return -1;
		}

		HashMap<String, List<String>> memory = new HashMap<>();

		for (String s : bank) {
			addToDictionary(s, memory);
		}

		HashSet<String> visited = new HashSet<>();

		LinkedList<String> q = new LinkedList<>();
		q.addLast(start);

		visited.add(start);

		int distance = 1;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				String curWord = q.removeFirst();

				List<String> neighboursGroup = generateAllWords(curWord);

				for (String nextGroup : neighboursGroup) {
					List<String> allNeighbours = memory.get(nextGroup);

					if (allNeighbours == null) {
						continue;
					}

					if (allNeighbours.contains(end)) {
						return distance;
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

		return -1;

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
