package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;

import java.util.Random;

public class BogoSort extends Sorting {
    /**
     * BogoSort is also known as "StupidSort"
     */

	public static final void sort(int[] arr) {
        Random r = new Random();
        int n = arr.length;

		while(!sorted(arr))
            for (int i = 0; i < n; i++)
                swap(arr, i, r.nextInt(n-i) + i);

	}

    private static boolean sorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if(arr[i] > arr[i+1])
                return false;

        return true;
    }

}
