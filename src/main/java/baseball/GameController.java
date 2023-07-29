package baseball;

import baseball.Model.BallStatus;
import baseball.Model.Computer;
import baseball.Model.StrikeAndBallCount;
import baseball.Model.User;
import baseball.View.InputView;

import java.util.Map;

public class GameController {

    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        playUntilThreeStrikes(computer);
    }

    private void playUntilThreeStrikes(Computer computer) {
        boolean isNotThreeStrike = true;
        while(isNotThreeStrike) {
            User user = new User(inputView.readUserInput());
            StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(computer, user);
            Map<BallStatus, Integer> result = strikeAndBallCount.calculateBallAndStrikeCount();
            if (strikeAndBallCount.isThreeStrike(result)) {
                isNotThreeStrike = false;
            }
        }
    }
}
