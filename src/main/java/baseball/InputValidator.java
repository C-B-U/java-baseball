package baseball;

public class InputValidator {
    private static final String NUMERIC_MATCHER = "-?\\d+";
    private static final Integer IS_CONTINUE_LENGTH = 1;
    private static final Integer CONTINUE = 1;
    private static final Integer NOT_CONTINUE = 2;


    public void validateUserAttempt(final String userAttempt) {
        if (notValidAttemptString(userAttempt) || hasDuplicate(userAttempt)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean notValidAttemptString(final String userAttempt) {
        return userAttempt.isBlank()
                || !userAttempt.matches(NUMERIC_MATCHER)
                || userAttempt.length() != RandomNumberRange.CIPHER.getNum();
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
        return isContinueInput.isBlank()
                || !isContinueInput.matches(NUMERIC_MATCHER)
                || isContinueInput.length() != IS_CONTINUE_LENGTH;
    }

    private boolean isOutOfRange(final String isContinueInput) {
        final int input = Integer.parseInt(isContinueInput);
        return input != CONTINUE && input != NOT_CONTINUE;
    }
}
