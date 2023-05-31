package baseball.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;


public class AnswerRepository {

    private List<Integer> answer;
    private List<Integer> userAnswer;

    public List<Integer> getAnswer() {
        return new ArrayList<>(answer);
    }

    public List<Integer> getUserAnswer() {
        return new ArrayList<>(userAnswer);
    }

    public List<Integer> createAnswer() {
        List<Integer> createdAnswer = new ArrayList<>();
        while (createdAnswer.size() < 3) {
            createdAnswer = createComputerAnswer(createdAnswer);
        }
        this.answer = createdAnswer;
        return new ArrayList<>(answer);
    }

    private List<Integer> createComputerAnswer(List<Integer> createdAnswer) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!createdAnswer.contains(randomNumber)) {
            createdAnswer.add(randomNumber);
        }
        return createdAnswer;
    }



    public List<Integer> setUerAnswer(String answer) {
        String[] splitAnswer = answer.split("");
        ArrayList<Integer> userAnswerTmp = new ArrayList<>();
        for (String tmp : splitAnswer) {
            userAnswerTmp.add(Integer.parseInt(tmp));
        }
        userAnswer = userAnswerTmp;
        return new ArrayList<>(userAnswer);
    }
}