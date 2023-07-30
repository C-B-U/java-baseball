package baseball.View;

import baseball.Model.BallStatus;
import baseball.Model.GameResult;

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

    public void printGameResult(GameResult result) {
        System.out.println(getBallStatusMessage(result));
    }

    private String getBallStatusMessage(GameResult result) {
        if(isNoting(result)) {
            return BallStatusMessage.NOTHING.getMessage();
        }
        return ballAndStrikeCountMessage(result);
    }

    private String ballAndStrikeCountMessage(GameResult result) {
        StringBuilder stringBuilder = new StringBuilder();
        int strikeCount = result.get(BallStatus.STRIKE);
        int ballCount = result.get(BallStatus.BALL);
        appendBallMessage(ballCount, stringBuilder);
        appendSpaceBetweenStrikeAndBallMessage(strikeCount, ballCount, stringBuilder);
        appendStrikeMessage(strikeCount, stringBuilder);
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

    public boolean isNoting(GameResult result) {
        return result.get(BallStatus.NOTHING) == MAX_BALL_COUNT;
    }
}
