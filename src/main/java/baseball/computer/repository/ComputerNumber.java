package baseball.computer.repository;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class ComputerNumber {

    private static final int COMPUTER_NUMBER_SiZE = 3;
    private List<Integer> randomNumbers;

    ComputerNumber(){
        this.randomNumbers = null;
    }

    public void makeRandomNumber() {
        randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < COMPUTER_NUMBER_SiZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
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
