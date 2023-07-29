package baseball.View;

public enum BallStatusMessage {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    BallStatusMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
