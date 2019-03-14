import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

	ArrayList<Integer> list;
    HashMap<Integer, Integer> memory;
    int lastIndex;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        memory = new HashMap<>();
        lastIndex = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(memory.containsKey(val)) {
            return false;
        } else {
            list.add(lastIndex, val);
            memory.put(val, lastIndex);
            lastIndex++;
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(memory.containsKey(val)) {
            //finding out what is the index of the val in list.
            int index = memory.get(val);
            
            // memory does not need to keep the value;
            memory.remove(val);
            
            // special case: when there is only one elements in the list
            // and we are going to remove it.
            if(index == lastIndex - 1) {
            	list.clear();
            	lastIndex = 0;
            } else {
            	// now replace the value with the last value in the list
                list.set(index, list.get(lastIndex - 1));
                
                // update the index (in memory) of replaced value.
                memory.put(list.get(index), index);
                
                // remove the last element
                list.remove(--lastIndex);
            }
            
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int randI = rand.nextInt(lastIndex);
        
        return list.get(randI);
    }
    
    public static void main(String [] s) {
    	RandomizedSet rs = new RandomizedSet();
    	
    	System.out.println(rs.insert(1));
    	System.out.println(rs.remove(2));
    	System.out.println(rs.insert(2));
    	System.out.println(rs.getRandom());
    	System.out.println(rs.remove(1));
    	System.out.println(rs.insert(2));
    	System.out.println(rs.getRandom());
    	
//    	rs.insert(0);
//    	rs.remove(0);
//    	rs.insert(1);
//    	rs.remove(0);
//    	rs.insert(2);
//    	rs.insert(3);
//    	rs.insert(4);
//    	rs.insert(5);
//    	
//    	for(int i = 0; i < 10; i++) 
//    		System.out.println(rs.getRandom());
    	
    	
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */