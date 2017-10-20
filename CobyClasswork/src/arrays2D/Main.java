package arrays2D;

public class Main {
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * increases the element in arr at index psn
	 * and decreases the elements at psn-1 and psn+1
	 * if they exit
	 * 
	 * THIS idea is another major topic in AP CSA
	 * It is the idea of avoiding an ArrayIndexOutOfBounds exceptions
	 * @param arr
	 * @param psn
	 */
	public static void changeNeigbors(int[] arr, int psn) {
		arr[psn] = arr[psn]+1;
		if(psn>0) {
			arr[psn-1] = arr[psn-1]-1;
		}
		if(psn<arr.length-1) {
			arr[psn+1] = arr[psn+1]+1;
		}
	}
}
