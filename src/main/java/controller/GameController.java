package controller;

import baseball.GameMessage;
import camp.nextstep.edu.missionutils.Console;
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
        String input = Console.readLine().trim();
        gamePlayService.inputBall(input);
    }

    private boolean checkResult() {
        if (gamePlayService.checkResult()) {
            System.out.println(GameMessage.SUCCESS.getMessage());
            return true;
        }
        return false;
    }

    private void strikeBallCount() {
        StringBuilder sb = new StringBuilder();
        gamePlayService.strikeBallCount(sb);
        System.out.println(sb);
    }

    private void gameStatus() {
        System.out.println(GameMessage.GAME_STATUS.getMessage());
        String input = Console.readLine().trim();
        if (gamePlayService.gameStatus(input)) {
            gameStart();
        }
    }
}
