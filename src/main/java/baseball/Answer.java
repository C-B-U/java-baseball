package baseball;

import camp.nextstep.edu.missionutils.Randoms;

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
        return Randoms.pickUniqueNumbersInRange(
                RandomNumberRange.MIN.getNum(),
                RandomNumberRange.MAX.getNum(),
                RandomNumberRange.CIPHER.getNum());
    }

    public Integer findByIndex(final Integer index) {
        return currentAnswer.get(index);
    }

    public boolean hasNum(final int attemptNum) {
        return currentAnswer.contains(attemptNum);
    }
}
