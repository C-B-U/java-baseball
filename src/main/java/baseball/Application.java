package baseball;

import controller.GameController;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        GameController gameController = new GameController();
        gameController.settingGame();
    }
}
