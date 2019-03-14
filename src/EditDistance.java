
public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int res = new EditDistance().minimumDeleteSum("sea", "eat");
		
		System.out.println(res);
	}
	
	
	public int minimumDeleteSum(String s1, String s2) {
        char[] wA = s1.toCharArray();
		char[] wB = s2.toCharArray();
        
        int lenW1 = wA.length;
		int lenW2 = wB.length;
		
		int [][] memory = new int[lenW1 + 1] [lenW2 + 1];
		
        
		
        //initializing initial position
        memory[0][0] = 0;
        
		for(int i = 1; i <= lenW1; i++) {
			memory[i][0] = wA[i-1] + memory[i - 1][0];
		}
		
		for(int i = 1; i <= lenW2; i++) {
			memory[0][i] = wB[i-1] + memory[0][i - 1];;
		}
		
		for(int i = 1; i <= lenW1; i++) {
            
			for (int j = 1; j <= lenW2; j++) {
                
				if(wA[i-1] == wB[j-1]) {
					memory[i][j] = memory[i-1][j-1];
				} else {
					int costWA = wA[i-1];
                    int costWB = wB[j-1];
					memory[i][j] = Math.min(memory[i][j - 1] + costWB, memory[i - 1][j] + costWA);
				}
			}
		}
		
        return memory[lenW1][lenW2];
    }
	
	public int minDistance(String word1, String word2) {
		int lenW1 = word1.length();
		int lenW2 = word2.length();
		
		int [][] memory = new int[lenW1 + 1] [lenW2 + 1];
		
		
		for(int i = 0; i <= lenW1; i++) {
			memory[i][0] = i;
		}
		
		for(int i = 0; i <= lenW2; i++) {
			memory[0][i] = i;
		}
		
		char[] wA = word1.toCharArray();
		char[] wB = word2.toCharArray();
		
		for(int i = 1; i <= lenW1; i++) {
			for (int j = 1; j <= lenW2; j++) {
				if(wA[i-1] == wB[j-1]) {
					memory[i][j] = memory[i-1][j-1];
				} else {
					int temp = Math.min(memory[i - 1][j], memory[i][j - 1]) + 1;
					memory[i][j] = Math.min(temp, memory[i - 1][j - 1] + 1);
				}
			}
		}
		
        return memory[lenW1][lenW2];
    }

}
