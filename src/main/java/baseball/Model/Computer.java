package baseball.Model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private final Numbers randomNumbers;
    private final static Integer MAXIMUM_BALL_COUNT = 3;
    private final static Integer MIN_BALL_NUMBER = 1;
    private final static Integer MAX_BALL_NUMBER = 9;

    public Computer() {
        this.randomNumbers = createRandomNumbers();
    }

    private Numbers createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < MAXIMUM_BALL_COUNT) {
            addNotDuplicateNumber(randomNumbers);
        }
        return new Numbers(randomNumbers);
    }

    private void addNotDuplicateNumber(List<Integer> existingNumbers) {
        int randomNumber = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
        if (!existingNumbers.contains(randomNumber)) {
            existingNumbers.add(randomNumber);
        }
    }

    public Numbers getRandomNumbers() {
        return randomNumbers;
    }

    public int getByPosition(int position) {
        return randomNumbers.get(position);
    }
}