package baseball;

public class UserAttemptValidator {
    private static final String NUMERIC_MATCHER = "-?\\d+";

    public void validate(final String userAttempt) {
        if (notValidString(userAttempt)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean notValidString(final String userAttempt) {
        return userAttempt.isBlank() || !userAttempt.matches(NUMERIC_MATCHER) || userAttempt.length() != 3;
    }
}
