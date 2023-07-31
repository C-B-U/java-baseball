package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private List<Integer> playerInput;

    public List<Integer> playerInput() {
        System.out.print(INPUT_MESSAGE);
        String playerInputString = Console.readLine();
        checkInputFormat(playerInputString);
        playerInput = convertToIntegerList(playerInputString);
        return playerInput;
    }

    private void checkInputFormat(String inputString) {
        if (inputString.length() != 3)
            throw new IllegalArgumentException("3자리 수만 입력 가능합니다.");
        if (!isNumber(inputString))
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        if (!isAllDifferent(inputString))
            throw new IllegalArgumentException("서로 다른 수로 이루어져야 합니다.");
    }

    private List<Integer> convertToIntegerList(String playerInputString) {
        List<Integer> playerInput = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            char numberInString = playerInputString.charAt(i);
            int converted = numberInString - '0';
            playerInput.add(converted);
        }
        return playerInput;
    }

    private boolean isNumber(String inputString) {
        for (int i = 0; i < 3; i++) {
            char tmp = inputString.charAt(i);
            if (('1' <= tmp) && (tmp <= '9'))
                return true;
        }
        return false;
    }

    private boolean isAllDifferent(String inputString) {
        char first = inputString.charAt(0);
        char second = inputString.charAt(1);
        char third = inputString.charAt(2);
        if ((first != second) && (second != third) && (third != first)) {
            return true;
        }
        return false;
    }
}