package baseball.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public List<Integer> readUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        String[] userInputArray = userInput.split("");
        return Arrays.stream(userInputArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
