package textbattle;

public class Jedi extends Player {

	private int force;

	public Jedi(String name, int health, int maxDMG, int minDMG, Item[] Inventory) {
		super(name, health, maxDMG, minDMG, Inventory);
		force = 5;
	}

	public int getForce() {
		return force;
	}
	public void increaseForce(int ammount) {
		force += ammount;
	}

	public void attack(Monster enemy) {
		if (force > 0) {
			super.attack(enemy);
			force--;
		} else {
			System.out.println("Not enough force!");
		}
	}
}
