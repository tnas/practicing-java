package com.tnas.assignment.game.character;

import java.util.Arrays;
import java.util.List;

public enum Character {

	MAGIC_USER("Magic User", Arrays.asList(Armor.ROBE), Arrays.asList(Weapon.DAGGER)),
	FIGTHER("Fighter", Arrays.asList(Armor.values()), Arrays.asList(Weapon.values())),
	THIEF("Thief", Arrays.asList(Armor.LEATHER, Armor.ROBE), Arrays.asList(Weapon.values())),
	DRUID("Druid", Arrays.asList(Armor.CHAIN_MAIL, Armor.LEATHER, Armor.ROBE), Arrays.asList(Weapon.values()));
	
	private final String name;
	private final List<Armor> armors;
	private final List<Weapon> weapons;
	
	private Character(String name, List<Armor> armors, List<Weapon> weapons) {
		this.name = name;
		this.armors = armors;
		this.weapons = weapons;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean isAcceptedArmor(Armor armor) {
		return this.armors.contains(armor);
	}
	
	public boolean isAcceptedWeapon(Weapon weapon) {
		return this.weapons.contains(weapon);
	}
	
	public static Character fromInteger(int characterCode) {
		return values()[characterCode];
	}
}
