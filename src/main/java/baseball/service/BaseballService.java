package baseball.service;

import baseball.PlayResult;
import baseball.exception.InputValidator;
import baseball.repository.AnswerRepository;

import java.util.List;
import java.util.Map;



public class BaseballService {


    private final InputValidator inputValidator = new InputValidator();
    private final AnswerRepository answerRepository = new AnswerRepository();


    public List<Integer> makeUserAnswer(String userAnswer) {
        inputValidator.correctUserAnswer(userAnswer);
        return answerRepository.setUerAnswer(userAnswer);
    }

    public List<Integer> makeAnswer() {
        return answerRepository.createAnswer();
    }

    public Map<PlayResult, Integer> makeReply() {
        return makeMapReply(countStrikes(answerRepository.getAnswer(), answerRepository.getUserAnswer()), countBalls(answerRepository.getAnswer(), answerRepository.getUserAnswer()));
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

    private Map<PlayResult, Integer> makeMapReply(int strikeCnt, int ballTotalCnt) {
        if (ballTotalCnt == 0) {
            return Map.of(PlayResult.NOTHING, 0);
        }
        ballTotalCnt -= strikeCnt;
        return Map.of(PlayResult.BALL, ballTotalCnt, PlayResult.STRIKE, strikeCnt);
    }
}
