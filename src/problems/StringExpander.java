package problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StringExpander {
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
	
	static List<StringBuilder> appendSelf(List<StringBuilder> sbList, int times) {
		List<StringBuilder> result = new LinkedList<>();
		
		for (int i = 0; i < times; ++i) {
			for (StringBuilder sb : sbList) {
				result.add(new StringBuilder(sb));
			}
		}
		
		return result;
	}
	
	//TODO fix result
	static List<String> expand(String s) {
		List<StringBuilder> builders = new LinkedList<>();
		builders.add(new StringBuilder());
		StringBuilder bracketBuffer = new StringBuilder();
		boolean bracketMode = false;
		
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			
			switch (c) {
			case '[':
				bracketMode = true;
				break;
			case '|':
				break;
			case ']':
				List<String> multiset = multiset(bracketBuffer.toString());
				int oldSize = builders.size();
				builders = appendSelf(builders, multiset.size());
				Iterator<StringBuilder> builderIt = builders.iterator();
				
				for (String subset : multiset) {
					
					for (int j = 0; j < oldSize; ++j) {
						StringBuilder current = builderIt.next();
						current.append(subset);
					}
				}
				
				bracketMode = false;
				bracketBuffer = new StringBuilder();
				break;
				
			default:
				if (bracketMode) {
					bracketBuffer.append(c);
				} else {
					for (StringBuilder sb : builders) {
						sb.append(c);
					}
				}
				break;
			}
		}
		
		List<String> result = new LinkedList<>();
		for (StringBuilder sb : builders) {
			result.add(sb.toString());
		}
		
		return result;
	}
	
	
	
	public static void main(String[] args) {
		List<String> expansions = expand("ab[c|d]e[f]");
		for (String word : expansions) System.out.println(word);
	}

}
