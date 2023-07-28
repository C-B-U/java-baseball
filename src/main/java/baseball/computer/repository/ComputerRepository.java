package baseball.computer.repository;

import baseball.computer.dto.StrikeAndBallDTO;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class ComputerRepository {

    private static final int COMPUTER_NUMBER_SiZE = 3;

    private List<Integer> computerNumber;
    private Long strike;
    private Long ball;

    public ComputerRepository() {
        computerNumber = null;
        strike = 0L;
        ball = 0L;
    }

    public StrikeAndBallDTO getStrikeAndBallDTO(List<Integer> userNumber){
        checkBaseballStrike(userNumber);
        checkBaseballBall(userNumber);
        return new StrikeAndBallDTO(strike, ball);
    }

    public void makeRandomNumber() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < COMPUTER_NUMBER_SiZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public void checkBaseballStrike(List<Integer> userNumber){
        strike = IntStream.range(0, userNumber.size())
                .filter(i -> isStrike(userNumber.get(i), computerNumber.get(i)))
                .count();
    }

    private boolean isStrike(int userNumber, int computerNumber) {
        return userNumber == computerNumber;
    }

    public void checkBaseballBall(List<Integer> userNumber){
        ball = IntStream.range(0, userNumber.size())
                .filter(isBall(userNumber))
                .count();
    }

    private IntPredicate isBall(List<Integer> userNumber) {
        return i -> computerNumber.contains(userNumber.get(i))
                && !isStrike(userNumber.get(i), computerNumber.get(i));
    }

}
