package baseball;

public class InputValidator {
    private static final String NUMERIC_MATCHER = "-?\\d+";

    public void validateUserAttempt(final String userAttempt) {
        if (notValidAttemptString(userAttempt) || hasDuplicate(userAttempt)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean notValidAttemptString(final String userAttempt) {
        return userAttempt.isBlank() || !userAttempt.matches(NUMERIC_MATCHER) || userAttempt.length() != 3;
    }

    private boolean hasDuplicate(final String userAttempt) {
        final long count = userAttempt.chars().distinct().count();
        return count != 3;
    }

    public void validateIsContinue(final String isContinueInput) {
        if (notValidIsContinueString(isContinueInput) || isOutOfRange(isContinueInput)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean notValidIsContinueString(final String isContinueInput) {
        return isContinueInput.isBlank() || !isContinueInput.matches(NUMERIC_MATCHER) || isContinueInput.length() != 1;
    }

    private boolean isOutOfRange(final String isContinueInput) {
        final int input = Integer.parseInt(isContinueInput);
        return input != 1 && input != 2;
    }
}
