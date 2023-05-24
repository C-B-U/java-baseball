package baseball;

public enum ExceptionMessage {
    INPUT_WRONG_COUNT("잘못된 개수의 숫자를 입력했습니다."),
    INPUT_DUPLICATE_NUMBER("중복된 숫자를 입력했습니다."),
    INPUT_WRONG_NUMBER("잘못된 숫자를 입력했습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
