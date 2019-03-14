
public class LongestSubstringWithoutRepeatingChars {

	public static int lengthOfLongestSubstring(String s) {
		int[] arr = new int[256];

		int record = 0;
		if (s != null && s.length() > 0)
			record = 1;
		else
			return 0;
		int lastIndex = 0;
		for (int i = 0; i < s.length(); i++) {
			int code = (int) s.charAt(i);

			if (arr[code] != 0) {
				int index = arr[code] - 1;
				int len = i - lastIndex;
				if (len > record)
					record = len;
				if (index >= lastIndex)
					lastIndex = index + 1;
			}
			arr[code] = i + 1;
		}
		if (s.length() - lastIndex > record)
			record = s.length() - lastIndex;

		return record;
	}

	public static void main(String[] s) {
		// System.out.println(lengthOfLongestSubstring("abcabadc"));
		System.out.println(lengthOfLongestSubstring("abcdefghijkklmnopqrstuvwxyz"));

	}
}