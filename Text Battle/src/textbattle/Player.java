package textbattle;

public class Player {
	private String name;
	private int maxHealth, currentHealth, min_dmg, max_dmg, gold;
	private Item[] Inventory;

	public Player(String name, int initialHealth, int max_dmg, int min_dmg, Item[] Inventory) {
		this.name = name;
		this.maxHealth = initialHealth;
		this.currentHealth = initialHealth;
		this.min_dmg = min_dmg;
		this.max_dmg = max_dmg;
		this.gold = 0;
		this.Inventory = Inventory;
	}

	public String toString() {
		return name + " has " + currentHealth + " health";
	}

	// Getter Methods
	public String getName() {
		return name;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public int getMinDmg() {
		return min_dmg;
	}

	public int getMaxDmg() {
		return max_dmg;
	}

	public int getInventoryLength() {
		return Inventory.length;
	}

	// Do damage to monster enemy by invoking monster receive damage method
	public void attack(Monster enemy) {
		int damage = (int) (Math.random() * (max_dmg - min_dmg + 1) + min_dmg);
		System.out.println(name + " attacks " + enemy.getType() + " doing " + damage + " damage.");
		if (enemy.getHealth() > damage) {
			if (enemy.getType().equals("Darth Vader")){
				enemy.recieve_dmg(damage, 5, this);
			}
			else{
				enemy.recieve_dmg(damage);
			}
		}
		// Make sure that prints different message if monster is dead
		else {
			System.out.println("The " + enemy.getType() + " is dead.");
			enemy.recieve_dmg(damage);
		}
	}

	public void attack(Monster enemy, int damage) {
		System.out.println(name + " attacks " + enemy.getType() + " doing " + damage + " damage.");
		if (enemy.getHealth() > damage) {
			enemy.recieve_dmg(damage);
		}
		// Make sure that prints different message if monster is dead
		else {
			System.out.println("The " + enemy.getType() + " is dead.");
			enemy.recieve_dmg(damage);
		}
	}

	public void recieve_dmg(int damage) {
		currentHealth -= damage;
		if (currentHealth < 0) {
			currentHealth = 0;
		} else {
			System.out.println(name + " has " + currentHealth + " health left");
		}

	}
	
	public void recieve_dmg(int damage, double sheildStrength) {
		int damageWithSheild = (int) (damage * ((100 - sheildStrength)/100.0));
		currentHealth -= (damageWithSheild);
		System.out.println(name + " blocks " + ((int)(damage * (sheildStrength)/100.0)));
		if (currentHealth < 0) {
			currentHealth = 0;
		} else {
			System.out.println(name + " has " + currentHealth + " health left");
		}

	}

	public void increaseHealth(int ammount) {
		currentHealth += ammount;
		if (currentHealth > maxHealth) {
			currentHealth = maxHealth;
		}
	}

	public void increaseMinDmg(int ammount) {
		min_dmg += ammount;
	}

	public void increaseMaxDmg(int ammount) {
		max_dmg += ammount;
	}

	public void addGold(int ammount) {
		gold += ammount;
	}

	public int getGold() {
		return gold;
	}

	public void displayInventory() {
		System.out.println("Your inventory holds");
		for (int i = 0; i < Inventory.length; i++) {
			System.out.print((i + 1) + ". " + Inventory[i] + "; ");
		}
	}

	public void buyitem(String itemChoice) {
		Item item;

		item = new Item(itemChoice);

		for (int i = 0; i < Inventory.length; i++) {
			if (Inventory[i].type == "empty slot") {
				if (gold > item.getCost()) {
					Inventory[i] = item;
					return;
				} else {
					System.out.println("Not enough gold!");
					return;
				}
			}
		}
		System.out.println("Not enough room!");
	}

	public void use_item(int indexChoice, Monster enemy) {
		Inventory[indexChoice].use(this, enemy);
		Inventory[indexChoice].changeType("empty slot");
	}

}
