package baseball.exception;

public class InputValidator {

    public void correctUserAnswer(String userAnswer) {
        lengthOfUserAnswer(userAnswer);
        integerValue(userAnswer);
    }

    private void lengthOfUserAnswer(String userAnswer) {
        if (userAnswer.length() != 3) {
            throw new IllegalArgumentException("숫자는 3개만 입력해주세요.");
        }
    }

    private void integerValue(String userAnswer) {
        userAnswer.matches("[0-9]+");
    }
}
