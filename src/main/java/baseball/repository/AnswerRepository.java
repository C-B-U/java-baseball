package baseball.repository;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class AnswerRepository {

    private static List<Integer> answer;
    private static List<Integer> userAnswer;

    public List<Integer> getAnswer() {
        return answer;
    }

    public List<Integer> getUserAnswer() {
        return userAnswer;
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
        System.out.println("answer = " + answer);
        return answer;
    }

    public List<Integer> setUerAnswer(String answer) {
//        List<Integer> ints = Arrays.asList(Stream.of(answer.split("")).mapToInt(Integer::parseInt).toArray());
        List<Integer> userAnswer = new ArrayList<Integer>();
        String[] splitAnswer = answer.split("");
        for (String tmp : splitAnswer) {
            userAnswer.add(Integer.parseInt(tmp));
        }
        this.userAnswer = userAnswer;
        return userAnswer;
    }
}