package textbattle;

public class Monster {
	private String type;
	private int health;
	private int min_dmg;
	private int max_dmg;

	public Monster(String type, int health, int min_dmg, int max_dmg) {
		this.type = type;
		this.health = health;
		this.min_dmg = min_dmg;
		this.max_dmg = max_dmg;
	}

	public String toString() {
		return type + " has " + health + " health";
	}

	// Getter Methods
	public String getType() {
		return type;
	}

	public int getHealth() {
		return health;
	}

	public int getMinDmg() {
		return min_dmg;
	}

	public int getMaxDmg() {
		return max_dmg;
	}
	// Do damage to player enemy by invoking player receive damage method
	public void attack(Player enemy) {
		int damage = (int) (Math.random() * (max_dmg - min_dmg + 1) + min_dmg);
		System.out.println("The " + type + " attacks " + enemy.getName() + " doing " + damage + " damage.");
		enemy.recieve_dmg(damage);
		
		
	}

	public void recieve_dmg(int damage) {
		health -= damage;
		if (health < 0) {
			health = 0;
		} else {
			System.out.println(type + " has " + health + " health left");
		}
	}
	
	public void recieve_dmg(int damage, int reflect, Player enemy) {
		health -= (damage);
		if (health < 0) {
			health = 0;
		} else {
			System.out.println(type + " has reflected "+ reflect + " damage.");
			enemy.recieve_dmg(reflect);
			System.out.println(type + " has " + health + " health left");
		}
	}
}
