package baseball;

public enum ExceptionMessage {
    INPUTWRONGCOUNT("잘못된 개수의 숫자를 입력했습니다."),
    INPUTDUPLICATENUMBER("중복된 숫자를 입력했습니다."),
    INPUTWRONGNUMBER("잘못된 숫자를 입력했습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
