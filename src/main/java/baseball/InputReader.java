package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {
    private final InputValidator inputValidator;

    public InputReader(final InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public String readUserAttempt() {
        final String input = Console.readLine();
        inputValidator.validateUserAttempt(input);
        return input;
    }

    public String readIsContinue() {
        final String input = Console.readLine();
        inputValidator.validateIsContinue(input);
        return input;
    }
}
