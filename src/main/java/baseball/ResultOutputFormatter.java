package baseball;

public class ResultOutputFormatter {
    private static final int NONE = 0;
    private static final String BLANK = " ";

    public String format(final Result result) {
        final int ballNum = result.getBallNum();
        final int strikeNum = result.getStrikeNum();

        return getFormattedOutput(ballNum, strikeNum);
    }

    private String getFormattedOutput(final int ballNum, final int strikeNum) {
        if (ballNum == NONE && strikeNum == NONE) {
            return ResultMessage.NOTHING.toString();
        }
        return toCountResult(ballNum, strikeNum);
    }

    private String toCountResult(final int ballNum, final int strikeNum) {
        final StringBuilder stringBuilder = new StringBuilder();
        if (ballNum != NONE) {
            stringBuilder
                    .append(String.format(ResultMessage.BALL.toString(), ballNum))
                    .append(BLANK);
        }
        return appendStrikeIfExists(stringBuilder, strikeNum);
    }

    private String appendStrikeIfExists(final StringBuilder stringBuilder, final int strikeNum) {
        if (strikeNum != NONE) {
            stringBuilder
                    .append(String.format(ResultMessage.STRIKE.toString(), strikeNum));
        }
        return stringBuilder.toString();
    }
}
