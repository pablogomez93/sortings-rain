package com.pabgomez93.sortingsRain;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.junit.Test;
import org.reflections.Reflections;

public class SortingTest {
	
	private final Random generator = new Random();
	private final Reflections reflections = new Reflections("com.pabgomez93.sortingsRain.Sortings");
	private final Iterator<Class<? extends Sorting>> it = reflections.getSubTypesOf(Sorting.class).iterator();
	
	//I excluded BogoSort from the tests because it may take giant times to finish.
	//And excluded QuickSort 'cause it isn't my impl, and only accepts array of integers
	private final Set<Class<?>> excluded_from_test_of_integers = new HashSet<Class<?>>(){
		private static final long serialVersionUID = 1L; {
			add(com.pabgomez93.sortingsRain.Sortings.BogoSort.class);
			add(com.pabgomez93.sortingsRain.Sortings.QuickSort.class);
		}
	};
	
	private final Set<Class<?>> excluded_from_test_of_custom_type = new HashSet<Class<?>>(){
		private static final long serialVersionUID = 1L; {
			add(com.pabgomez93.sortingsRain.Sortings.BogoSort.class);
			add(com.pabgomez93.sortingsRain.Sortings.CountingSort.class);
			add(com.pabgomez93.sortingsRain.Sortings.RadixSort.class);
		}
	};
	
	protected static class PersonComparator implements Comparator<Person> {
		public int compare(Person p1, Person p2) {
	        return ((Integer) p1.getAge()).compareTo((Integer) p2.getAge());
	     }
	}
	private PersonComparator personComparator = new PersonComparator();
	
	@Test
	public void emptyArray_shouldReturn_empty() {
		//Array of integers test
		Integer[] arr = {};
		Integer[] expected = arr.clone();
	
		equalityForEveryIntegerSorting(arr, expected);
		
		//Array of custom type test
		Person[] arr_b = {};
		Person[] expected_b = arr_b.clone();
		
		equalityForEveryCustomTypeSorting(arr_b, expected_b, personComparator);
	}
	
	@Test
	public void oneElementArray_shouldReturn_sameElement() {
		//Array of integers test
		Integer[] arr = {5};
		Integer[] expected = arr.clone();
		
		equalityForEveryIntegerSorting(arr, expected);
		
		//Array of custom type test
		Person[] arr_b = {new Person(7, "Rambo")};
		Person[] expected_b = arr_b.clone();
		
		equalityForEveryCustomTypeSorting(arr_b, expected_b, personComparator);
	}
	
	@Test
	public void repeatedElementsArray_shouldReturn_samesElements() {
		//Array of integers test
		Integer[] arr = {10,10,10,10,10,10};
		Integer[] expected = arr.clone();
		
		equalityForEveryIntegerSorting(arr, expected);
		
		//Array of custom type test
		Person[] arr_b = {new Person(7, "Rambo"), new Person(7, "Rambo"), new Person(7, "Rambo"), new Person(7, "Rambo")};
		Person[] expected_b = arr_b.clone();
		
		equalityForEveryCustomTypeSorting(arr_b, expected_b, personComparator);
	}
	
	@Test
	public void littleArray_shouldReturn_littleArraySorted() {
		//Array of integers test
		Integer[] arr = {10, 1, 6, 8, 9, 10, 4};
		Integer[] expected = arr.clone();
		Arrays.sort(expected);
			
		equalityForEveryIntegerSorting(arr, expected);
		
		//Array of custom type test
		Person[] arr_b = {new Person(7, "Rambo"), new Person(78, "Rambo"), new Person(19, "Rambo"), new Person(1, "Rambo")};
		Person[] expected_b = arr_b.clone();
		Arrays.sort(expected_b, personComparator);
		
		equalityForEveryCustomTypeSorting(arr_b, expected_b, personComparator);
	}
	
	@Test
	public void heavyArray_shouldReturn_heavyArraySorted() {
		//Array of integers test
		Integer[] arr = new Integer[1000];
		fill_array_of_integers(arr, 10000);
		
		Integer[] expected = arr.clone();
		Arrays.sort(expected);

		equalityForEveryIntegerSorting(arr, expected);
		
		//Array of custom type test
		Person[] arr_b = new Person[1000];
		fill_array_of_persons(arr_b);
		
		Person[] expected_b = arr_b.clone();
		Arrays.sort(expected_b, personComparator);

		equalityForEveryCustomTypeSorting(arr_b, expected_b, personComparator);
	}
	
	
	@Test
	public void heavyArrayReversed_shouldReturn_heavyArraySorted() {
		//Array of integers test
		Integer[] arr = new Integer[1000];
		fill_array_of_integers(arr, 10000);
		Arrays.sort(arr);
		
		Integer[] expected = arr.clone();
		reverse_array(arr);
	
		equalityForEveryIntegerSorting(arr, expected);
		
		//Array of custom type test
		Person[] arr_b = new Person[1000];
		fill_array_of_persons(arr_b);
		Arrays.sort(arr_b, personComparator);
		
		Person[] expected_b = arr_b.clone();
		reverse_array(arr_b);
	
		equalityForEveryCustomTypeSorting(arr_b, expected_b, personComparator);
	}
	
	private void fill_array_of_integers(Integer[] arr, int max) {
		//The max is for coutingSort does not eat all your RAM.
		for(int i = 0; i < arr.length; i++)
			arr[i] = Math.abs(generator.nextInt() % max+1);
	}
	
	private void fill_array_of_persons(Person[] arr) {
		for(int i = 0; i < arr.length; i++)
			arr[i] = new Person(Math.abs(generator.nextInt()), "test");
	}
	
	private <T> void reverse_array(T[] arr) {
		for(int i = 0; i < arr.length / 2; i++) {
		    T temp = arr[i];
		    arr[i] = arr[arr.length - i - 1];
		    arr[arr.length - i - 1] = temp;
		}
	}
	
	private void equalityForEveryIntegerSorting(Integer[] arr, Integer[] expected) {
		Integer[] backUp_arr = arr.clone();
		Integer[] backUp_expected = expected.clone();
		
		while(it.hasNext()) {
			Class<?> sorting_class = it.next();
			if(excluded_from_test_of_integers.contains(sorting_class))
				continue;

			try{
				System.out.println("Starting test of integers array for: " + sorting_class.getName());
				
				//Get the methods to test
				Method standardSortMethod = sorting_class.getMethod("sort", Integer[].class);
				Method reverseSortMethod = sorting_class.getMethod("reverse_sort", Integer[].class);
				
				//Sort the arr array and compare with the expected
				System.out.println("Starting standard sort for: " + sorting_class.getName());
				standardSortMethod.invoke(null, (Object)arr);
				
				//Check equality with the expected
				assertArrayEquals(expected, arr);
			
				//Reverse the expected, apply the reverse_method to the array and compare themselves
				System.out.println("Starting reversed sort for: " + sorting_class.getName());
				reverse_array(expected);
				reverseSortMethod.invoke(null, (Object)arr);
				
				//Check equality with the expected reversed
				assertArrayEquals(expected, arr);
				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println(sorting_class.getName() + " failed.");
			} finally {
				//Restart initial state of the arrays passed by parameter
				arr = backUp_arr.clone();
				expected = backUp_expected.clone();
			}
		}	
    }
	
	private <T> void equalityForEveryCustomTypeSorting(T[] arr, T[] expected, Comparator<T> c) {
		T[] backUp_arr = arr.clone();
		T[] backUp_expected = expected.clone();
		
		while(it.hasNext()) {
			Class<?> sorting_class = it.next();
			if(excluded_from_test_of_custom_type.contains(sorting_class))
				continue;

			try{
				System.out.println("Starting test for custom type for : " + sorting_class.getName());
			
				//Get the methods to test
				Method customTypeSortMethod = sorting_class.getMethod("sort", Object.class, Comparator.class);

				//Sort the arr array and compare with the expected using the comparator
				System.out.println("Starting standard sort for: " + sorting_class.getName());
				customTypeSortMethod.invoke(null, (Object)arr, c);
				
				//Check equality with the expected
				assertArrayEquals(expected, arr);
				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println(sorting_class.getName() + " failed.");
			} finally {
				//Restart initial state of the arrays passed by parameter
				arr = backUp_arr.clone();
				expected = backUp_expected.clone();
			}
		}	
    }
	
}
