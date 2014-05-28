package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;
import java.util.Comparator;

public class InsertionSort extends Sorting {

	public static void sort(Integer[] arr) {
		insertionSort(arr, STANDARD_INT_COMPARATOR);
	}
	
	public static void reverse_sort(Integer[] arr) {
		insertionSort(arr, STANDARD_INT_COMPARATOR.reversed());
	}
	
	public static <T> void sort(T[] arr, Comparator<T> c) {
		insertionSort(arr, c);
	}
	
	private static final <T> void insertionSort(T[] arr, Comparator<T> c) {
		int n = arr.length;
		
		for(int actualIndex = 1; actualIndex < n; actualIndex++)
			for (int i = actualIndex; i >= 1 && c.compare(arr[i], arr[i-1]) < 0; i--)
				swap(arr, i, i-1);	
	}


}
