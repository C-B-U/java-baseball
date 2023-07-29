package baseball;

public class Application {
    public static void main(String[] args) {
        final ComponentFactory componentFactory = new ComponentFactory();
        final BaseballController baseballController = componentFactory.baseballController();

        boolean isContinue = Boolean.TRUE;
        while(isContinue) {
            baseballController.startGame();
        }
    }
}
