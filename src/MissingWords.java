import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MissingWords {

//	public static List<String> missingWords(String s, String t) {
//
//		List<String> res = new ArrayList<>();
//
//		if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
//			return res;
//		}
//		String[] sAll = s.split("\\s+");
//		String[] tAll = t.split("\\s+");
//		HashMap<String, Integer> memory = new HashMap<>();
//
//		for (String str : sAll) {
//			if (!memory.containsKey(str)) {
//				memory.put(str, 1);
//			} else {
//				memory.put(str, memory.get(str) + 1);
//			}
//		}
//
//		for (String str : tAll) {
//			if (memory.containsKey(str)) {
//				int count = memory.get(str) - 1;
//				if (count == 0) {
//					memory.remove(str);
//				} else {
//					memory.put(str, count);
//				}
//			}
//		}
//
//		for (String str : sAll) {
//			if (memory.containsKey(str)) {
//				res.add(str);
//
//				int count = memory.get(str) - 1;
//				if (count == 0) {
//					memory.remove(str);
//				} else {
//					memory.put(str, count);
//				}
//			}
//		}
//
//		return res;
//	}

	public static List<String> missingWords(String s, String t) {

        List<String> res = new ArrayList<>();

        if(s == null || s.isEmpty() || t == null || t.isEmpty()) {
            return res;
        }

        String [] sAll = s.split("\\s+");
        String [] tAll = t.split("\\s+");

        int sI = 0;
        int tI = 0;
        while(true) {
            if(sAll[sI].equals(tAll[tI])) {
                sI++;
                tI++;
            } else {
                res.add(sAll[sI]);
                sI++;
            }

            if(tI >= tAll.length) {
                break;
            }
        }
        
        while(sI < sAll.length) {
            res.add(sAll[sI++]);
        }
        
        return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		missingWords("Tanvir Tanvir  tanvir Irfan", "tanvir Irfan");
	}

}
