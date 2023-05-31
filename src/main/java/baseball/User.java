package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static baseball.message.GameMessage.INPUT_MESSAGE;

public class User {
    static final int GAME_NUMBER_LENGTH = 3;
    static final Pattern NUMBER_PATTERN = Pattern.compile("^[1-9]*$"); // 정규식 사용
    public String inputUserNumber() {

        System.out.print(INPUT_MESSAGE.getMessage());
        String inputNumber = Console.readLine();

        // 사용자 입력 숫자 검증
        if (!gameNumberExceptionCheck(inputNumber)) {
            throw new IllegalArgumentException();
        }

        return inputNumber;
    }
    private boolean gameNumberExceptionCheck(String inputNumber) {
        if (inputNumber.length() == GAME_NUMBER_LENGTH) {
            Matcher matchNum = NUMBER_PATTERN.matcher(inputNumber);
            return matchNum.find();
        }
        return false;
    }
}