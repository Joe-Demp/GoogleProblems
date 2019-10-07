package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CharTests {

	public static void main(String[] args) {
		System.out.println(97 - 'a');
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		Set<Map.Entry<Integer,Integer>> entries = map.entrySet();
		for (Map.Entry<Integer,Integer> entry : entries) {
			entry.getKey();
			entry.getValue();
		}
	}

}
