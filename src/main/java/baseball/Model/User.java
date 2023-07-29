package baseball.Model;

import java.util.List;

public class User {

    private final List<Integer> inputNumbers;

    public User(List<Integer> inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public List<Integer> getUserInputNumber() {
        return inputNumbers;
    }
}
