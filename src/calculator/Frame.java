package calculator;

import java.util.Arrays;

public class Frame {
	
	private int[] rolls;
	private int bonus;
	private int bonusCounter;
	private int availableRolls;
	
	public Frame() {
		rolls = new int[2];
		availableRolls = 2;
	}
	
	public void applyRoll(int roll) {
		if(availableRolls == 2) {
			rolls[0] = roll;
			if(roll == 10) {
				availableRolls--;
				bonusCounter = 2;
			}
		}
		else if(availableRolls == 1) {
			rolls[1] = roll;
			if(rolls[0] + rolls[1] == 10) {
				bonusCounter = 1;
			}
		}
		availableRolls--;
	}
	
	public void applyBonus(int roll) {
		bonus += roll;
		bonusCounter--;
	}
	
	public int[] getRolls() {
		return Arrays.copyOf(rolls, rolls.length);
	}
	
	public int getScore() {
		return bonus + rolls[0] + rolls[1];
	}

	public int getBonusCounter() {
		return bonusCounter;
	}

	public int getAvailableRolls() {
		return availableRolls;
	}
}
