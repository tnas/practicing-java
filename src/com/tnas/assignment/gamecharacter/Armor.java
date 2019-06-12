package com.tnas.assignment.gamecharacter;

public enum Armor {
	
	STEEL_PLATE("Steel Plate"),
	CHAIN_MAIL("Chain Mail"),
	LEATHER("Leather"),
	ROBE("Robe");
	
	private final String name;
	
	private Armor(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static Armor fromInteger(int armorCode) {
		return values()[armorCode];
	}
}
