package textbattle;

import java.util.Scanner;

public class Battle {
	public static void main(String[] args) {
		gameLoop();

	}

	// Methods to use input and create game objects
	public static Player characterCreator(Scanner in) {
		String name;
		int type;
		Player userCharacter;

		Item[] bag = { new Item("Health Potion"), new Item("Strength Potion"), new Item("Force Potion"),
				new Item("Increase Force Potion") };
		System.out.print("Choose a name for your character: ");
		name = in.nextLine();
		System.out.print("Choose a class for your character (1 for Trooper; 2 for Bounty Hunter; 3 for Jedi): ");
		type = in.nextInt();
		if (type == 1) {
			userCharacter = new Tropper(name, 70, 20, 10, bag);
			System.out.println("You have chosen a Trooper!");
			return userCharacter;
		} else if (type == 2) {
			userCharacter = new BountyHunter(name, 60, 30, 15, bag);
			System.out.println("You have chosen a Bounty Hunter!");
			return userCharacter;
		} else if (type == 3) {
			userCharacter = new Jedi(name, 55, 35, 25, bag);
			System.out.println("You have chosen a Jedi!");
			return userCharacter;
		} else {
			userCharacter = new Player(name, 30, 35, 20, bag);
			System.out.println("You have chosen a generic player!");
			return userCharacter;
		}

	}

	public static Monster monsterCreator(Scanner in) {
		String[] arrayOfMonsterTypes = { "Storm Trooper", "Darth Vader", "Bobba Fett" };
		int randomNum = (int) (Math.random() * (3));
		String typeOfMonster = arrayOfMonsterTypes[randomNum];
		Monster cpuMonster = new Monster(typeOfMonster, 70, 25, 15);
		if (typeOfMonster.equals("Darth Vader")) {
			cpuMonster = new Sith(typeOfMonster, 70, 25, 15);
		}
		return cpuMonster;

	}

	// Methods for player and cpu turns
	public static void playerTurn(Scanner in, Player userCharacter, Monster cpuMonster) {
		userCharacter.displayInventory();
		System.out.println("\nType an inventory slot number or enter to attack!");
		String isAttacking = in.nextLine();
		if (isAttacking.equals("")) {
			userCharacter.attack(cpuMonster);
		} else {
			for (int i = 1; i <= userCharacter.getInventoryLength(); i++) {
				if (Integer.parseInt(isAttacking) == (i)) {
					userCharacter.use_item(i - 1, cpuMonster);
				}
			}
		}
	}

	public static void monsterTurn(Scanner in, Player userCharacter, Monster cpuMonster) {
		cpuMonster.attack(userCharacter);

	}

	public static void gameLoop() {
		// Get input and create player and monster objects
		Scanner in = new Scanner(System.in);
		Player character = characterCreator(in);
		System.out.println(character + "\n");
		Monster cpuMonster = monsterCreator(in);
		System.out.println(character.getName() + " has encountered a " + cpuMonster.getType() + "!");
		System.out.println(cpuMonster);
		int roundNum = 1;
		in.nextLine();
		// Loop until a character dies
		while (character.getCurrentHealth() > 0 && cpuMonster.getHealth() > 0) {
			System.out.println(
					"\n++++++++++++++++++++++++++++++++++ Round " + roundNum + " ++++++++++++++++++++++++++++++++++\n");
			playerTurn(in, character, cpuMonster);
			System.out.println();
			// Make sure to account for character dying in between turns
			if (cpuMonster.getHealth() == 0) {
				break;
			} else {
				monsterTurn(in, character, cpuMonster);
				roundNum++;
			}

		}
		if (character.getCurrentHealth() == 0) {
			System.out.println("The " + cpuMonster.getType() + " has defeated " + character.getName());

		} else {
			System.out.println(character.getName() + " has defeated the " + cpuMonster.getType());
			int ammountGoldGained = (int) (20 + Math.random() * 21);
			character.addGold(ammountGoldGained);
			System.out.println(character.getName() + " gains " + ammountGoldGained + " gold");
			System.out.println(character.getName() + " has " + character.getGold() + " gold");
		}
	}
}
