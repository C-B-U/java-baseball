package baseball;

public enum GameCheck {
    RESTART("1"),
    QUIT("2");

    private final String message;

    GameCheck(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
