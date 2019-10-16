package problems;

import java.util.HashMap;

public class Icecreams {
	static void whatFlavors(int[] cost, int money) {
        HashMap<Integer,Integer> icecreams = new HashMap<>();

        for (int i = 0; i < cost.length; ++i) {
            if (icecreams.containsKey(cost[i])) {
                int other = icecreams.get(cost[i]);
                int min = Integer.min(other, i + 1);
                int max = Integer.max(other, i + 1);
                
                System.out.format("%d %d\n", min, max);
                return;
            } else {
            	int diff = money - cost[i];
                icecreams.put(diff, i + 1);
            }
        }
        return;

    }
	
	public static void main(String[] args) {
		int[] prices = new int[] {1, 4, 5, 3, 2};
		whatFlavors(prices, 4);
	}

}
