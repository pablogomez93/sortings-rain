package com.pabgomez93.sortingsRain.Sortings;

import java.util.Arrays;
import java.util.Iterator;

import com.pabgomez93.sortingsRain.Sorting;

public class MergeSort extends Sorting {
	
	public static void sort(int[] arr) {
		mergeSort(arr);
	}
	
	private static void mergeSort(int[] arr) {
		int n = arr.length;
		if(n < 2) return;
		
		int[] middle_1 = Arrays.copyOfRange(arr, 0, n/2);
		int[] middle_2 = Arrays.copyOfRange(arr, n/2, n);
		
		mergeSort(middle_1);
		mergeSort(middle_2);
		
		int it_1 = 0;
		int it_2 = 0;

		for (int i = 0; i < n; i++) {
			int selected;
			
			if(it_1 >= middle_1.length)
				selected = middle_2[it_2++];
			else if(it_2 >= middle_2.length)
				selected = middle_1[it_1++];
			else if(middle_1[it_1] < middle_2[it_2])
				selected = middle_1[it_1++];	
			else
				selected = middle_2[it_2++];

			arr[i] = selected;
		}
		
	}

}
