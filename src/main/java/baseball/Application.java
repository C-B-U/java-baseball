package baseball;

import controller.GameController;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        GameController gameController = new GameController();
        gameController.settingGame();
    }
}
