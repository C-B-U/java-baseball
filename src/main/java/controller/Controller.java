package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.GameResult;
import service.GameMessage;
import service.GameService;

import java.util.List;

public class Controller {
    private GameService gameService;
    private boolean isGameStart;
    private List<Integer> answers;

    public Controller() {
        this.gameService = new GameService();
    }

    public void startGame() {
        isGameStart = true;
        while (isGameStart) {

        }
    }

    private void gameSetting() {
        GameMessage.startMessage();
        answers = gameService.computerNumbers();
    }

    private void runningGame() {
        while (true) {
            GameMessage.inputMessage();
            String input = gameService.validateInput(Console.readLine());
            GameResult gameResult = gameService.gameResult(input, answers);

            GameMessage.output(gameResult);

            if (gameResult.isSuccess()) {
                GameMessage.gameEndMessage();
                GameMessage.restartMessage();
                isGameStart = gameService.isRestart(Console.readLine());
                break;
            }
        }
    }

}
