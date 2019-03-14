// https://leetcode.com/problems/longest-valid-parentheses/

public class _LongestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_LongestValidParentheses l = new _LongestValidParentheses();

		String str = "(()())";

		int res = l.longestValidParenthesesDP(str);

		System.out.println(res);

	}

	public int longestValidParenthesesDP(String s) {
		int maxans = 0;
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
	}
	
	
	// T-> O(n); S-> O(1)
	public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}
