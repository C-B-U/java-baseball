package baseball.View;

import baseball.Model.BallStatus;

import java.util.Map;

public class OutputView {

    private static final int MAX_BALL_COUNT = 3;
    private static final int NOT_EXIST = 0;

    public void printStartMessage() {
        Message message = Message.START_MESSAGE;
        System.out.println(message.getMessage());
    }

    public void printThreeStrikeMessage() {
        Message message = Message.THREE_STRIKE_MESSAGE;
        System.out.println(message.getMessage());
    }

    public void printGameResult(Map<BallStatus, Integer> result) {
        System.out.println(getBallStatusMessage(result));
    }

    private String getBallStatusMessage(Map<BallStatus, Integer> result) {
        if(isNoting(result)) {
            return BallStatusMessage.NOTHING.getMessage();
        }
        return ballAndStrikeCountMessage(result);
    }

    private String ballAndStrikeCountMessage(Map<BallStatus, Integer> result) {
        StringBuilder stringBuilder = new StringBuilder();
        int strikeCount = result.getOrDefault(BallStatus.STRIKE, 0);
        int ballCount = result.getOrDefault(BallStatus.BALL, 0);
        appendStrikeMessage(strikeCount, stringBuilder);
        appendSpaceBetweenStrikeAndBallMessage(strikeCount, ballCount, stringBuilder);
        appendBallMessage(ballCount, stringBuilder);
        return stringBuilder.toString();
    }

    private void appendStrikeMessage(int strikeCount, StringBuilder stringBuilder) {
        if (isExistStrike(strikeCount)) {
            stringBuilder.append(strikeCount).append(BallStatusMessage.STRIKE.getMessage());
        }
    }

    private void appendBallMessage(int ballCount, StringBuilder stringBuilder) {
        if (isExistBall(ballCount)) {
            stringBuilder.append(ballCount).append(BallStatusMessage.BALL.getMessage());
        }
    }

    private void appendSpaceBetweenStrikeAndBallMessage(int strikeCount, int ballCount, StringBuilder stringBuilder) {
        if (isExistStrike(strikeCount) && isExistBall(ballCount)) {
            stringBuilder.append(" ");
        }
    }

    private boolean isExistStrike(int strikeCount) {
        return strikeCount != NOT_EXIST;
    }

    private boolean isExistBall(int ballCount) {
        return ballCount != NOT_EXIST;
    }

    public boolean isNoting(Map<BallStatus, Integer> result) {
        return result.getOrDefault(BallStatus.NOTHING, 0) == MAX_BALL_COUNT;
    }
}
