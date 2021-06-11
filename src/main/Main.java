package main;

import java.util.ArrayList;
import java.util.Arrays;

import calculator.Calculator;

public class Main {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		ArrayList<Integer> values = new ArrayList<>(Arrays.asList(7, 3, 10, 3, 1, 4, 5, 6, 4, 5, 5, 10, 1, 0, 7, 2, 8, 2, 2));
		calculator.rollAll(values);
		calculator.displayScore();
	}
}
