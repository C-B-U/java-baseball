package controller;

import camp.nextstep.edu.missionutils.Console;
import domain.GameMessage;
import domain.GameResult;
import service.GameService;

import java.util.List;

public class GameController {

    private final GameService gameService;
    private List<Integer> answerNumbers;

    public GameController() {
        this.gameService = new GameService();
    }

    // 게임 세팅
    public void settingGame() {
        boolean isGameRunning = true;
        do {
            // 컴퓨터 번호 설정
            answerNumbers = gameService.setComputerNumbers();
            // 게임 시작 문구
            System.out.println(GameMessage.GAME_START_MESSAGE.getGameMessage());
            // 게임 시작
            isGameRunning = isGameStarting(isGameRunning);
        } while (isGameRunning);
    }

    // 게임 시작
    private boolean isGameStarting(boolean isGameRunning) {
        while(true) {
            // 사용자 번호 입력 (검증)
            System.out.print(GameMessage.INPUT_NUMBER_MESSAGE.getGameMessage());
            String inputNumbers = gameService.validateInputNumber(Console.readLine());
            // 결과 도출
            GameResult gameResult = gameService.outputGameResult(inputNumbers, answerNumbers);
            GameResult.gameResultMessage(gameResult);
            if (gameResult.isGameSuccess()) {
                return isGameRestart(isGameRunning);
            }
        }
    }

    private boolean isGameRestart(boolean isGameRunning) {
        System.out.println(GameMessage.GAME_SUCCESS_MESSAGE.getGameMessage());
        System.out.println(GameMessage.GAME_RESTART_MESSAGE.getGameMessage());
        isGameRunning = gameService.isRestartGame(Console.readLine());
        return isGameRunning;
    }
}
