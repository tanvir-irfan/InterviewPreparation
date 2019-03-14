// https://leetcode.com/problems/jump-game/description/
/* 
	Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Determine if you are able to reach the last index.
*/
// https://leetcode.com/problems/jump-game-ii/description/
/*
	Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Your goal is to reach the last index in the minimum number of jumps.
*/

import java.util.Arrays;
import java.util.LinkedList;

public class _JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int [] nums =
		// {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
		// int [] nums = {2,3,1,1,4};// {-, -, -, -, 0}
		// int [] nums = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4};
		int[] nums = { 8, 2, 4, 4, 4, 9, 5, 2, 5, 8, 8, 0, 8 };

		_JumpGame j = new _JumpGame();
		int res = j.jump(nums);

		System.out.println(res);
	}
	
	// https://leetcode.com/problems/jump-game/description/
	// Input: [2,3,1,1,4]
	// Output: true
	// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
	// 
	// Input: [3,2,1,0,4]
	// Output: false
	// Explanation: You will always arrive at index 3 no matter what. Its maximum
	//             jump length is 0, which makes it impossible to reach the last index.
	public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return true;
        }
        boolean [] possible = new boolean[nums.length];
        
        possible[possible.length - 1] = true;
        
        //[3,2,1,0,4]
        //[f,f,f,f,t]
        
        for(int i = possible.length - 2; i >= 0; i--) {
            int jumpLength = nums[i];
            
            for(int j = 1; j <= jumpLength; j++) {
                int next = i + j;
                if(next >= possible.length) {
                    break;
                } else {
                    if(possible[next] == true) {
                        possible[i] = true;
                        break;
                    }
                }
            }
        }
        
        return possible[0];
    }
	
	public int jump(int[] nums) {
		int[] res = new int[nums.length];

		Arrays.fill(res, 0, res.length - 1, Integer.MAX_VALUE);

		for (int i = res.length - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;

			int jumpLength = nums[i];
			for (int j = 1; j <= jumpLength && i + j < res.length; j++) {
				min = Math.min(min, res[i + j]);
			}

			res[i] = min != Integer.MAX_VALUE ? min + 1 : Integer.MAX_VALUE;
		}

		return res[0];
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int jumpBFS(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}

		int[][] graph = new int[nums.length][nums.length];

		for (int i = 0; i < nums.length - 1; i++) {
			int neighbours = nums[i];

			for (int j = 1; j <= neighbours; j++) {
				if ((i + j) >= nums.length) {
					break;
				}
				graph[i][i + j] = 1;
			}
		}

		return BFS(graph, 0);
	}

	private int BFS(int[][] graph, int start) {

		LinkedList<Integer> q = new LinkedList<>();
		q.addLast(start);

		boolean[] v = new boolean[graph.length];
		v[start] = true;

		int distance = 1;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {

				int curNode = q.removeFirst();
				if (graph[curNode][graph.length - 1] == 1) {
					return distance;
				}

				for (int j = 0; j < graph.length; j++) {
					if (graph[curNode][j] == 1 && !v[j]) {
						q.addLast(j);
						v[j] = true;
					}
				}
			}

			distance++;

		}

		return -1;
	}

}
