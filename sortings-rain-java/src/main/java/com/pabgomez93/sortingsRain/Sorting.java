package com.pabgomez93.sortingsRain;

import java.util.Comparator;

public class Sorting {
	
	protected static class IntegerComparator implements Comparator<Integer> {
		public int compare(Integer c1, Integer c2) {
	         return c1.compareTo(c2);
	     }
	 }
	
	protected static Comparator<Integer> STANDARD_INT_COMPARATOR = new IntegerComparator();

	protected static final <T> void swap(T[] arr, int a, int b) {
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	};
	
}
