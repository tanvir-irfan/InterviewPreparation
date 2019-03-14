import java.util.*;

public class StringSearch {
	public static void main(String[] d) {
//		String text = "AABAACAADAABAABA";
//		String pat = "AABA";
//		Integer[] res = BoyerMooreHorspool(text, pat);
//
//		if (res.length == 0) {
//			System.out.println("No Match Found");
//		} else {
//			for (int i : res) {
//				System.out.println(i);
//			}
//		}
		
		StringSearch s = new StringSearch();
		
		System.out.println(StringSearch.BoyerMooreHorspool("TRUSTHARDTOOTHBRUSHES", "TOOTH"));
	}

	public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.isEmpty()) {
            return true;
        } else if(s2 == null || s2.isEmpty() || s1.length() > s2.length()) {
            return false;
        }
        
        char [] s1A = s1.toCharArray();
        char [] s2A = s2.toCharArray();
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        boolean res = false;
        
        int [] freq1 = buildFreq(s1A, 0, len1);
        int [] freq2 = buildFreq(s2A, 0, len1);
        
        for(int i = 0; i <= len2 - len1; i++) {
            
            if(i > 0) {
                int index = (int)(s2A[i - 1] - 'a');
                freq2[index]--;
                
                index = (int)(s2A[i + len1 - 1] - 'a');
                freq2[index]++;
            }
            
            res = check(freq1, freq2);
            if(res) {
                break;
            }
        }
            
        return res;
    }
    
    private int [] buildFreq(char [] sA, int start, int len) {
        // not checking any boundary or edge case as I know everything should be valid
        // if not valid then i screwed up elsewhere.
        int [] freq = new int [26];
        
        for(int i = start; i < start + len; i++) {
            int index = (int)(sA[i] - 'a');
            
            freq[index]++;
        }
        
        return freq;
    }
    
    private boolean check(int [] freq1, int [] freq2) {
        
        boolean res = true;
        for(int i = 0; i < 26; i++) {
            if(freq1[i] != freq2[i]) {
                res = false;
                break;
            }
        }
        
        return res;
    }
	
	public String reverseStr(String s, int k) {

		if(s == null || s.isEmpty() || k == 1) {
			return s;
		}
		
		char[] sA = s.toCharArray();
		int len = sA.length;

		for (int i = 0; i < len; i++) {
			if (i == 0 || (i) % (2 * k) == 0) {
				// start the reversal process;

				int first = i;
				int last = Math.min(i + k - 1, len - 1);

				for (int j = first; j <= (last + first) / 2; j++) {
					char temp = sA[j];
					sA[j] = sA[last + first - j];
					sA[last + first - j] = temp;
				}
				i = last;
			}
		}

		return new String(sA);

	}

	private static Integer[] searchStringNaive(String text, String pat) {
		ArrayList<Integer> res = new ArrayList<>();
		int tL = text.length();
		int pL = pat.length();

		for (int i = 0; i <= tL - pL; i++) {
			boolean isMatch = isIndexMatch(i, text, pat);

			if (isMatch) {
				res.add(i);
			}
		}

		return res.toArray(new Integer[0]);
	}

	private static boolean isIndexMatch(int index, String text, String pat) {
		int pL = pat.length();
		boolean res = true;
		for (int i = 0; i < pL; i++) {
			if (text.charAt(index + i) != pat.charAt(i)) {
				res = false;
				break;
			}
		}

		return res;
	}

	private static Integer[] BoyerMooreHorspool(String text, String pat) {

		int[] preprocessRes = BoyerMooreHorspoolPreprocess(pat);

		ArrayList<Integer> res = new ArrayList<>();
		int tL = text.length();
		int pL = pat.length();

		for (int i = pL - 1; i < tL;) {
			boolean isMatchFound = true;
			for (int j = 0; j < pL; j++) {
				if (pat.charAt(pL - j - 1) != text.charAt(i - j)) {
					char chT = text.charAt(i);
					int index = findIndex(chT);
					int advance = preprocessRes[index];

					i += advance;
					isMatchFound = false;
					break;
				}
			}

			if (isMatchFound) {
				res.add(i - pL + 1);
				// change it to i += 1 when u want all occurance
				i += pL;
			}
		}

		return res.toArray(new Integer[0]);
	}

	private static int[] BoyerMooreHorspoolPreprocess(String pat) {
		int[] res = new int[26];

		for (int i = 0; i < 26; i++) {
			res[i] = pat.length();
		}

		for (int i = 0; i < pat.length() - 1; i++) {
			int index = findIndex(pat.charAt(i));

			res[index] = pat.length() - i - 1;
			// System.out.println(pat.charAt(i) + " " + res[index]);
		}

		return res;
	}

	private static int findIndex(char c) {
		return (int) ((c + "").toLowerCase().charAt(0) - 'a');
	}
}
