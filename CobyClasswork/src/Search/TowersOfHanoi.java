package Search;

public class TowersOfHanoi {
	
	public static void main(String[] args) {
		towerSolution(4,"Left","Middle","Right");
	}
	
	
	public static void towerSolution(int n, String start, String helper, String end) {
		if(n == 1) {
			System.out.println(start + " -> " + end);
		} else {
			towerSolution(n-1,start,end,helper);
			System.out.println(start + " -> " + end);
			towerSolution(n-1,helper,start,end);
		}
	}
}
