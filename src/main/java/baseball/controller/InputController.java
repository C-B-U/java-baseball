package baseball.controller;

import baseball.exception.ControllerException;
import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.Console;

public class InputController {

    final ControllerException controllerException = new ControllerException();

    public void recieveUserAnswer(BaseballService baseballService) {
        System.out.print("숫자를 입력해주세요 : ");
        String userAnswer = Console.readLine();
        baseballService.makeUserAnswer(userAnswer);
    }

    public boolean isContinueGame() {
        int continueGame = Integer.parseInt(Console.readLine());
        controllerException.rightResponse(continueGame);
        return continueGame == 1;
    }
}
