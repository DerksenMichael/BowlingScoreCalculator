package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import calculator.Calculator;

class ScoreCalculatorTest {

	Calculator calculator;
	ArrayList<Integer> values;

	@BeforeEach
	void init() {
		calculator = new Calculator();
		values = new ArrayList<>();
	}

	@Test
	void testRollingSimple() {
		calculator.roll(6);
		assertEquals(6, calculator.getFrames().get(0).getRolls()[0]);
	}

	@Test
	void testRollingHard() {
		calculator.roll(2);
		calculator.roll(2);
		calculator.roll(10);
		calculator.roll(10);
		calculator.roll(2);
		calculator.roll(3);
		assertEquals(3, calculator.getFrames().get(3).getRolls()[1]);
	}

	@Test
	void testScoreMax() {
		for (int i = 0; i < 12; i++) {
			values.add(10);
		}
		assertEquals(300, calculator.roll(values));
	}

	@Test
	void testScoreMin() {
		for (int i = 0; i < 20; i++) {
			values.add(0);
		}
		assertEquals(0, calculator.roll(values));
	}

	@Test
	void testMiss() {
		for (int i = 0; i < 10; i++) {
			values.add(9);
			values.add(0);
		}
		assertEquals(90, calculator.roll(values));
	}

	@Test
	void testSpares() {
		for (int i = 0; i < 21; i++) {
			values.add(5);
		}
		assertEquals(150, calculator.roll(values));
	}

	@Test
	void testCommon() {
		values.addAll(Arrays.asList(7, 3, 10, 3, 1, 4, 5, 6, 4, 5, 5, 10, 1, 0, 7, 2, 8, 2, 2));
		assertEquals(115, calculator.roll(values));
	}
	
	@Test
	void testFail() {
		values.addAll(Arrays.asList(7, 3, 10, 3, 1, 4, 5, 6, 4, 5, 5, 10, 1, 0, 7, 2, 8, 2, 2));
		assertNotEquals(105, calculator.roll(values));
	}
}
