package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;
import java.util.Comparator;

public class BubbleSort extends Sorting {
	
	public static void sort(Integer[] arr) {
		bubbleSort(arr, STANDARD_INT_COMPARATOR);
	}
	
	public static void reverse_sort(Integer[] arr) {
		bubbleSort(arr, STANDARD_INT_COMPARATOR.reversed());
	}
	
	public static <T> void sort(T[] arr, Comparator<T> c) {
		bubbleSort(arr, c);
	}
	
	private static final <T> void bubbleSort(T[] arr, Comparator<T> c) {
		int n = arr.length;
		boolean change = true;
		
		while(change) {
			change = false;
			
			for (int i = 0; i < n-1; i++) {
				if(c.compare(arr[i+1], arr[i]) < 0) {
					swap(arr, i , i+1);
					change = true;
				}
			}
		}
	}
}
