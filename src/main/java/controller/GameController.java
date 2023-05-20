package controller;

import service.GamePlayService;

public class GameController {
    private final GamePlayService gamePlayService = new GamePlayService();

    public void gameStart() {
        gamePlayService.gameStart();
        gameSetting();
    }

    public void gameSetting() {
        gamePlayService.makeBall();
        continueGame();
    }

    public void continueGame() {
        gamePlayService.continueGame();
        gameStatus();
    }

    public void gameStatus() {
        if (gamePlayService.gameStatus()) {
            gameStart();
        }
    }
}
