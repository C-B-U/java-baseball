package baseball;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultProvider {
    private final Answer answer;
    private final String attempt;

    public ResultProvider(final Answer answer, final String attempt) {
        this.answer = answer;
        this.attempt = attempt;
    }

    public Result calculateResult() {
        final List<StrikeBall> strikeBalls = mapToStrikeBalls();
        final int strikeCount = Collections.frequency(strikeBalls, StrikeBall.STRIKE);
        final int ballCount = Collections.frequency(strikeBalls, StrikeBall.BALL);
        return new Result(strikeCount, ballCount);
    }

    private List<StrikeBall> mapToStrikeBalls() {
        return IntStream.range(0, 3).mapToObj(i -> {
            final int attemptNum = convertToIntWithIndex(i);
            final int answerNum = findAnswerNumByIndex(i);
            return checkStrikeBall(answerNum, attemptNum, i);
        }).collect(Collectors.toUnmodifiableList());
    }

    private StrikeBall checkStrikeBall(final int answerNum, final int attemptNum, final int index) {
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
