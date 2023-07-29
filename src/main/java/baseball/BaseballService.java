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

    public BallCount calculateResult(final String attempt) {
        final Answer currentAnswer = findCurrentAnswer();
        final ResultProvider resultProvider = new ResultProvider(currentAnswer, attempt);
        return resultProvider.getResult();
    }

    private Answer findCurrentAnswer() {
        return baseballRepository.findCurrentAnswer();
    }
}
