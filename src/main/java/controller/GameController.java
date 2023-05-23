package controller;

import baseball.BallCheck;
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
            System.out.print(GameMessage.INPUT.getMessage());
            gamePlayService.inputBall();
            if (checkNothing()) {
                System.out.println(BallCheck.NOTHING.getMessage());
                continue;
            }
            if (checkResult()) {
                System.out.println(GameMessage.SUCCESS.getMessage());
                break;
            }
            gamePlayService.strikeBallCount();
            System.out.println(GamePlayService.sb);
        }
        gameStatus();
    }

    private boolean checkNothing() {
        return gamePlayService.checkNothing();
    }

    private boolean checkResult() {
        return gamePlayService.checkResult();
    }

    private void gameStatus() {
        System.out.println(GameMessage.GAMESTATUS.getMessage());
        if (gamePlayService.gameStatus()) {
            gameStart();
        }
    }
}
