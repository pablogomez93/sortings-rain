package com.pabgomez93.sortingsRain.Sortings;

import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;
import com.pabgomez93.sortingsRain.Sorting;

public class QuickSort extends Sorting {
	
	/**
	 * 
	 * Ha! This is not my quicksort implementation ;).
	 * 
	 * To see mine, just check
	 * 		https://github.com/pablogomez93/Quicksort
	 * 
	 * While, enjoy Java's quicksort implementation ;)
	 * Java just do quicksort on array of ints :(
	 * 
	 */
	
	public static void sort(int[] arr) {
		quickSort(arr);
	}
	
	public static void reverse_sort(int[] arr) {
		// Java quicksort of int arrays does not support a comparator to make reversed_sorting :(
		// It supports a comparator just using mergeSort :(
		quickSort(arr);
		ArrayUtils.reverse(arr);
	}

	
	public static void quickSort(int[] arr) {
		Arrays.sort(arr);
	}

}
