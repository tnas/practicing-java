package com.tnas.assignment.game.character;

public enum Weapon {
	
	SWORD("Sword"),
	SHORT_SWORD("Short sword"),
	SCIMITAR("Scimitar"),
	DAGGER("Dagger");
	
	private final String name;
	
	private Weapon(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static Weapon fromInteger(int weaponCode) {
		return values()[weaponCode];
	}
}
