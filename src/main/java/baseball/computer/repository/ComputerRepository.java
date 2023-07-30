package baseball.computer.repository;

import baseball.computer.dto.StrikeAndBallDTO;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerRepository {
    private static final int COMPUTER_NUMBER_SiZE = 3;
    private ComputerNumber computerNumber;
    private Long strike;
    private Long ball;

    public ComputerRepository() {
        this.computerNumber = new ComputerNumber(makeRandomNumber());
        this.strike = 0L;
        this.ball = 0L;
    }

    public StrikeAndBallDTO getStrikeAndBallDTO(List<Integer> userNumber){
        strike = computerNumber.checkBaseballStrike(userNumber);
        ball = computerNumber.checkBaseballBall(userNumber);
        return new StrikeAndBallDTO(strike, ball);
    }

    public List<Integer> makeRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < COMPUTER_NUMBER_SiZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public void remakeComputerNumber(){
        this.computerNumber = new ComputerNumber(makeRandomNumber());
    }


}
