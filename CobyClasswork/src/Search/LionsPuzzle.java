
package Search;

public class LionsPuzzle {

	public static void main(String[] args) {
		int lions = 101;
		System.out.println(lions + " lions decide to eat the sheep? "+ eatSheepOrNot(lions));
	}

	private static boolean eatSheepOrNot(int lions) {
		if(lions == 1) {
			//there are no lions to eat you if you eat a sheep!
			return true;
		}else {
			//you would eat the sheep knowing the other lions don't eat the sheep
			return !eatSheepOrNot(lions-1);
		}
	}
	
}
