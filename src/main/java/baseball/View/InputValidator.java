package baseball.View;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final int CORRECT_LENGTH = 3;
    private static final int RESTART_INPUT = 1;
    private static final int END_INPUT = 2;

    public static void isCorrectInput(String userInput) {
        isNumber(userInput);
        isCorrectLength(userInput);
        isNotDuplicatedNumber(userInput);
    }

    public static void isCorrectRestartInput(String userInput) {
        if (isNotRestartInput(userInput) && isNotEndInput(userInput)) {
            Message message = Message.RESTART_INPUT_EXCEPTION;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    private static void isCorrectLength(String userInput)
    {
        if (userInput.length() != CORRECT_LENGTH) {
            Message message = Message.INCORRECT_LENGTH_EXCEPTION;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    private static void isNotDuplicatedNumber(String userInput) {
        String[] userInputArray = userInput.split("");
        Set<String> userInputToSet = new HashSet<>(List.of(userInputArray));
        if (userInputToSet.size() != CORRECT_LENGTH) {
            Message message = Message.DUPLICATE_NUMBER_EXCEPTION;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    private static void isNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            Message message = Message.NON_NUMERIC_INPUT_EXCEPTION;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    private static boolean isNotRestartInput(String userInput) {
        return Integer.parseInt(userInput) != RESTART_INPUT;
    }

    private static boolean isNotEndInput(String userInput) {
        return Integer.parseInt(userInput) != END_INPUT;
    }
}
