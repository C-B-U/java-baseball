package controller;

import baseball.GameMessage;
import service.GamePlayService;

public class GameController {
    private final GamePlayService gamePlayService;

    public GameController() {
        this.gamePlayService = new GamePlayService();
    }

    public void gameStart() {
        System.out.println(GameMessage.START.getMessage());
        gamePlayService.makeBall();
        continueGame();
    }

    private void continueGame() {
        while (true) {
            inputBall();
            if (checkResult()) {
                break;
            }
            strikeBallCount();
        }
        gameStatus();
    }

    private void inputBall() {
        System.out.print(GameMessage.INPUT.getMessage());
        gamePlayService.inputBall();
    }

    private boolean checkResult() {
        if (gamePlayService.checkResult()) {
            System.out.println(GameMessage.SUCCESS.getMessage());
            return true;
        }
        return false;
    }

    private void strikeBallCount() {
        gamePlayService.strikeBallCount();
        System.out.println(gamePlayService.sb);
    }

    private void gameStatus() {
        System.out.println(GameMessage.GAME_STATUS.getMessage());
        if (gamePlayService.gameStatus()) {
            gameStart();
        }
    }
}
