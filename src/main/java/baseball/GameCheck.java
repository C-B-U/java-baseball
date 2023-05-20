package baseball;

public enum GameCheck {
    RESTART("1"),
    QUIT("2");

    private final String gameCheck;

    GameCheck(String gameCheck) {
        this.gameCheck = gameCheck;
    }

    public String getGameCheck() {
        return gameCheck;
    }
}
