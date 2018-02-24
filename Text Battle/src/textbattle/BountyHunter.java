package textbattle;

public class BountyHunter extends Player {
	private double critChance;

	public BountyHunter(String name, int health, int maxDMG, int minDMG, Item[] Inventory) {
		super(name, health, maxDMG, minDMG, Inventory);
		critChance = 10;
	}

	public double getCritChance() {
		return critChance;
	}

	public void attack(Monster enemy) {
		double percent = (int) (Math.random() * (100) + 1);
		int damage = (int) (Math.random() * (25 - 10 + 1) + 10);

		if (percent < critChance) {
			super.attack(enemy, (damage * 2));
		} else {
			super.attack(enemy);
		}
	}

}
