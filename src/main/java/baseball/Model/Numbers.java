package baseball.Model;

import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int get(int position) {
        return numbers.get(position);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public boolean hasSize(int size) {
        return numbers.size() == size;
    }
}
