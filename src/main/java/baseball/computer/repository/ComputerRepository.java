package baseball.computer.repository;

import baseball.computer.dto.StrikeAndBallDTO;
import java.util.List;

public class ComputerRepository {

    private final ComputerNumber computerNumber;
    private Long strike;
    private Long ball;

    public ComputerRepository() {
        this.computerNumber = new ComputerNumber();
        this.strike = 0L;
        this.ball = 0L;
    }

    public StrikeAndBallDTO getStrikeAndBallDTO(List<Integer> userNumber){
        strike = computerNumber.checkBaseballStrike(userNumber);
        ball = computerNumber.checkBaseballBall(userNumber);
        return new StrikeAndBallDTO(strike, ball);
    }

    public void makeRandomNumber() {
        computerNumber.makeRandomNumber();
    }

}
