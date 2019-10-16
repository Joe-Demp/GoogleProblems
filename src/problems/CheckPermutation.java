package problems;

import java.util.Arrays;

public class CheckPermutation {

	/*Case insensitive*/
	static boolean checkPermutation(String a, String b) {
		char[] arrayA = a.toLowerCase().toCharArray();
		char[] arrayB = b.toLowerCase().toCharArray();
		
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);
		
		if (arrayA.length != arrayB.length) {
			return false;
		}
		
		for (int i = 0; i < arrayA.length; ++i) {
			if (arrayA[i] != arrayB[i]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(checkPermutation("", ""));
		System.out.println(checkPermutation("abcd", "bacd"));
		System.out.println(checkPermutation("Catbats", "Batcats"));
		System.out.println(checkPermutation("", ""));
	}

}
