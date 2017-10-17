package arrays;

import java.util.Arrays;

public class ArraysMain {

	
	private String[] testArray;
	private int[] intRay;
	
	
	public ArraysMain() {
//		intRay = new int[10];
//		int[] test1 = {1,2,6,7,8,9,10,11};
		int[] randomRolls = new int[1000];
		populate(randomRolls);
//		populate(intRay);
//		checkOccurences(intRay,3,18);
//		populate1ToN(intRay);
//		swap(intRay, 0, 1);
//		shuffle(intRay);
//		reverseOrder(intRay);
//		frontToBack(intRay);
//		numbersLessThan(intRay,5);
		//Arrays is a Utility class included in Java for formatting output
//		System.out.println(Arrays.toString(intRay));
//		System.out.println(numbersLessThan(intRay,5));
		int[] result = longestConsecSeqAndPos(randomRolls);
		System.out.println("The longest sequence of dice rolls is " + result[0] + " it happened on the " + (result[1]+1) + "th roll. Starting with a roll of "+randomRolls[result[1]] + ".");
	}
	
	/**
	 * returns two pieces of information data[0] which is the length of the longest sequence
	 * and data[1] which is the position where the sequence begins
	 * @param arr
	 * @return
	 */
	public int[] longestConsecSeqAndPos(int[] arr) {
		int[] data = new int[2];
		data[0] = longestConsecutiveSequence(arr);
		data[1] = ;
		return data;
	}
	
	
	
	private int[] reverseOrder(int[] arr) {
		int[] reversed = new int[arr.length];
		for(int i = 0; i < arr.length;i++) {
			reversed[i] = arr[arr.length-1-i];
		}
		System.out.println(Arrays.toString(reversed));
		return reversed;
	}

	/*
	 * returns the length of the longest sequence of consecutive integers
	 * For example, LCS({1,2,3,7,8,9,10}) returns 4 because 7,8,9,10
	 */
	public int longestConsecutiveSequence(int[] arr) {
		int count = 1;
		int temp = 1;
		for(int i = 0; i < arr.length-1; i++) {
			if(isConsecutive(arr,i)) {
				count++;
			}
			else {
				if(count > temp) {
					temp = count;
					count = 1;
					
				}
			}
		}
		return temp;
	}
	 
	public boolean isConsecutive(int[] arr, int pos) {
		if(pos == 0) {
			return true;
		}
		if(arr[pos] + 1 == arr[pos]) {
			return true;
		}
		return false;
	}
	
	/*
	 * remove the element at index 0, push every other element up by 1
	 * Put the element that was at zero at the end
	 * @param array
	 */
	public void frontToBack(int[] arr) {
		int placeholder = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i-1] = arr[i];
		}
		arr[arr.length-1] = placeholder;
	}
	
	/*
	 * moves the front to the back repeatedly, exactly n times
	 */
	public void cycleThrough(int[] arr,int n) {
		for(int i = 0; i < n;i++) {
			frontToBack(arr);
		}
	}
	
	private int numbersLessThan(int[] arr, int a) {
		int counter = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < a) {
				counter++;
			}
		}
		return counter;
	}
	
	
	private void shuffle(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			swap(arr, (int) (Math.random()*arr.length), (int) (Math.random()*arr.length));
		}
	}
	

	private void swap(int[] arr, int f, int s) {
		int first = arr[f];
		arr[f] = arr[s];
		arr[s] = first;
	}
	

	private void populate1ToN(int[] intRay2) {
		for(int i = 0; i < intRay2.length; i++) {
			intRay[i] = i + 1;
		}
	}
	

	private void checkOccurences(int[] arr, int start, int end) {
		int[] counter = new int[end-start+1];
		for(int value: arr) {
			counter[value-start]++;
		}
		for(int i = 0; i < counter.length; i++) {
			System.out.println("A "+(start+i)+" was rolled "+counter[i]+" times.");
		}
	}
	

	private void populate(int[] intRay) {
		for(int i = 0; i < intRay.length; i++) {
			intRay[i] = diceRoll(2);
		}
	}
	

	public void notes() {
		//1. collection of primitives or objects
		//SPECIAL NOTE: This is the ONLY collection of primitives
			
		//2. size cannot be modified
				
		/*
		 * 3. Elements of an array are REFERENCES to objects
		 * In other words, changing an element of an array changes
		 * the REFERENCE, not the object
		 */
				
		//________________________________________________
				
		// There are two types of constructors, the first we've seen already
		int[] firstType = {3,14,-9,10};
		//this constructor can only be used at the declaration. Error:
		//firstType = {12,13,14,15};
				
		//the 2nd type:
		testArray = new String[50];
		/*SPECIAL NOTE: for primitive arrays, when they are instantiated
		they are automatically populated with zeroes. This is not the case with
		Object arrays, which are populated with 'null'
		*/
				
		//standard 'for' loop
		for(int i = 0; i < testArray.length; i++) {
			System.out.println("The #" + i + " item is:" + testArray[i]);
		}
			
		//for each loops ( useful only when you don't need to keep track of an index
		for(String value:testArray) {
			//"for each int in testArray.."
			System.out.println(value);
		}
	}
	
	
	public static void main (String[] args) {
		ArraysMain arrayPractice = new ArraysMain();
	}
	
	/**
	 * Returns the result from rolling "numberOfDice" dice.
	 * @param numberOfDice
	 * @return
	 */
	
	
	public int diceRoll(int numberOfDice) {
		int count = 0;
		for(int i = 0; i < numberOfDice; i++) {
			count += 1 + (int) (Math.random() * 6);
		}
		return count;
	}
}
