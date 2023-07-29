package baseball;

public class ComponentFactory {

    public BaseballController baseballController() {
        return new BaseballController(baseballService(), userAttemptValidator());
    }

    private BaseballService baseballService() {
        return new BaseballService(baseballRepository());
    }

    private BaseballRepository baseballRepository() {
        return new BaseballRepository();
    }

    private UserAttemptValidator userAttemptValidator() {
        return new UserAttemptValidator();
    }
}
