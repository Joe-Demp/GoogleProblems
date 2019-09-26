/*
 * Working solution for the String decompression problem from:
 * https://techdevguide.withgoogle.com/paths/advanced/compress-decompression#!
 */
package problems;
import java.util.Stack;

public class StringDecompressor {

	public static String decompress(String arg) {
		String result = "";
		StringBuilder number = new StringBuilder();
		int i = 0;
		
		while (i < arg.length()) {
			Character c = arg.charAt(i);
			
			if (Character.isDigit(c)) {
				number.append(c);
				++i;
			} 
			else if (c.compareTo('[') == 0) {
				// openingIndex points to the '[' itself
				//	Must pass openingIndex + 1 to substring to cut it out of the next decompression
				//	and prevent infinite recursion
				int openingIndex = i;
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
				
				// Get the decompressed string and the multiplier
				int multiplier = Integer.parseInt(number.toString());
				String subResult = decompress(arg.substring(openingIndex + 1, lastClosingIndex));
				
				for (int m = 0; m < multiplier; ++m)
					result += subResult;
				
				// reset the key components
				i = lastClosingIndex + 1;		// i skips the [..] section
				number = new StringBuilder();	// create a new empty StringBuilder
			}
			else if (Character.isLetter(c)) { 
				result += c;
				++i;
			}
			else throw new IllegalArgumentException("String arg in incorrect format");
		}
		
		return result;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(StringDecompressor.decompress("3[abc]4[ab]c"));
		
		System.out.println(StringDecompressor.decompress("10[a]"));
		
		System.out.println(StringDecompressor.decompress("2[3[a]b]"));
		
		System.out.println(StringDecompressor.decompress("a[]b"));
	}

}
