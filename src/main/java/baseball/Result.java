package baseball;

public class Result {
    private final int strikeNum;
    private final int ballNum;

    public Result(final int strikeNum, final int ballNum) {
        this.strikeNum = strikeNum;
        this.ballNum = ballNum;
    }

    public int getStrikeNum() {
        return this.strikeNum;
    }

    public int getBallNum() {
        return this.ballNum;
    }
}
