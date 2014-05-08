package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;

public class CountingSort extends Sorting {

	public static void sort(int[] arr) {
		//Supports non negative keys in the array
		int n = arr.length;
		if(n == 0) return;
		
		int bigger = arr[0];
		for (int i = 0; i < n; i++)
			if(arr[i] > bigger)	bigger = arr[i];
	
		int[] countings = new int[bigger + 1];
		for (int i = 0; i < n; i++)
			countings[arr[i]]++;
		
		for (int i = 0, writing = 0; i < countings.length; i++) {
			int counting = countings[i];
			while(0 < counting--)
				arr[writing++] = i;
		}
	}
	
}
