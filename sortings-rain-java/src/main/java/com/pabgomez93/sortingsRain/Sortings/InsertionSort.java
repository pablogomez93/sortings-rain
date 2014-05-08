package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;

public class InsertionSort extends Sorting {

	public static final void sort(int[] arr) {
		int n = arr.length;
		
		for(int actualIndex = 1; actualIndex < n; actualIndex++)
			for (int i = actualIndex; i >= 1 && arr[i-1] > arr[i]; i--)
				swap(arr, i, i-1);	
	}

}
