public class StringTest {
	public static void main(String[] s) {
		char data[] = { 'a', 'b', 'c', 'd', 'e' };
		String str1 = new String(data); // "abcde"
		// System.out.println(str1);

		// str1 = new String(data,0,1); // "a"
		// System.out.println(str1);
		// str1 = new String(data,0,3); // "abc"
		// System.out.println(str1);
		// str1 = new String(data,0,5); // "abcde"
		// System.out.println(str1);
		// str1 = new String(data,2,0); // ""
		// System.out.println(str1);
		// str1 = new String(data,2,2); // "cd"
		// System.out.println(str1);
		//
		//// str = new String(data,2,4); // "StringIndexOutOfBoundException"
		//// System.out.println(str);

		// String str2 = new String(data); // "abcde"
		// System.out.println(str1==str2);
		// str1 = "TEST";
		// str2 = "TEST";
		// System.out.println(str1==str2);

		// System.out.println(str1.equals(str2));
		//
		// System.out.println(str1.codePointAt(0));
		// System.out.println(str1.codePointAt(3));
		//
		// System.out.println(str1.codePointCount(0,5));

		// char a[] = new char[5];
		// a[0] = ' ';
		// str1.getChars(0, 4, a, 1);
		// System.out.println('\u0000'==a[0]);
		// System.out.println(new String(a));
		// str1.getChars(0, 5, a, 0);

		// System.out.println(new String("BBC").compareTo(new String ("BBC")));
		// System.out.println(new String("BBC").compareTo(new String ("BBA")));
		// System.out.println(new String("BBC").compareTo(new String ("BBF")));

		// System.out.println("test".equals("test"));
		// StringBuffer sbf = new StringBuffer("test");
		// StringBuilder sbl = new StringBuilder("test");
		// System.out.println(sbf.equals(sbl));
		//
		// System.out.println(sbf.toString().contentEquals(sbl));

		// System.out.println("tanvir".hashCode());
		// System.out.println("tanvirirfan".hashCode());
		// System.out.println("tanvirirfanchowdhury".hashCode());
		//
		// System.out.println("tanvir".toUpperCase().hashCode());
		// System.out.println("tanvirirfan".toUpperCase().hashCode());
		// System.out.println("tanvirirfanchowdhury".toUpperCase().hashCode());

		// System.out.println("tanvir".intern());
		//
		// String aa = "aaaccddee";
		// String bb = "bbbccddee";
		// System.out.println(aa.isEmpty());
		// System.out.println(aa.matches(bb));
		// System.out.println(aa.regionMatches(3, bb, 3, 6));
		// String aa = "5";
		// System.out.println(aa.matches("^\\d+(\\.\\d+)?"));
		// aa = "500";
		// System.out.println(aa.matches("^\\d+(\\.\\d+)?"));
		// aa = "50.5";
		// System.out.println(aa.matches("^\\d+(\\.\\d+)?"));
		// aa = "5.0";
		// System.out.println(aa.matches("^\\d+(\\.\\d+)?"));
		// aa = "0.5";
		// System.out.println(aa.matches("^\\d+(\\.\\d+)?"));

		// String EXAMPLE_TEST = "This is my small example "
		// + "string which I'm going to " + "use for pattern matching.";
		//
		// System.out.println(EXAMPLE_TEST.matches("\\w.*"));
		// String[] splitString = (EXAMPLE_TEST.split("\\s+"));
		// System.out.println(splitString.length);// should be 14
		// System.out.println("################# START #####################");
		// for (String string : splitString) {
		// System.out.println(string);
		// }
		// System.out.println("################# END #####################");
		// // replace all whitespace with tabs
		// System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "#"));

		// String EXAMPLE_TEST = "This is my small example string which I'm
		// going to use for pattern matching.";
		// Pattern pattern = Pattern.compile("\\w+");
		// // in case you would like to ignore case sensitivity,
		// // you could use this statement:
		// // Pattern pattern = Pattern.compile("\\s+",
		// Pattern.CASE_INSENSITIVE);
		// Matcher matcher = pattern.matcher(EXAMPLE_TEST);
		// // check all occurance
		// while (matcher.find()) {
		// System.out.print("Start index: " + matcher.start());
		// System.out.print(" End index: " + matcher.end() + " ");
		// System.out.println(matcher.group());
		// }
		// // now create a new pattern and matcher to replace whitespace with
		// tabs
		// Pattern replace = Pattern.compile("\\s+");
		// Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
		// System.out.println(matcher2.replaceAll("\t"));

		String patternString = "(\\d{3})([\\s\\-])?(\\d{4})";
		// String patternString = "(\\d{3})(\\d{4})";
		// Pattern phoneNumber = Pattern.compile(patternString);
		// Matcher matcher = phoneNumber.matcher(exampleString);

		// while (matcher.find()) {
		// System.out.print("Start index: " + matcher.start());
		// System.out.print(" End index: " + matcher.end() + " ");
		// System.out.println(matcher.group());
		// }
		// String exampleString = "1233323322";
		// System.out.println(exampleString.matches(patternString));
		//
		// exampleString = "1233323";
		// System.out.println(exampleString.matches(patternString));
		//
		// exampleString = "123 3323";
		// System.out.println(exampleString.matches(patternString));
		// exampleString = "123-3323";
		// System.out.println(exampleString.matches(patternString));

		// String exampleString = "123456789";
		// System.out.println(reverse(exampleString));

		// Set<String> uniques = new HashSet<String>();
		// Set<String> dups = new HashSet<String>();
		// String []args = "i came i saw i left".split(" ");
		// for (String a : args)
		// if (!uniques.add(a))
		// dups.add(a);
		//
		// // Destructive set-difference
		// uniques.removeAll(dups);
		//
		// System.out.println("Unique words: " + uniques);
		// System.out.println("Duplicate words: " + dups);

		// String[] s1 = "i came i saw i left".split(" ");
		// String[] s2 = "i came i saw i gone".split(" ");
		//
		// Set<String> symmetricDiff = new HashSet<String>(Arrays.asList(s1));
		// System.out.print("symmetricDiff_1 : ");
		// for( String str : symmetricDiff) {
		// System.out.print(str + "\t");
		// }
		//
		// symmetricDiff.addAll(Arrays.asList(s2));
		// System.out.print("\nsymmetricDiff_2 : ");
		// for( String str : symmetricDiff) {
		// System.out.print(str + "\t");
		// }
		//
		// Set<String> tmp = new HashSet<String>(Arrays.asList(s1));
		// System.out.print("\ntmp_1 : ");
		// for( String str : tmp) {
		// System.out.print(str + "\t");
		// }
		// tmp.retainAll(Arrays.asList(s2));
		// System.out.print("\ntmp_2 : ");
		// for( String str : tmp) {
		// System.out.print(str + "\t");
		// }
		// symmetricDiff.removeAll(tmp);
		// System.out.print("\nsymmetricDiff_3 : ");
		// for( String str : symmetricDiff) {
		// System.out.print(str + "\t");
		// }

		// System.out.println(reverseIter("A"));
		// System.out.println(reverseIter("a"));
		// System.out.println(reverseIter("Aa"));
		// System.out.println(reverseIter("123456789"));

		// System.out.println(compress("aa"));
		// System.out.println(compress("aab"));
		// System.out.println(compress("abb"));
		// System.out.println(compress("aabcccccaaa"));

		// System.out.println(palindromeIterV1(""));
		// System.out.println(palindromeIterV1("a"));
		// System.out.println(palindromeIterV1("ab"));
		// System.out.println(palindromeIterV1("aba"));
		// System.out.println(palindromeIterV1("madam"));
		// int i = 1;
		// int leadingZ = Integer.numberOfLeadingZeros(i);
		// StringBuilder reString = new StringBuilder();
		// for(int j = 0; j < Integer.numberOfLeadingZeros(i); j++) {
		// reString.append(0);
		// }
		// System.out.println(reString.append(Integer.toBinaryString(i)));
		// int[] masks = {1, 4, 31, 34 };
		// System.out.println(Integer.toBinaryString(getMask(masks)));
		// System.out.println(Integer.toBinaryString(getMask(masks)).length());

		pringFizzBuzz();
	}

	private static String reverseRecur(String source) {
		if (source.length() == 1)
			return source;
		return reverseRecur(source.substring(1)) + source.charAt(0);
	}

	private static String reverseIter(String source) {

		if (source == null)
			return null;
		if (source.isEmpty())
			return "";
		char[] strC = source.toCharArray();
		int left = 0, right = strC.length - 1;

		while (left < right) {
			char tempC = strC[left];
			strC[left] = strC[right];
			strC[right] = tempC;
			left++;
			right--;
		}
		return String.valueOf(strC);
	}

	public static String compress(String source) {
		if (source == null || source.isEmpty() || source.length() == 2)
			return source;
		char[] chars = source.toCharArray();
		int index = 0;
		StringBuilder res = new StringBuilder("");
		while (index < source.length()) {
			int offset = findStrech(chars, index);
			res.append(chars[index]).append(offset - index + 1);
			index = offset + 1;
		}
		return (source.length() > res.toString().length()) ? res.toString() : source;
	}

	public static int findStrech(char[] chars, int index) {
		// validity checks, LATER
		// if(chars == null) throw new Exception();

		int i = index + 1;
		for (; i < chars.length; i++) {
			if (chars[i] == chars[i - 1]) {
				continue;
			} else {
				break;
			}
		}
		return i - 1;
	}

	public static boolean palindromeIterV1(String str) {
		if (str == null)
			return false;
		if (str.length() <= 1)
			return true;

		boolean res = true;
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) == str.charAt(right)) {
				left++;
				right--;
				continue;
			} else {
				res = false;
				break;
			}
		}
		return res;
	}

	public static int getMask(int[] bitsA) {
		int i = 0;

		for (int j = 0; j < bitsA.length; j++) {
			if (bitsA[j] < 32)
				i |= 1 << bitsA[j];
		}
		return i;
	}

	public static void pringFizzBuzz() {
		int three = getMask(new int[] { 0, 1 });
//		System.out.println(Integer.toBinaryString(getMask(new int[] { 0, 1 })));
		int five = getMask(new int[] { 0, 1, 2 });
//		System.out.println(Integer.toBinaryString(getMask(new int[] { 0, 1, 2 })));

		for (int i = 1; i <= 100; i++) {
			int iThree = i & three;
			int iFive = (i & five);
			if (iThree != 0 && iFive != 0) {
				System.out.println("FizzBuzz");
			} else if (iThree != 0) {
				System.out.println("Fizz");
			} else if (iFive != 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

}
