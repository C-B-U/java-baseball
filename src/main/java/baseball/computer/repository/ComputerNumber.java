package baseball.computer.repository;

import java.util.List;
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
                .filter(i -> isBall(userNumber.get(i),randomNumbers.get(i)))
                .count();
    }

    private boolean isBall(int userNumber, int computerNumber) {
        return randomNumbers.contains(userNumber)
                && !isStrike(userNumber, computerNumber);
    }
}
