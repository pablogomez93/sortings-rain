package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;

public class BubbleSort extends Sorting {
	
	public static final void sort(int[] arr) {
		int n = arr.length;
		boolean change = true;
		
		while(change) {
			change = false;
			
			for (int i = 0; i < n-1; i++) {
				if(arr[i] > arr[i+1]) {
					swap(arr, i , i+1);
					change = true;
				}
			}
		}
	}
}
