import java.util.*;
import java.util.List;

public class PhoneNumber {

	public static void main(String[] args) {
		List<String> res = new PhoneNumber().letterCombinations("23");

		System.out.println(res);
	}

	public List<String> letterCombinations(String digits) {

		List<String> res = new ArrayList<>();

		ArrayList<ArrayList<Character>> map = new ArrayList<>();
		buildMap(map);

		// "23"
		for (int i = 0; i < digits.length(); i++) {
			int index = digits.charAt(i) - '0'; // "2"

			ArrayList<Character> dialKeys = map.get(index); // 'a', 'b', 'c'

			List<String> resTemp = new ArrayList<>();
			resTemp.addAll(res);
			res.clear();
			for (int j = 0; j < dialKeys.size(); j++) {

				char curKey = dialKeys.get(j);

				if (resTemp.size() == 0) {
					res.add(curKey + "");
				} else {
					for (int k = 0; k < resTemp.size(); k++) {
						res.add(k, resTemp.get(k) + curKey + "");
					}
				}
			}
		}
		System.out.println(res.size());
		for (String str : res) {
			System.out.println(str);
		}

		return res;
	}

	private void buildMap(ArrayList<ArrayList<Character>> map) {
		ArrayList<Character> arr = new ArrayList<>();

		// 0 -> ' '
		arr.add(' ');
		map.add(arr);

		arr = new ArrayList<>();

		// 1 -> '*'
		arr.add('*');
		map.add(arr);

		arr = new ArrayList<>();

		// 2 -> 'a', 'b', 'c'
		arr.add('a');
		arr.add('b');
		arr.add('c');

		map.add(arr);

		arr = new ArrayList<>();

		// 3 -> 'd', 'e', 'f'
		arr.add('d');
		arr.add('e');
		arr.add('f');

		map.add(arr);

		arr = new ArrayList<>();
		// 4 -> 'g', 'h', 'i'
		arr.add('G');
		arr.add('h');
		arr.add('i');

		map.add(arr);

		arr = new ArrayList<>();
		// 5 -> 'j', 'k', 'l'
		arr.add('j');
		arr.add('k');
		arr.add('l');

		map.add(arr);

		arr = new ArrayList<>();
		// 6 -> 'm', 'n', 'o'
		arr.add('m');
		arr.add('n');
		arr.add('o');

		map.add(arr);

		arr = new ArrayList<>();
		// 7 -> 'p', 'q', 'r', 's'
		arr.add('p');
		arr.add('q');
		arr.add('r');
		arr.add('s');

		map.add(arr);

		arr = new ArrayList<>();
		// 8 -> 't', 'u', 'v'
		arr.add('t');
		arr.add('u');
		arr.add('v');

		map.add(arr);

		arr = new ArrayList<>();

		// 9 -> 'w', 'x', 'y', 'z'
		arr.add('w');
		arr.add('x');
		arr.add('y');
		arr.add('z');

		map.add(arr);

		// arr.clear();
	}

}
