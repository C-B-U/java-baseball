package baseball.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public List<Integer> readUserInput() {
        Message message = Message.USER_INPUT_MESSAGE;
        System.out.print(message.getMessage());
        String userInput = Console.readLine();
        String[] userInputArray = userInput.split("");
        return Arrays.stream(userInputArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
