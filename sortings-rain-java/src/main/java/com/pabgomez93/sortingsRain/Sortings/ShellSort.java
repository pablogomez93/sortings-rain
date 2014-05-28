package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;
import java.util.Comparator;

public class ShellSort extends Sorting {

	public static void sort(Integer[] arr) {
		shellSort(arr, STANDARD_INT_COMPARATOR);
	}
	
	public static void reverse_sort(Integer[] arr) {
		shellSort(arr, STANDARD_INT_COMPARATOR.reversed());
	}
	
	public static <T> void sort(T[] arr, Comparator<T> c) {
		shellSort(arr, c);
	}
	
	private static final <T> void shellSort(T[] arr, Comparator<T> c) {
		int n = arr.length;
		int[] gaps = getGaps(n);

		for (int gap : gaps)
			for(int currentIndex = gap; currentIndex < n; currentIndex += gap)
				for (int i = currentIndex; i >= gap && c.compare(arr[i], arr[i-gap]) < 0; i -= gap)
					swap(arr, i, i-gap);

		//In case of missing gap of value 1
		if(gaps[n-1] > 1) {
			InsertionSort.sort(arr, c);
		}
	}

	private static final int[] getGaps(int n) {
		//Any gap list must include the gap 1 to finally sort the array
		int[] gaps = {8, 4, 2, 1};
		return gaps;
	}


}
