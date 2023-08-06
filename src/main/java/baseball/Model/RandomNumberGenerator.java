package baseball.Model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private final Numbers randomNumbers;
    private static final Integer MAXIMUM_BALL_COUNT = 3;
    private static final Integer MIN_BALL_NUMBER = 1;
    private static final Integer MAX_BALL_NUMBER = 9;

    public RandomNumberGenerator() {
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