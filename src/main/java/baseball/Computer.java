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

    private List<Integer> userNumberToList(String userNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (int length = 0; length < userNumber.length(); length++) {
            numbers.add(Integer.parseInt(String.valueOf(userNumber.charAt(length))));
        }
        return numbers;
    }
    
}
