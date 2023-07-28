package baseball.Model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private final List<Integer> randomNumbers;
    private final static Integer MAXIMUM_BALL_COUNT = 3;
    private final static Integer MIN_BALL_NUMBER = 1;
    private final static Integer MAX_BALL_NUMBER = 9;

    public Computer() {
        this.randomNumbers = createRandomNumbers();
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        while(randomNumbers.size() < MAXIMUM_BALL_COUNT) {
            addNotDuplicateNumber(randomNumbers);
        }
        return randomNumbers;
    }

    private void addNotDuplicateNumber(List<Integer> existingNumbers) {
        int randomNumber = Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
        if (!existingNumbers.contains(randomNumber)) {
            existingNumbers.add(randomNumber);
        }
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}