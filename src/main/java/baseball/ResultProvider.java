package baseball;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ResultProvider {
    private final CountProvider strikeCountProvider = s -> Long.valueOf(s.filter(i -> i == StrikeBall.STRIKE).count()).intValue();
    private final CountProvider ballCountProvider = s -> Long.valueOf(s.filter(i -> i == StrikeBall.BALL).count()).intValue();
    private final Answer answer;
    private final String attempt;

    public ResultProvider(final Answer answer, final String attempt) {
        this.answer = answer;
        this.attempt = attempt;
    }

    public BallCount getResult() {
        final Integer strikeNum = countOfStrikeBall(strikeCountProvider, getStrikeBallStream());
        final Integer ballNum = countOfStrikeBall(ballCountProvider, getStrikeBallStream());
        return BallCount.ofStrikeAndBallNum(ballNum, strikeNum);
    }

    private Integer countOfStrikeBall(final CountProvider countProvider, final Stream<StrikeBall> strikeBallStream) {
        return countProvider.countOf(strikeBallStream);
    }

    private Stream<StrikeBall> getStrikeBallStream() {
        return IntStream.range(0, 3).mapToObj(i -> {
            final int attemptNum = convertToIntWithIndex(i);
            final int answerNum = findAnswerNumByIndex(i);
            return matches(answerNum, attemptNum, i);
        });
    }

    private StrikeBall matches(final int answerNum, final int attemptNum, final int index) {
        if (answerNum == attemptNum && attemptNum == findAnswerNumByIndex(index)) {
            return StrikeBall.STRIKE;
        }
        return checkBallOrNone(attemptNum);
    }

    private StrikeBall checkBallOrNone(final int attemptNum) {
        if (answer.hasNum(attemptNum)) {
            return StrikeBall.BALL;
        }
        return StrikeBall.NONE;
    }

    private int findAnswerNumByIndex(final int index) {
        return answer.findByIndex(index);
    }

    private int convertToIntWithIndex(final int stringIndex) {
        return Integer.parseInt(String.valueOf(attempt.charAt(stringIndex)));
    }
}
