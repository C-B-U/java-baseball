package baseball.repository;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnswerRepository {

    private List<Integer> answer;
    private List<Integer> userAnswer;

    public List<Integer> getAnswer() {
        return new ArrayList<>(answer);
    }

    public List<Integer> getUserAnswer() {
        return new ArrayList<>(userAnswer);
    }

    public List<Integer> makeAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        this.answer = answer;
        return answer;
    }

    public List<Integer> setUerAnswer(String answer) {
//        List<Integer> ints = Arrays.asList(Stream.of(answer.split("")).mapToInt(Integer::parseInt).collect(Collections.()));
        String[] splitAnswer = answer.split("");
        for (String tmp : splitAnswer) {
            userAnswer.add(Integer.parseInt(tmp));
        }
        return userAnswer;
    }
}