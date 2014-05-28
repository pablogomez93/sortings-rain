package com.pabgomez93.sortingsRain.Sortings;

import java.util.Arrays;
import java.util.Comparator;

import com.pabgomez93.sortingsRain.Sorting;

public class MergeSort extends Sorting {
	
	public static void sort(Integer[] arr) {
		mergeSort(arr, STANDARD_INT_COMPARATOR);
	}
	
	public static void reverse_sort(Integer[] arr) {
		mergeSort(arr, STANDARD_INT_COMPARATOR.reversed());
	}
	
	public static <T> void sort(T[] arr, Comparator<T> c) {
		mergeSort(arr, c);
	}
	
	private static <T> void mergeSort(T[] arr, Comparator<T> c) {
		int n = arr.length;
		if(n < 2) return;
		
		T[] middle_1 = Arrays.copyOfRange(arr, 0, n/2);
		T[] middle_2 = Arrays.copyOfRange(arr, n/2, n);
		
		mergeSort(middle_1, c);
		mergeSort(middle_2, c);
		
		int it_1 = 0;
		int it_2 = 0;

		for (int i = 0; i < n; i++) {
			T selected;
			
			if(it_1 >= middle_1.length)
				selected = middle_2[it_2++];
			else if(it_2 >= middle_2.length)
				selected = middle_1[it_1++];
			
			else if(c.compare(middle_1[it_1], middle_2[it_2]) < 0)
				selected = middle_1[it_1++];	
			else
				selected = middle_2[it_2++];

			arr[i] = selected;
		}
		
	}

}
