package com.pabgomez93.sortingsRain.Sortings;

import com.pabgomez93.sortingsRain.Sorting;

import java.util.ArrayList;
import java.util.List;

public class RadixSort extends Sorting {

    private static ArrayList<ArrayList<Integer>> digits = new ArrayList<ArrayList<Integer>>(){{
        for (int i = 1; i < 10; i++) add(new ArrayList<Integer>());
    }};

	private static final int getMaxDigitLength(int[] arr) {
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			String num = String.valueOf(arr[i]);

			if(num.length() > max)
				max = num.length();
		}

		return max;
	}

	public static final void sort(int[] arr) {
		int n = arr.length;
		int maxDigitLength = getMaxDigitLength(arr);

		for(int d = 0; d < maxDigitLength; d++) {

			for(int i = 0; i < n; i++) {
				int number = arr[i];
				int digit = getDigit(d, number);

				digits.get(digit).add(number);
			}

			int arrayIndex = 0;
			for (int x = 0; x < digits.size(); x++) {
				for(int y = 0; y < digits.get(x).size(); y++) {
					arr[arrayIndex++] = digits.get(x).get(y);
				}
				digits.get(x).clear();
			}

		}
	}

	private static int getDigit(int digitIndex, int number) {
		String num = String.valueOf(number);
		int length = num.length();

		if(digitIndex >= length)
			return 0;

		int inOrderDigit = length - 1 - digitIndex;

		num = num.substring(inOrderDigit, inOrderDigit+1);
		return Integer.valueOf(num);
	}

}
