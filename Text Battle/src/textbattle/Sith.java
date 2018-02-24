package textbattle;

public class Sith extends Monster{

	public Sith(String type, int health, int min_dmg, int max_dmg) {
		super(type, health, min_dmg, max_dmg);
	}
	public void recieve_dmg(int damage, int reflect, Player enemy) {
		super.recieve_dmg(damage, reflect, enemy);
	}

}
