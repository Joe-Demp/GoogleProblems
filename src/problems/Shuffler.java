package problems;

import java.util.Arrays;
import java.util.Random;

public class Shuffler {
	public static int[] numbers;
	
	public static void fillNumbers(int max) {
		numbers = new int[max];
		for (int i = 0; i < max; ++i)
			numbers[i] = i + 1;
	}
	
	public static void shuffleNumbers() {
		Random rand = new Random();
		for (int i = 1; i < numbers.length; ++i) {
			int j = rand.nextInt(i);
			swap(numbers, i, j);
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		fillNumbers(10);
		shuffleNumbers();
		
		System.out.println(Arrays.toString(numbers));
	}

}
