package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;
import java.util.Comparator;

public class HeapSort extends Sorting {
	
	public static void sort(Integer[] arr) {
		heapSort(arr, STANDARD_INT_COMPARATOR);
	}
	
	public static void reverse_sort(Integer[] arr) {
		heapSort(arr, STANDARD_INT_COMPARATOR.reversed());
	}
	
	public static <T> void sort(T[] arr, Comparator<T> c) {
		heapSort(arr, c);
	}

	private static <T> void heapSort(T[] arr, Comparator<T> c) {
		for(int i = arr.length; i > 0; i--) {
			to_max_heap(arr, i, c);
			swap(arr, i-1, 0);
		}	
	}
	
	private static <T> void to_max_heap(T[] arr, int n, Comparator<T> c) {
		int middle = n>>1;
		
		for (int i = middle - 1; i >= 0; i--)	max_heapify(arr, i, n, c);
	}
	
	private static <T> void max_heapify(T[] arr, int i, int n, Comparator<T> c) {
		int l = left_child(i), r = right_child(i), max = i;

		if(l < n && c.compare(arr[i], arr[l]) < 0) 	max = l;
		if(r < n && c.compare(arr[max], arr[r]) < 0)	max = r;
		
		if(max != i) {
			swap(arr, max, i);
			max_heapify(arr, max, n, c);
		}
	}
	
	private static int left_child(int i) { return (i<<1) + 1;}
	private static int right_child(int i) { return (i<<1) + 2;}
	
}
