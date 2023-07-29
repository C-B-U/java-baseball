package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    private final BaseballService baseballService;
    private final InputValidator inputValidator;

    public BaseballController(final BaseballService baseballService, final InputValidator inputValidator) {
        this.baseballService = baseballService;
        this.inputValidator = inputValidator;
    }

    public void startGame() {
        System.out.println(GameMessage.GAME_START.getMessage());
        baseballService.saveAnswer();

        boolean isContinue = Boolean.TRUE;
        while(isContinue) {
            System.out.print(GameMessage.INPUT_NEXT_NUMBER.getMessage());
            final String userAttempt = Console.readLine();
            validateUserAttempt(userAttempt);

            final BallCount result = baseballService.calculateResult(userAttempt);
            System.out.println(result.getMessage());

            if (result == BallCount.THREE_STRIKE) {
                System.out.println(GameMessage.GAME_FINISH.getMessage());
                isContinue = Boolean.FALSE;
            }
        }
    }

    private void validateUserAttempt(final String userAttempt) {
        inputValidator.validateUserAttempt(userAttempt);
    }
}
