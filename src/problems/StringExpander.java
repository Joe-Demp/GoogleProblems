package problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StringExpander {
	
	//TODO fix result
	static List<String> expand(String s) {
		List<StringBuilder> builders = new LinkedList<>();
		if (!s.isEmpty()) {
			builders.add(new StringBuilder());
		}
		boolean inBrackets = false;
		StringBuilder bracketContents = new StringBuilder();
		
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			
			switch (c) {
			case '[':
				inBrackets = true;
				break;
			case '|':
				break;
			case ']':
				List<String> sets = multiset(bracketContents.toString());
				int numberOfIterations = bracketContents.length();
				
				//DEBUG
//				System.out.println("sets size = " + sets.size());
//				System.out.println("builders size = " + builders.size());
				//END DEBUG
				//TODO fix here: builders needs to be big enough to accept a 
				for (int k = 0; k < numberOfIterations; ++k) {
					appendDuplicate(builders);
				}
				
				Iterator<StringBuilder> sbIt = builders.iterator();
				while (sbIt.hasNext()) {
					for (String word : sets) {
						sbIt.next().append(word);
					}
				}
				
				bracketContents = new StringBuilder();
				inBrackets = false;
				break;
			default:
				if (inBrackets) {
					bracketContents.append(c);
				} else {
					for (StringBuilder sb : builders) {
						sb.append(c);
					}
				}
				break;
			}
		}
		
		List<String> results = new LinkedList<>();
		if (!builders.isEmpty()) {
			for (StringBuilder builder : builders) {
				results.add(builder.toString());
			}
		}
		return results;
	}
	
	static List<String> multiset(String s) {
		if (s.isEmpty()) {
			List<String> list = new LinkedList<>();
			list.add("");
			return list;
		} else {
			List<String> strings = multiset(s.substring(1));
			List<String> newStrings = new LinkedList<>();
			
			for (String word : strings) {
				String k = s.charAt(0) + word;
				newStrings.add(k);
			}
			
			strings.addAll(newStrings);
			return strings;
		}
	}
	
	static void appendDuplicate(List<StringBuilder> sbList) {
		List<StringBuilder> copy = new LinkedList<>();
		for (StringBuilder sb : sbList) {
			copy.add(new StringBuilder(sb));
		}
		
		sbList.addAll(copy);
	}
	
	public static void main(String[] args) {
		List<String> expansions = expand("ab[c|d]e[f]");
		for (String word : expansions) System.out.println(word);
		
		List<String> strings = multiset("f");
		for (String q : strings) System.out.println(q);
	}

}
