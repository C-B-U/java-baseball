package baseball;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ResultProvider {
    private final CountProvider strikeCountProvider = s -> s.filter(i -> i == StrikeBall.STRIKE).mapToInt(i -> 1).sum();
    private final CountProvider ballCountProvider = s -> s.filter(i -> i == StrikeBall.BALL).mapToInt(i -> 1).sum();
    private final Answer answer;
    private final String attempt;

    public ResultProvider(final Answer answer, final String attempt) {
        this.answer = answer;
        this.attempt = attempt;
    }

    public String getResult() {
        final Stream<StrikeBall> strikeBallStream = getStrikeBallStream();
        final Integer strikeNum = countOfStrikeBall(strikeCountProvider, strikeBallStream);
        final Integer ballNum = countOfStrikeBall(ballCountProvider, strikeBallStream);
        return BallCount.findMessageByStrikeNum(ballNum, strikeNum);
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
        if (answerNum == attemptNum && answerNum == index) {
            return StrikeBall.STRIKE;
        }
        return checkBallOrNone(answerNum, attemptNum);
    }

    private StrikeBall checkBallOrNone(final int answerNum, final int attemptNum) {
        if (answerNum == attemptNum) {
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
