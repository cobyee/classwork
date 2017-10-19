package arrays;

public class Person {
	
	public static final String[] FIRST_START = {"Chr","M","L","Gr","Ph","B","Th"};
	public static final String[] FIRST_MIDDLE = {"isti","icha","era","eta","ala","ina","ara"};
	public static final String[] FIRST_END = {"","na","n","r","tian","s","rs","mp","les"};
	
	public static final String[] LAST_START = {"Tr","Br","L","Gr","Sh","B","Th"};
	public static final String[] LAST_MIDDLE = {"om","o","an","ola","et","e","is"};
	public static final String[] LAST_END = {"","son","ers","rian","ston","ck","sk"};
	
	
	private String firstName;
	private String lastName;
	private Borough home;
	private Hobby hobby;
	private Person[] friends;
	
	public Person(String first, String last, Borough home){
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		this.hobby = Hobby.randomHobby();
		friends = new Person[3];
	}
	
	/**
	 * chooses friends from People based on who is of same class as this
	 * instance and who has the same hobbies
	 * @param people
	 */
	public void mingle(Person[] people) {
		System.out.println("I am in the class " + this.getClass() + " and my hobby is " + this.hobby);
		for(Person p: people) {
			if(p != this) {
				//reassign p to the better of the two friends
				//best friend or p
				p = betterFriend(p,friends[0]);
				
				addFriendToFirstPlace(p);
			}
		}
	}
	
	private Person betterFriend(Person p, Person q) {
		//having a friend is better than having no friends at all
		if(p == null) {
			return q;
		}
		if(q == null) {
			return p;
		}
		if(this.hobby == p.hobby) {
			return p;
		}
		if(p.getClass() == this.getClass() && q.getClass() == this.getClass()) {
			if(this.hobby == q.hobby) {
				return q;
			}
			if(p.getClass() == this.getClass()) {
				return p;
			}
		}
		if(q.getClass() == this.getClass()) {
			return q;
		}
		//if none of these are true, just take p
		return p;
	}

	public void printFriends() {
		System.out.println("My name is " + firstName + " " + lastName + " and these are my friends:");
		for(Person f: friends) {
			if(f != null) {
				System.out.println(f);
			}
		}
	}
	
	/**
	 * Moves all Person in friends back one index and puts p at index 0
	 * @param p
	 */
	public void addFriendToFirstPlace(Person p) {
		//this for loop goes backward..
		for(int i = friends.length-1; i > 0; i--) {
			//..and moves each friend back a position
			friends[i] = friends[i-1];
		}
		friends[0] = p;
	}
	
	public String toString() {
		return "My name is " + firstName + " " + lastName + " and I live in " + home + ".";
	}
	
}
