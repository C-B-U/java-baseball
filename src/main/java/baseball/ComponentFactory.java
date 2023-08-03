package baseball;

public class ComponentFactory {

    public BaseballController baseballController() {
        return new BaseballController(
                baseballService(),
                outputWriter(),
                inputReader());
    }

    private ResultOutputFormatter resultOutputFormatter() {
        return new ResultOutputFormatter();
    }

    private InputReader inputReader() {
        return new InputReader(inputValidator());
    }

    private OutputWriter outputWriter() {
        return new OutputWriter(resultOutputFormatter());
    }

    private BaseballService baseballService() {
        return new BaseballService(baseballRepository());
    }

    private BaseballRepository baseballRepository() {
        return new BaseballRepository();
    }

    private InputValidator inputValidator() {
        return new InputValidator();
    }
}
