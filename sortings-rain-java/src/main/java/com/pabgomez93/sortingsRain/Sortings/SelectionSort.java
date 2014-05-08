package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;

public class SelectionSort extends Sorting {
	
	public static final void sort(int[] arr) {
		int n = arr.length;
		
		for(int actualIndex = 0; actualIndex < n; actualIndex++){
			int smaller = actualIndex;
			for (int i = actualIndex; i < n; i++)
				if(arr[i] < arr[smaller])
					smaller = i;
					
			swap(arr, actualIndex, smaller);
		}
	}

}
