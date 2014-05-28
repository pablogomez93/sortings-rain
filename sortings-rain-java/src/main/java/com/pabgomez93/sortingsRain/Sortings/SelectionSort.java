package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;
import java.util.Comparator;

public class SelectionSort extends Sorting {
	
	public static void sort(Integer[] arr) {
		selectionSort(arr, STANDARD_INT_COMPARATOR);
	}
	
	public static void reverse_sort(Integer[] arr) {
		selectionSort(arr, STANDARD_INT_COMPARATOR.reversed());
	}
	
	public static <T> void sort(T[] arr, Comparator<T> c) {
		selectionSort(arr, c);
	}
	
	public static final <T> void selectionSort(T[] arr, Comparator<T> c) {
		int n = arr.length;
		
		for(int actualIndex = 0; actualIndex < n; actualIndex++){
			int smaller = actualIndex;
			for (int i = actualIndex; i < n; i++)
				if(c.compare(arr[i], arr[smaller]) < 0)
					smaller = i;
					
			swap(arr, actualIndex, smaller);
		}
	}

}
