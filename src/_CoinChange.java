import java.util.Arrays;

// https://leetcode.com/problems/coin-change/description/

public class _CoinChange {
	
	public static void main(String [] s) {
		int [] coins = {1,2,5};
		int amount = 11;
		
		System.out.println(coinChange(coins, amount));
	}
	
	public static int coinChange(int[] coins, int amount) {
        int [] cache = new int[amount + 1];
        
        cache[0] = 0;
        Arrays.fill(cache, 1, cache.length, Integer.MAX_VALUE);
        
        for(int i = 0; i < coins.length; i++) {
            int index = coins[i];
            
            if(index < cache.length) {
                cache[index] = 1;
            }
        }
        
        for(int i = 1; i < cache.length; i++) {
            if(cache[i] == 1) {
                continue;
            }
            
            for(int j = 0; j < coins.length; j++) {
                int ind = i - coins[j];
                
                int tempRes = (ind >= 0 && cache[ind] != Integer.MAX_VALUE) ? cache[ind] + 1 : Integer.MAX_VALUE;
                if(cache[i] > tempRes) {
                    cache[i] = tempRes;
                }
            }
        }
        
        return cache[amount] != Integer.MAX_VALUE ? cache[amount] : -1;
    }
	
//	public static int coinChange(int[] coins, int amount) {
//
//        //Arrays.sort(coins);
//        int [] memory = new int [amount+1];
//        memory[0] = 0;
//        for(int i = 1; i <= amount; i++) {
//            memory[i] = Integer.MAX_VALUE;
//        }
//
//        for(int i = 0; i < coins.length; i++) {
//            int tempIndex = coins[i];
//            if(tempIndex <= amount)
//                memory[tempIndex] = 1;
//        }
//
//        for (int a = 1; a <= amount; a++) {
//            // if i can solve it by only 1 coin then that is the smallest.
//            // no need to try further optimization.
//            if(memory[a] == 1) 
//                continue;
//
//            // further improvement logic: if current coin is bigger than the amount
//            // don't bother try any next coin as they are sorted. 
//
//            for(int i = 0; i < coins.length; i++) {
//                int prevIndex = a - coins[i];
//                int temp = (prevIndex >= 0 && memory[prevIndex] != Integer.MAX_VALUE) ? (memory[prevIndex] + 1) : Integer.MAX_VALUE;
//
//                if(memory[a] > temp ) 
//                    memory[a] = temp;
//            }
//        }
//
//        if(memory[amount] == Integer.MAX_VALUE) 
//            return -1;
//        else return memory[amount];
//     }
}
