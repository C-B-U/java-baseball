package baseball;

public enum ResultMessage {
    BALL("%d볼"),
    STRIKE("%d스트라이크"),
    NOTHING("낫싱");

    private final String message;

    ResultMessage(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
