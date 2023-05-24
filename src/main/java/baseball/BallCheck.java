package baseball;

public enum BallCheck {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    public String getMessage() {
        return message;
    }

    BallCheck(String message) {
        this.message = message;
    }

}
