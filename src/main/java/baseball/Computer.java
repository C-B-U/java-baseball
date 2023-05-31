package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static baseball.message.NumberMessage.*;

public class Computer {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NONE = "낫싱";

    List<Integer> computerNumber = new ArrayList<>();
    public void generateRandomNumber(){

        while (computerNumber.size() < LENGTH_OF_QUIZ.getNumber()) {
            int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER.getNumber(), MAXIMUM_NUMBER.getNumber());
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        System.out.println(computerNumber);
    }

    public String compareWithUserNumber(String number) {
        int ball = 0;
        int strike = 0;
        List<Integer> userNumber = userNumberToList(number);

        for (int i = 0; i < userNumber.size(); i++) {
            if (Objects.equals(userNumber.get(i), computerNumber.get(i))) {
                strike++;
                continue;
            }

            if (computerNumber.contains(userNumber.get(i))) {
                ball++;
            }
        }

        return makeString(ball, strike);
    }

    private List<Integer> userNumberToList(String userNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (int length = 0; length < userNumber.length(); length++) {
            numbers.add(Integer.parseInt(String.valueOf(userNumber.charAt(length))));
        }
        return numbers;
    }

    private String makeString(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            return NONE;
        }
        if (ball == 0) {
            return strike + STRIKE;
        }
        if (strike == 0) {
            return ball + BALL;
        }
        return ball + BALL + " " + strike + STRIKE;
    }
}
