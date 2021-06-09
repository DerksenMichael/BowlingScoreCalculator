package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

	ArrayList<Frame> frames;

	public Calculator() {
		frames = new ArrayList<>();
		frames.add(new Frame());
	}

	public int rollAll(ArrayList<Integer> rolls) {
		for (Integer roll : rolls) {
			roll(roll);
		}
		return calculateScore();
	}

	public void roll(int roll) {
		if (getLastFrame().getAvailableRolls() < 1) {
			frames.add(new Frame());
		}
		applyBonus(roll);
		getLastFrame().applyRoll(roll);
	}

	public int calculateScore() {
		int counter = 0;
		int score = 0;
		for (Frame frame : frames) {
			if (counter++ < 10) {
				if (frame.getAvailableRolls() == 0 && frame.getBonusCounter() == 0) {
					score += frame.getScore();
				}
			}
		}
		return score;
	}

	private void applyBonus(int roll) {
		if (frames.size() > 1) {
			Frame secondLastFrame = frames.get(frames.size()-2);
			if(secondLastFrame.getBonusCounter() > 0) {
				secondLastFrame.applyBonus(roll);
			}
		}
		if (frames.size() > 2) {
			Frame thirdLastFrame = frames.get(frames.size()-3);
			if(thirdLastFrame.getBonusCounter() > 0) {
				thirdLastFrame.applyBonus(roll);
			}
		}
	}
	
	public ArrayList<Frame> getFrames() {
		return new ArrayList<Frame>(frames);
	}

	private Frame getLastFrame() {
		return frames.get(frames.size() - 1);
	}
}
