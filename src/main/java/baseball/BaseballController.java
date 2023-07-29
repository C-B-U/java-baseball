package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballController {
    private final BaseballService baseballService;
    private final UserAttemptValidator userAttemptValidator;

    public BaseballController(final BaseballService baseballService, final UserAttemptValidator userAttemptValidator) {
        this.baseballService = baseballService;
        this.userAttemptValidator = userAttemptValidator;
    }

    public void startGame() {
        baseballService.saveAnswer();
        final boolean isCorrect = Boolean.TRUE;
        while(isCorrect) {
            final String userAttempt = Console.readLine();
            validateUserAttempt(userAttempt);
        }
    }

    private void validateUserAttempt(final String userAttempt) {
        userAttemptValidator.validate(userAttempt);
    }
}
