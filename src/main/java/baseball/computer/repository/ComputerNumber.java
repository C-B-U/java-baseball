package baseball.computer.repository;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class ComputerNumber {

    private final List<Integer> randomNumbers;

    public ComputerNumber(List<Integer> randomNumbers){
        this.randomNumbers = randomNumbers;
    }

    public Long checkBaseballStrike(List<Integer> userNumber){
        return IntStream.range(0, userNumber.size())
                .filter(i -> isStrike(userNumber.get(i), randomNumbers.get(i)))
                .count();
    }

    private boolean isStrike(int userNumber, int computerNumber) {
        return userNumber == computerNumber;
    }

    public Long checkBaseballBall(List<Integer> userNumber){
        return IntStream.range(0, userNumber.size())
                .filter(isBall(userNumber))
                .count();
    }

    private IntPredicate isBall(List<Integer> userNumber) {
        return i -> randomNumbers.contains(userNumber.get(i))
                && !isStrike(userNumber.get(i), randomNumbers.get(i));
    }
}
