package baseball;

public class BaseballService {
    private final BaseballRepository baseballRepository;

    public BaseballService(final BaseballRepository baseballRepository) {
        this.baseballRepository = baseballRepository;
    }

    public void saveAnswer() {
        final Answer answer = Answer.createAnswer();
        baseballRepository.saveAnswer(answer);
    }
}
