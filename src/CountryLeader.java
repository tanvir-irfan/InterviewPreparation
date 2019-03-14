import java.util.Scanner;

public class CountryLeader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WhoIsTheLeader();
//		System.out.println("\"a\".compareTo(\"b\") = " + "a".compareTo("b"));
//		System.out.println("\"a\".compareTo(\"a\") = " + "a".compareTo("a"));
//		System.out.println("\"b\".compareTo(\"a\") = " + "b".compareTo("a"));
//		"a".compareTo("b"); // returns a negative number, here -1
//		"a".compareTo("a"); // returns  0
//		"b".compareTo("a"); // returns a positive number, here 1
	}

	public static int calculateDiffCharacter(String name) {
		if (name == null || name.length() < 1) {
			return -1;
		}
		int[] chars = new int[26];
		int count = 0;
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if(c == ' ') continue;
			int index = (int) (c - 'A');
			if (chars[index] == 0) {
				chars[index]++;
				count++;
			}
			// no need of an else case as I will not do anything with the #
			// characters
		}

		return count;
	}

	public static String trimSpaces(String name) {
		String[] tokens = name.split(" ");
		StringBuilder res = new StringBuilder();
		for (int j = 0; j < tokens.length; j++) {
			res.append(tokens[j]);
		}
		return res.toString();
	}

	public static void WhoIsTheLeader() {

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		String resultLeader = "";
		int charInLeader = -1;

		for (int i = 0; i < testCase; i++) {
			int numberOfC = sc.nextInt();
			sc.nextLine();
			for (int j = 0; j < numberOfC; j++) {
				String curName = sc.nextLine();

				int tempCharCount = calculateDiffCharacter(curName);

				if (tempCharCount > charInLeader) {
					charInLeader = tempCharCount;
					resultLeader = curName;
				} else if (tempCharCount == charInLeader) {

//					String oldL = trimSpaces(resultLeader);
//					String newL = trimSpaces(curName);
					if (resultLeader.compareTo(curName) > 0) {
						System.out.println(resultLeader);
						System.out.println(curName);
						charInLeader = tempCharCount;
						resultLeader = curName;											
					}

				}

			}

			System.out.println("Case #" + (i+1) + ": " + resultLeader);
			resultLeader = "";
			charInLeader = -1;
		}
		sc.close();
	}

}
