package baseball.service;
import java.util.List;


public class BaseballService {

    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";

    public String makeReply(List<Integer> answer, List<Integer> userAnswer) {
        return makeStringReply(countStrikes(answer, userAnswer), countBalls(answer, userAnswer));
    }

    private int countStrikes(List<Integer> answer, List<Integer> userAnswer) {
        int cnt = 0;
        for(int i = 0; i < answer.size(); i++) {
            if(answer.get(i) == userAnswer.get(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private int countBalls(List<Integer> answer, List<Integer> userAnswer) {
        int cnt = 0;
        for(int userAns : userAnswer) {
            if(answer.contains(userAns)) {
                cnt++;
            }
        }
        return cnt;
    }

    private String makeStringReply(int strikeCnt, int ballCnt) {
        if(ballCnt == 0) {
            return NOTHING;
        }
        ballCnt -= strikeCnt;
        return strikeCnt + STRIKE + ballCnt + BALL;
    }
}
