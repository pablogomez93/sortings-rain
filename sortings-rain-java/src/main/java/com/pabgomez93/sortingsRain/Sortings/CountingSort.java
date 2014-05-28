package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;

public class CountingSort extends Sorting {
	
	public static void sort(Integer[] arr) {
		countingSort(arr, false);
	}
	
	public static void reverse_sort(Integer[] arr) {
		countingSort(arr, true);
	}

	public static void countingSort(Integer[] arr, boolean reversed) {
		//Supports non negative keys in the array
		int n = arr.length;
		if(n == 0) return;
		
		int bigger = arr[0];
		int smaller = arr[0];
		for (int i = 0; i < n; i++) {
			if(arr[i] > bigger)	bigger = arr[i];
			if(arr[i] < smaller)smaller = arr[i];
		}

		int[] countings = new int[bigger + 1];
		for (int i = 0; i < n; i++)
			countings[arr[i] - smaller]++;
		
		for (int i = 0, writing = 0; i < countings.length; i++) {
			int counting = countings[i];
			while(0 < counting--)
				if(reversed)	arr[(n-1) - (writing++)] = i+smaller;
				else			arr[writing++] = i+smaller;
		}
	}
	
}
