package baseball.View;

public enum Message {
    START_MESSAGE("숫자 야구 게임을 시작합니다."),
    USER_INPUT_MESSAGE("숫자를 입력해주세요 : "),
    THREE_STRIKE_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    DUPLICATE_NUMBER_EXCEPTION("중복된 숫자를 입력하였습니다."),
    INCORRECT_LENGTH_EXCEPTION("3글자만 입력 가능합니다."),
    NON_NUMERIC_INPUT_EXCEPTION("숫자가 아닌 입력이 존재합니다."),
    RESTART_INPUT_EXCEPTION("올바른 재시작 또는 종료 입력이 아닙니다.");



    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
