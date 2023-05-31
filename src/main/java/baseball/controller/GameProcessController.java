package baseball.controller;

import baseball.PlayResult;
import baseball.service.BaseballService;
import baseball.service.StringReplyService;

import java.util.Map;



public class GameProcessController {
    private final InputController inputController;
    private final PrintController printController;
    private final BaseballService baseballService = new BaseballService();
    private final StringReplyService stringReplyService = new StringReplyService();

    public GameProcessController(InputController inputController, PrintController printController) {
        this.inputController = inputController;
        this.printController = printController;
    }

    private void continueGame() {
        printController.askGameRestart();
        if (inputController.isContinueGame()) {
            makeGameAnswer();
        }
    }

    public void makeGameAnswer() {
        baseballService.makeAnswer();
        requireUserAnswer();
    }

    private void requireUserAnswer() {
        inputController.recieveUserAnswer(baseballService);
        checkCorrect();
    }

    private void checkCorrect() {
        Map<PlayResult, Integer> result = baseballService.makeReply();
        printController.printResult(stringReplyService.makeStringReply(result));
        if (result.containsKey(PlayResult.STRIKE) && result.get(PlayResult.STRIKE).equals(3)) {
            printController.successGame();
            continueGame();
            return;
        }
        requireUserAnswer();
    }
}
