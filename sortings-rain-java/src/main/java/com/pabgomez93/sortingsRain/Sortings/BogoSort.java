package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;

import java.util.Comparator;
import java.util.Random;

public class BogoSort extends Sorting {
	
	public static void sort(Integer[] arr) {
		bogoSort(arr, STANDARD_INT_COMPARATOR);
	}
	
	public static void reverse_sort(Integer[] arr) {
		bogoSort(arr, STANDARD_INT_COMPARATOR.reversed());
	}
	
	public static <T> void sort(T[] arr, Comparator<T> c) {
		bogoSort(arr, c);
	}

	/**
     * BogoSort is also known as "StupidSort"
     */
	private static final <T> void bogoSort(T[] arr,  Comparator<T> c) {
        while(!sorted(arr, c))
        	shuffle(arr);
	}
	
	private static final <T> void shuffle(T[]arr) {
		Random r = new Random();
        int n = arr.length;
        
		for (int i = 0; i < n; i++)
            swap(arr, i, r.nextInt(n-i) + i);
	}

    private static <T> boolean sorted(T[] arr, Comparator<T> c) {
        for (int i = 0; i < arr.length - 1; i++)
            if(c.compare(arr[i+1], arr[i]) < 0)
                return false;

        return true;
    }

}
