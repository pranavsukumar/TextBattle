package textbattle;

public class Tropper extends Player{
	private int sheildStrength;
	
	public Tropper(String name, int health, int maxDMG, int minDMG, Item[] Inventory) {
		super(name, health, maxDMG, minDMG, Inventory);
		sheildStrength = 20;
	}
	
	public void recieveDamage(int damage){
		super.recieve_dmg(damage, sheildStrength);
	}

}
