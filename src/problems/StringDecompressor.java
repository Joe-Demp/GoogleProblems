/*
 * Working solution for the String decompression problem from here:
 * https://techdevguide.withgoogle.com/paths/advanced/compress-decompression#!
 */
package problems;
import java.util.Scanner;
import java.util.Stack;

public class StringDecompressor {

	public static String decompress(String arg) {
		String result = "";
		Scanner scan = new Scanner(arg);
		scan.useDelimiter("\\W");
		int i = 0;
		
		while (i < arg.length()) {
			char c = arg.charAt(i);
			if (Character.isDigit(c)) {
				//	take in the whole number
				//TODO fix this line, scanner can't pick out integer
				int k = scan.nextInt(1);
				int openingIndex = arg.indexOf("[");
				int lastClosingIndex = -1;
				
				// run through String from opening index to the position of the last ]
				Stack<Integer> stack = new Stack<Integer>();
				stack.push(openingIndex);
				int j = openingIndex + 1;
				while (!stack.isEmpty()) {
					char d = arg.charAt(j);
					if (d == '[')
						stack.push(j);
					else if (d == ']') {
						stack.pop();
						lastClosingIndex = j;
					}
					
					j++;
				}
				String subResult = decompress(arg.substring(openingIndex, lastClosingIndex));
				for (int m = 0; m < k; ++m)
					result += subResult;
				
				i = lastClosingIndex + 1;
			} 
			else if (Character.isLetter(c)) 
				result += arg.charAt(i++);

			else return result;
		}
		//TODO ensure every case has a return value
		return "";
	}
	
	
	
	public static void main(String[] args) {
		String m = "My [Little] Pony";
		Scanner scan = new Scanner(m);
		
		scan.useDelimiter("\\W");
		while (scan.hasNext())
			System.out.print(scan.next());
	}

}
