package textbattle;

public class Item {
	public String type;

	public Item(String type) {
		this.type = type;
	}

	public Item() {
		this.type = "empty slot";
	}

	public String toString() {
		return (type);
	}

	public int getCost() {
		if (type == "Health Potion") {
			return 15;
		} else if (type == "Strength Potion") {
			return 10;
		} else if (type == "Force Potion") {
			return 20;
		} else if (type == "Increase Force Potion") {
			return 5;
		} else {
			return 0;
		}
	}

	public String getType() {
		return type;
	}

	public void changeType(String newType) {
		type = newType;
	}

	public void use(Player character, Monster enemy) {
		if (type == "Health Potion") {
			character.increaseHealth(20);
			System.out.println(character.getName() + " now has " + character.getCurrentHealth() + " health.");
		} else if (type == "Strength Potion") {
			character.increaseMaxDmg(10);
			character.increaseMinDmg(10);
			System.out.println(character.getName() + " can do more damage");
		} else if (type == "Force Potion") {
			int enemyDmgAmmount = 5;
			character.increaseHealth(5);
			character.increaseMaxDmg(5);
			character.increaseMinDmg(5);
			enemy.recieve_dmg(enemyDmgAmmount);
			System.out.println(character.getName() + " now has " + character.getCurrentHealth()
					+ " health, can do more damage, and has done " + enemyDmgAmmount + " damage to " + enemy.getType());
		} else if (type == "Increase Force Potion") {
			if (character instanceof Jedi){
				Jedi newCharacter = (Jedi)character;
				newCharacter.increaseForce(5);
				System.out.println(character.getName() + " now has " + newCharacter.getForce() + " force.");
			}
		} else {
			System.out.println("That inventory slot is empty!");
		}
	}
}
