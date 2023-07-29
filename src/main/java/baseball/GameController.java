package baseball;

import baseball.Model.BallStatus;
import baseball.Model.Computer;
import baseball.Model.StrikeAndBallCount;
import baseball.Model.User;
import baseball.View.InputView;
import baseball.View.OutputView;

import java.util.Map;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final static Integer RESTART = 1;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        boolean isProgress = true;
        outputView.printStartMessage();
        while (isProgress) {
            Computer computer = new Computer();
            playUntilThreeStrikes(computer);
            isProgress = restartOrEnd();
        }
    }

    private void playUntilThreeStrikes(Computer computer) {
        boolean isNotThreeStrike = true;
        while(isNotThreeStrike) {
            User user = new User(inputView.readUserInput());
            StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(computer, user);
            Map<BallStatus, Integer> result = strikeAndBallCount.calculateBallAndStrikeCount();
            outputView.printGameResult(result);
            if (strikeAndBallCount.isThreeStrike(result)) {
                outputView.printThreeStrikeMessage();
                isNotThreeStrike = false;
            }
        }
    }

    private boolean restartOrEnd() {
        return inputView.readRestartInput() == RESTART;
    }
}
