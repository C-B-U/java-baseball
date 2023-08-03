package baseball.Model;

public class User {

    private final Numbers inputNumbers;

    public User(Numbers inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public Numbers getUserInputNumber() {
        return inputNumbers;
    }

    public int getByPosition(int position) {
        return inputNumbers.get(position);
    }
}
