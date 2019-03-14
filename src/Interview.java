
public class Interview {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interview i = new Interview();

		System.out.println(i.reverseString("abcd"));
	}

	public String reverseString(String str) {
		//
		if (str == null || str.isEmpty()) {
			return str;
		}

		StringBuilder sb = new StringBuilder();

		// abcd
		// i = -1

		// curCh = a

		// dcba

		// dcba
		for (int i = str.length() - 1; i >= 0; i--) {
			char curCh = str.charAt(i);

			sb.append(curCh);
		}

		return sb.toString();
	}

}
