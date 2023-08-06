package baseball;

public class BaseballRepository {
    private Answer answer;

    public void saveAnswer(final Answer answer) {
        this.answer = answer;
    }

    public Answer findCurrentAnswer() {
        return this.answer;
    }
}
