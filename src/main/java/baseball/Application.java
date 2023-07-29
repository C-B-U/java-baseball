package baseball;

import baseball.View.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        GameController gameController = new GameController(inputView);
        gameController.start();
    }
}
