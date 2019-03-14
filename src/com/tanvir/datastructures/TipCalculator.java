package com.tanvir.datastructures;

import java.util.Arrays;
import java.util.Scanner;

public class TipCalculator {

	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner (System.in);
		int t = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < t; i++) {
		    String[] firstLine = sc.nextLine().split("\\s");
		    String[] secondLine = sc.nextLine().split("\\s");
		    String[] thirdLine = sc.nextLine().split("\\s");
		    
		    int n = Integer.parseInt(firstLine[0]);
		    int x = Integer.parseInt(firstLine[1]);
		    int y = Integer.parseInt(firstLine[2]);
		    
		    int [] ai = new int[n];
		    int [] bi = new int[n];
		    Pair [] allPairs = new Pair[n];
		    for(int j = 0; j < n; j++) {
		        ai[j] = Integer.parseInt(secondLine[j]);
		        bi[j] = Integer.parseInt(thirdLine[j]);
		        
		        allPairs[j] = new Pair(ai[j], bi[j]);
		    }
		    
		    Arrays.sort(allPairs);
		    
		    int res = 0;
		    int len = allPairs.length;
		    
		    int a = 0, b = 0;
		    
		    for(int k = 0; k < n; k++) {
		    	
		    	if(len - y > k) {
		    		res += allPairs[k].bi;
		    		b++;
		    	} else if( i >= x) {
		    		res += allPairs[k].ai;
		    		a++;
		    	} else {
		            res += Math.max(allPairs[k].ai, allPairs[k].bi);
		        }
		    }
		    
		    System.out.println(res);
		}
		
		sc.close();
	}
	
	static class Pair implements Comparable<Pair>{
	    int ai;
	    int bi;
	    int diff;
	    
	    Pair(int ai, int bi) {
	        this.ai = ai;
	        this.bi = bi;
	        
	        this.diff = ai - bi;
	    }
	    
	    public int compareTo(Pair other) {
	        return this.diff - other.diff;
	    }
	    
	    public String toString() {
	    	return "[" + ai + ", " + bi + "] = " + diff;
	    }
	}

}
