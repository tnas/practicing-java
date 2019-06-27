package com.tnas.assignment.game.character;

import java.util.Arrays;
import java.util.Scanner;

public class GameCharacter {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter your name");
		String playerName = scanner.next();
		
		System.out.println(String.format("%s please select the character you wish to play", playerName));
		Arrays.asList(Character.values()).forEach(c -> {
			System.out.println(String.format("%d. %s", c.ordinal() + 1, c.getName()));
		});
		Character character = Character.fromInteger(scanner.nextInt() - 1);
		
		Armor armor;
		do {
			System.out.println(String.format("%s please select the armor for your character", playerName));
			Arrays.asList(Armor.values()).forEach(a -> {
				System.out.println(String.format("%d. %s", a.ordinal() + 1, a.getName()));
			});
			armor = Armor.fromInteger(scanner.nextInt() - 1);
		} while(!character.isAcceptedArmor(armor));
		
		Weapon weapon;
		do {
			System.out.println(String.format("%s please select the weapon for your character", playerName));
			Arrays.asList(Weapon.values()).forEach(w -> {
				System.out.println(String.format("%d. %s", w.ordinal() + 1, w.getName()));
			});
			weapon = Weapon.fromInteger(scanner.nextInt() - 1);
		} while(!character.isAcceptedWeapon(weapon));
		
		System.out.println(String.format("%s, thank you for using our character creator.", playerName));
		System.out.println(String.format("You have chosen to play as a %s", character.getName()));
		System.out.println(String.format("You will be wearing %s armor and using a %s", 
				armor.getName(), weapon.getName()));
		
		scanner.close();
	}
}
