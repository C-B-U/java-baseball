package baseball;

public enum PlayResult {

    STRIKE("스트라이크"),
    BALL("볼"),
    OUT("아웃"),
    NOTHING("낫싱");

    final private String playResult;
    private PlayResult(String playResult) {
        this.playResult = playResult;
    }
    public String getPlayResult() {
        return playResult;
    }

}
