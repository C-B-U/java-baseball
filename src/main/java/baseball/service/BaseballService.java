package baseball.service;

import baseball.repository.AnswerRepository;

import java.util.List;
import java.util.Map;


public class BaseballService {

    private final AnswerRepository answerRepository = new AnswerRepository();

    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";


    public List<Integer> makeUserAnswer(String userAnswer) {
        isCorrectUserAnswer(userAnswer);
        return answerRepository.setUerAnswer(userAnswer);
    }

    private void isCorrectUserAnswer(String userAnswer) {
        lengthOfUserAnswer(userAnswer);
        isInteger(userAnswer);

    }

    private void lengthOfUserAnswer(String userAnswer) {
        if (userAnswer.length() != 3) {
            throw new IllegalArgumentException("숫자는 3개만 입력해주세요.");
        }
    }

    private void isInteger(String userAnswer) {
        try {
            Integer.parseInt(userAnswer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> makeAnswer() {
        return answerRepository.makeAnswer();
    }

    public Map<String, Integer> makeReply(List<Integer> answer, List<Integer> userAnswer) {
        return makeMapReply(countStrikes(answer, userAnswer), countBalls(answer, userAnswer));
    }

    private int countStrikes(List<Integer> answer, List<Integer> userAnswer) {
        int cnt = 0;
        for (int i = 0; i < answer.size(); i++) {

            if (answer.get(i).equals(userAnswer.get(i))) {
                cnt++;
            }
        }
        return cnt;
    }

    private int countBalls(List<Integer> answer, List<Integer> userAnswer) {
        int cnt = 0;
        for (int userAns : userAnswer) {
            if (answer.contains(userAns)) {
                cnt++;
            }
        }
        return cnt;
    }

    public String makeStringReply(Map<String, Integer> mapReply) {
        StringBuilder sb = new StringBuilder();
        if (mapReply.containsKey(NOTHING)) {
            return NOTHING;
        }
        if (mapReply.get(BALL) != 0) {
            sb.append(mapReply.get(BALL).toString()).append(BALL).append(" ");
        }
        if (mapReply.get(STRIKE) != 0) {
            sb.append(mapReply.get(STRIKE).toString()).append(STRIKE);
        }
        return sb.toString();
    }

    private Map<String, Integer> makeMapReply(int strikeCnt, int ballCnt) {
        if (ballCnt == 0) {
            return Map.of(NOTHING, 0);
        }
        ballCnt -= strikeCnt;
        return Map.of(BALL, ballCnt, STRIKE, strikeCnt);
    }
}
