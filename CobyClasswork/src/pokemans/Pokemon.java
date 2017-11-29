package pokemans;

public class Pokemon {

	int level;
	int hp;
	String name;
	boolean poisoned;
	
	public Pokemon(String name, int level) {
		this.level = level;
		this.name = name;
		this.hp = 100;
		this.poisoned = false;
	}
	
	public void iChooseYou() {
		System.out.println(name + " " + name);
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setHP(int newHP) {
		this.hp = newHP;
	}
	
	void setPoisoned(boolean b) {
		this.poisoned = b;
	}
	
	public void lapse() {
		if(this.poisoned) {
			hp -= 15;
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void attack(Pokemon target, Attack attack){
		 if(Math.random() < .9){
			 attack.attack(target);
			 System.out.println("The attack hit");
		 }else{
			 System.out.println("The attack missed");
		 }
	}
	
	public void levelUp(Effect e) {
		this.level++;
		e.happens();
	}
	
	public void evolve(Pokemon previousPokemon, String newPokemon) {
		previousPokemon.setName(newPokemon);
	}
}
