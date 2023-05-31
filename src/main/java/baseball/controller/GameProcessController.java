package baseball.controller;

import baseball.PlayResult;
import baseball.service.BaseballService;
import baseball.service.StringReplyService;

import java.util.Map;



public class GameProcessController {
    private final InputController inputController;
    private final BaseballService baseballService = new BaseballService();
    private final StringReplyService stringReplyService = new StringReplyService();

    public GameProcessController(InputController inputController) {
        this.inputController = inputController;
    }

    public void continueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        if (inputController.isContinueGame()) {
            makeGameAnswer();
        }
    }

    public void makeGameAnswer() {
        baseballService.makeAnswer();
        requireUserAnswer();
    }

    public void requireUserAnswer() {
        inputController.recieveUserAnswer(baseballService);
        checkCorrect();
    }

    public void checkCorrect() {
        Map<PlayResult, Integer> result = baseballService.makeReply();
        System.out.println(stringReplyService.makeStringReply(result));
        if (result.containsKey(PlayResult.STRIKE) && result.get(PlayResult.STRIKE).equals(3)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            continueGame();
            return;
        }
        requireUserAnswer();
    }
}
