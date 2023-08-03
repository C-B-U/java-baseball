package baseball.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import baseball.Model.Numbers;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public Numbers readUserInput() {
        Message message = Message.USER_INPUT_MESSAGE;
        System.out.print(message.getMessage());
        String userInput = Console.readLine();
        InputValidator.isCorrectInput(userInput);
        return new Numbers(userInputToList(userInput));
    }

    public Integer readRestartInput() {
        Message message = Message.RESTART_MESSAGE;
        System.out.println(message.getMessage());
        String userInput = Console.readLine();
        InputValidator.isCorrectRestartInput(userInput);
        return Integer.valueOf(userInput);
    }

    private List<Integer> userInputToList(String userInput) {
        String[] userInputArray = userInput.split("");
        return Arrays.stream(userInputArray)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
