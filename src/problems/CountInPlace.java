package problems;

import java.util.Scanner;

public class CountInPlace {
	public static Scanner scan = new Scanner(System.in);
	public static int[] numbers;
	
	public static int inPlaceIntegers = 0;
	public static int singleSwaps = 0;
	
	public static void fillNumbers() {
		int size = scan.nextInt();
		numbers = new int[size];
		
		for (int i = 0; i < size; ++i) {
			numbers[i] = scan.nextInt();
		}
	}
	
	public static int countInPlace() {
		int count = 0;
		for (int i = 0; i < numbers.length; ++i) {
			if (numbers[i] == i + 1) {
				count++;
			}
		}
		return count;
	}
	
	public static int countSingleSwaps() {
		int count = 0;
		for (int i = 0; i < numbers.length; ++i) {
			int value = numbers[i];
			if (numbers[i] == i + 1) {
				
			}
			else if (value > i && numbers[value - 1] == i + 1) {
				count++;
			}
		}
		return count;
	}
	
	public static int minimumSwaps(int[] arr) {
        if (sorted(arr)) {
            return 0;
        }

        int minSwaps = arr.length - 1;

        for (int i = 0; i < arr.length && minSwaps != 0; ++i) {
            int value = arr[i];

            if (value == (i + 1)) {
                minSwaps--;
                inPlaceIntegers++;
            }
            else if (value > i && arr[value - 1] == (i + 1)) {
                minSwaps--;
                singleSwaps++;
            }
        }
        return (minSwaps == 0) ? 1 : minSwaps;
    }
	
	public static boolean sorted(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		fillNumbers();
		System.out.println();
		System.out.println();
		System.out.println("countSingleSwaps : " + countSingleSwaps());
		
		System.out.println("Minimum swaps: " + minimumSwaps(numbers));
		System.out.println("inPlaceIntegers : " + inPlaceIntegers);
		System.out.println("singleSwaps : " + singleSwaps);
	}

}
