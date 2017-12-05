package Search;

public class FibbonacciNumber {
	
	public static void main(String[] args) {
		System.out.println(findNumber(10));
	}
	
	public static int findNumber(int n) {
		if(n <= 0) {
			return 0;
		}else {
			if(n == 1){
				return 1;
			}else {
				return findNumber(n -1) + findNumber(n-2);
			}
		}
	}
}
