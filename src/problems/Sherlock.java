package problems;

import java.util.HashMap;
import java.util.Map;

public class Sherlock {
	// Complete the isValid function below.
    static String isValid(String s) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            charCount[s.charAt(i) - 'a']++;
        }

        // take a poll of the most popular frequencies of characters
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < charCount.length; ++i) {
            if (!map.containsKey(charCount[i])) {
                map.put(charCount[i], 1);
            } else {
                int value = map.get(charCount[i]);
                map.put(charCount[i], value + 1);
            }
        }
        map.remove(0);
        
        //TEST
//        for (Integer i : map.keySet()) {
//        	System.out.print(i + ", ");
//        }
//        System.out.println();
        //ENDTEST

        if (map.keySet().size() == 1) {
            return "YES";
        }
        else if (map.keySet().size() > 2) {
            return "NO";
        }

        // from this point on we know that there are 2 frequencies (keys):
        //  The one that corresponds to most characters
        //  and the one that corresponds to one class of characters

        // majorityKey = the key that has the most values 
        //  (frequency that has been counted the most times)
        // if minorityKey = majorityKey + 1 and value = 1, then yes
        // if minorityKey = 1 and value = 1, then YES
        Map.Entry<Integer,Integer>[] entries = new Map.Entry[2];
        int i = 0;
        for (Map.Entry<Integer,Integer> e : map.entrySet()) {
        	entries[i++] = e;
        }
        int majorityKey, minorityKey;
        if (entries[0].getValue() > entries[1].getValue()) {
            majorityKey = entries[0].getKey();
            minorityKey = entries[1].getKey();
        } else if (entries[0].getValue() < entries[1].getValue()) {
            majorityKey = entries[1].getKey();
            minorityKey = entries[0].getKey();
        } else {
            majorityKey = Math.min(entries[0].getKey(), entries[1].getKey());
            minorityKey = Math.max(entries[0].getKey(), entries[1].getKey());
        }
        
        //TEST
//        System.out.println("majorityKey = " + majorityKey);
//        System.out.println("minorityKey = " + minorityKey);
        //END TEST

        if (map.get(minorityKey) == 1) {
            if ((minorityKey - majorityKey) == 1) {
                return "YES";
            } else if (minorityKey == 1) {
                return "YES";
            }
        }
        return "NO";  
    }

	public static void main(String[] args) {
		String result = isValid("abcdefghhgfedecba");
		System.out.println(result);
	}

}
