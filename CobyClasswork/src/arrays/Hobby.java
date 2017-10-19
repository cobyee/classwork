package arrays;

public class Hobby extends Thing{

	public Hobby(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public static Hobby randomHobby() {
		Hobby[] someHobbies = {new Hobby("Programming"), new Hobby("Gaming"), new Hobby("Dancing"), new Hobby("Singing"), new Hobby("Watching TV")};
		return someHobbies[(int)(Math.random()*someHobbies.length)];
	}
	
	
	
}
