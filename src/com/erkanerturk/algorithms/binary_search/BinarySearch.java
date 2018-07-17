package com.erkanerturk.algorithms.binary_search;

public class BinarySearch {

	// Array must be sorted from small to large
	// Time complexity O(log n)

	private static int binarySearch(int[] array, int value) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			System.out.printf("Left: " + left + " Mid: " + mid + " Right: " + right + "\n");

			if (value == array[mid]) {
				return mid;
			}

			if (value < array[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int result = binarySearch(array, 3);

		if (result == -1) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element found at index " + result);
		}
	}
}
