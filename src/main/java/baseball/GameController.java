package baseball;

import baseball.Model.*;
import baseball.View.InputView;
import baseball.View.OutputView;

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
            GameResult result = strikeAndBallCount.calculateBallAndStrikeCount();
            outputView.printGameResult(result);
            isNotThreeStrike = result.isNotThreeStrike();
        }
        outputView.printThreeStrikeMessage();
    }

    private boolean restartOrEnd() {
        Integer userInput = inputView.readRestartInput();
        return userInput.equals(RESTART);
    }
}
