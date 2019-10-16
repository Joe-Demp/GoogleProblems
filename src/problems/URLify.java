package problems;

public class URLify {
	static String urlify(String s, int len) {
		char[] arr = s.toCharArray();
		char[] pattern = new char[]{'%', '2', '0'};
		int numberOfShifts = 0;
		
		for (int i = 0; i < len; ++i) {
			if (arr[i] == ' ') {
				numberOfShifts += 2;
			}
		}
		
		int j = len + numberOfShifts - 1;
		int i = len - 1;
		
		for ( ; i >= 0; --i) {
			if (arr[i] == ' ') {
				for (int k = 2; k >= 0; --k) {
					arr[j] = pattern[k];
					--j;
				}
			} else {
				arr[j] = arr[i];
				--j;
			}
		}
		
		return new String(arr);
	}
	
	public static void main(String[] args) {
		System.out.println(  urlify("Mr John Smith    ", 13)  );
	}

}
