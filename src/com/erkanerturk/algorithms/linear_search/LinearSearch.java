package com.erkanerturk.algorithms.linear_search;

public class LinearSearch {

	// Time complexity O(n)

	private static int linearSearch(int[] array, int value) {
		int arrayLength = array.length;
		for (int i = 0; i < arrayLength; i++) {
			if (value == array[i]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 33, 1, 98, 29, 17, 5, 35, 85, 18, 56, 74, 36 };
		int result = linearSearch(array, 35);

		if (result == -1) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element found at index " + result);
		}
	}
}
