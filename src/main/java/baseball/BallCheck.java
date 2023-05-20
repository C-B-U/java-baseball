package baseball;

public enum BallCheck {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String ballCheck;

    BallCheck(String ballCheck) {
        this.ballCheck = ballCheck;
    }

    public String getCheck() {
        return ballCheck;
    }
}
