package Search;

public class ArtificialForLoop {

	public static void main(String[] args) {
		forLoop(100, new Action() {
			
			int count = 1;
			
			public void act() {
				System.out.println(count+". Hello world!");
				count++;
			}
		});
	}
	
	public static void forLoop(int n, Action a) {
		if(n == 1) {
			a.act();
		}else {
			a.act();
			forLoop(n-1,a);
		}
	}
	
}
