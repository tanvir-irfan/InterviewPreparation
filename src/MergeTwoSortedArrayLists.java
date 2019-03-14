import java.util.ArrayList;

public class MergeTwoSortedArrayLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);a.add(5);a.add(8);
		
		ArrayList<Integer> b = new ArrayList<>();
		b.add(6);b.add(9);
		
		MergeTwoSortedArrayLists m = new MergeTwoSortedArrayLists();
		
		m.merge(a, b);
		
		System.out.println(a.size());
	}

	
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        if(b == null || b.size() == 0) {
            return;
        } else if(a == null || a.size() == 0) {
            for(Integer i : b) {
                a.add(i);
            }
            return;
        }
        
        merge(a, 0, b, 0);
    }
    
    public void merge(ArrayList<Integer> a, int aIn, ArrayList<Integer> b, int bIn) {
        
        if(bIn >= b.size() || (aIn >= a.size() && bIn >= b.size())) {
            return;
        }
        
        if(aIn >= a.size()) {
            a.add(aIn, b.get(bIn));
            merge(a, aIn + 1, b, bIn + 1);
            return;
        }
        
        int aNum = a.get(aIn);
        int bNum = b.get(bIn);
        
        if(aNum <= bNum) {
            merge(a, aIn + 1, b, bIn);
        } else {
            a.add(aIn, bNum);
            merge(a, aIn + 1, b, bIn + 1);
        }
    }
}
