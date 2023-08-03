package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Answer {
    private final List<Integer> currentAnswer;

    private Answer() {
        this.currentAnswer = Collections.unmodifiableList(generateRandomNumbers());
    }

    public static Answer createAnswer() {
        return new Answer();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public Integer findByIndex(final Integer index) {
        return currentAnswer.get(index);
    }

    public boolean hasNum(final int attemptNum) {
        return currentAnswer.contains(attemptNum);
    }
}
