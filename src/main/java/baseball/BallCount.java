package baseball;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum BallCount {
    THREE_STRIKE((s, b) -> s == 3, "3스트라이크"),
    TWO_STRIKE((s, b) -> b == 0 && s == 2 , "2스트라이크"),
    ONE_BALL_TWO_STRIKE((s, b) -> b == 1 && s == 2, "1볼 2스트라이크"),
    ONE_BALL_ONE_STRIKE((s, b) -> b == 1 && s == 1, "1볼 1스트라이크"),
    TWO_BALL_ONE_STRIKE((s, b) -> b == 2 && s == 1, "2볼 1스트라이크"),
    ONE_STRIKE((s, b) -> b == 0 && s == 1 , "1스트라이크"),
    THREE_BALL((s, b) -> b == 3 && s == 0, "3볼"),
    TWO_BALL((s, b) -> b == 2 && s == 0, "2볼"),
    ONE_BALL((s, b) -> b == 1 && s == 0, "1볼"),
    NOTHING((s, b) -> b == 0 && s == 0, "낫싱");

    private final BiPredicate<Integer, Integer> strikeBallNumMatcher;
    private final String message;

    BallCount(final BiPredicate<Integer, Integer> strikeBallNumMatcher, final String message) {
        this.strikeBallNumMatcher = strikeBallNumMatcher;
        this.message = message;
    }

    public static BallCount ofStrikeAndBallNum(final Integer ballNum, final Integer strikeNum) {
        return Arrays.stream(BallCount.values())
                .filter(ballCount -> ballCount.strikeBallNumMatcher.test(strikeNum, ballNum))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getMessage() {
        return this.message;
    }
}
