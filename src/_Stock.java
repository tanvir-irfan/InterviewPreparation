//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class _Stock {

	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
	// only permitted to complete at most one transaction
	//
	// Input: [7,1,5,3,6,4]
	// Output: 5
	public int maxProfitAtMostOne(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}

		// tracking the current min price
		int curMin = prices[0];
		int res = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < curMin) {
				// update current min
				curMin = prices[i];
			} else {
				// for any bigger price, calculate the profit
				int profit = prices[i] - curMin;

				// update current profit if it is more than the previous one
				res = Math.max(res, profit);
			}
		}

		return res;
	}

	// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
	// You may complete as many transactions as you like
	//
	// Input: [7,1,5,3,6,4]
	// Output: 7
	//
	// Input: [7,6,4,3,1]
	// Output: 0
	public int maxProfit(int[] prices) {
		int total = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i])
				total += prices[i + 1] - prices[i];
		}

		return total;
	}

	// 714. Best Time to Buy and Sell Stock with Transaction Fee

	// - You may complete as many transactions as you like
	// - you need to pay the transaction fee for each transaction.

	// Definition:
	// hold[i] - the maximum profit you can earn if you have to hold at day[i]
	// sold[i] - the maximum profit you can earn if you have to sold at day[i]

	// Formula:

	// hold[i] = max(hold[i - 1], sold[i - 1] - p[i])
	// if hold at [i-1], no op; if sold at [i-1], buy at [i] with cost of p[i];

	// sold[i] = max(sold[i - 1], hold[i - 1] + p[i] - fee)
	// if sold at [i-1], no op;
	// if hold at [i-1], sell at [i] with gain of p[i] fee;

	// Initialization:

	// hold[0] = 0 - price[0]; // buy shares with cost of p[0];
	// sold[0] = 0; // no op no cost;

	public int maxProfitDP(int[] p, int fee) {
		int n = p.length;
		if (n < 2)
			return 0;
		int[] hold = new int[n], sold = new int[n];
		hold[0] = -p[0];
		for (int i = 1; i < n; ++i) {
			hold[i] = Math.max(hold[i - 1], sold[i - 1] - p[i]);
			sold[i] = Math.max(sold[i - 1], hold[i - 1] + p[i] - fee);
		}

		return sold[n - 1];
	}

	public int maxProfit(int[] p, int fee) {
		int profit = 0;
		Integer lo = null, hi = null, n = p.length;
		for (int i = 0; i < n; i++) {
			if (lo != null && hi == null && p[i] - lo > fee)
				hi = p[i]; // buy in
			if (hi != null && p[i] > hi)
				hi = p[i]; // update highest
			if (hi != null && (hi - p[i] > fee || i == n - 1)) { // sale out
				profit += hi - lo - fee;
				hi = null;
				lo = null;
			}

			lo = lo != null ? Math.min(lo, p[i]) : p[i]; // update lowest
		}
		return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_Stock s = new _Stock();

		int[] p = { 1, 3, 2, 8, 4, 9 };
		System.out.println(s.maxProfit(p, 2));
	}
}
