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
    private void settingGame() {
        // 컴퓨터 번호 설정
        answerNumbers = gameService.setComputerNumbers();
        // 게임 시작 문구
        GameMessage.gameStartMessage();
    }

    // 게임 시작
    public void startGame() {
        // 사용자 번호 입력 (검증)
        GameMessage.inputNumberMessage();
        String inputNumbers = gameService.validateInputNumber(Console.readLine());
        // 결과 도출
        GameResult gameResult = gameService.outputGameResult(inputNumbers, answerNumbers);
        GameResult.gameResultMessage(gameResult);

    }

    public void restartGame() {
        // 게임 시작
    }

}
