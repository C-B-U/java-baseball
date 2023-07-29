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
        printGameMessage(GameMessage.GAME_START.getMessage());
        baseballService.saveAnswer();
        playGame();
    }

    private void playGame() {
        boolean isContinue = Boolean.TRUE;
        while(isContinue) {
            final String userAttempt = getUserAttempt();
            final BallCount result = getResult(userAttempt);

            if (result == BallCount.THREE_STRIKE) {
                printGameMessage(GameMessage.GAME_FINISH.getMessage());
                isContinue = Boolean.FALSE;
            }
        }
    }

    private String getUserAttempt() {
        printGameMessage(GameMessage.INPUT_NEXT_NUMBER.getMessage());
        final String userAttempt = Console.readLine();
        validateUserAttempt(userAttempt);
        return userAttempt;
    }

    private BallCount getResult(String userAttempt) {
        final BallCount result = baseballService.calculateResult(userAttempt);
        printGameMessage(result.getMessage());
        return result;
    }

    private void printGameMessage(final String message) {
        System.out.println(message);
    }

    private void validateUserAttempt(final String userAttempt) {
        inputValidator.validateUserAttempt(userAttempt);
    }
}
