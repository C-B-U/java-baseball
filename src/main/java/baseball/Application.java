package baseball;

import baseball.View.InputView;
import baseball.View.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(), new OutputView());
        gameController.start();
    }
}
