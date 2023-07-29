package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public final class Answer {
    private final List<Integer> currentAnswer;

    private Answer() {
        this.currentAnswer = Collections.unmodifiableList(generateRandomNumbers());
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                RandomNumberRange.MIN.getNum(),
                RandomNumberRange.MAX.getNum(),
                RandomNumberRange.CIPHER.getNum());
    }

    public static Answer createAnswer() {
        return new Answer();
    }
}
