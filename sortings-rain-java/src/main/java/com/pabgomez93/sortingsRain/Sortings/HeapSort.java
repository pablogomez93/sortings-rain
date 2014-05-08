package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;

public class HeapSort extends Sorting {

	public static void sort(int[] arr) {
		for(int i = arr.length; i > 0; i--) {
			to_max_heap(arr, i);
			swap(arr, i-1, 0);
		}	
	}
	
	private static void to_max_heap(int[] arr, int n) {
		int middle = n>>1;
		
		for (int i = middle - 1; i >= 0; i--)	max_heapify(arr, i, n);
	}
	
	private static void max_heapify(int[] arr, int i, int n) {
		int l = left_child(i), r = right_child(i), max = i;

		if(l < n && arr[i] < arr[l]) 	max = l;
		if(r < n && arr[max] < arr[r])	max = r;
		
		if(max != i) {
			swap(arr, max, i);
			max_heapify(arr, max, n);
		}
	}
	
	private static int left_child(int i) { return (i<<1) + 1;}
	private static int right_child(int i) { return (i<<1) + 2;}
	
}
