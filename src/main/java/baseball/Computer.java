package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NONE = "낫싱";

    List<Integer> computerNumber;
    public Computer() {
        computerNumber = makeRandomNumber();
        System.out.println(computerNumber);
    }

    private List<Integer> makeRandomNumber() {
        List<Integer> numberList = new ArrayList<>();
        do {
            int newNumber = Randoms.pickNumberInRange(1, 9);
            if (numberList.contains(newNumber))
                continue;
            numberList.add(newNumber);
        } while (numberList.size() < 3);

        return numberList;
    }

    public String compareWithUserNumber(List<Integer> number) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < number.size(); i++) {
            if (Objects.equals(number.get(i), computerNumber.get(i))) {
                strike++;
                continue;
            }

            if (computerNumber.contains(number.get(i))) {
                ball++;
            }
        }
        return makeString(ball, strike);
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
