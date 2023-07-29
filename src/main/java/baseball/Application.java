package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int CONTINUE_GAME = 1;

    public static void main(String[] args) {
        final ComponentFactory componentFactory = new ComponentFactory();
        final BaseballController baseballController = componentFactory.baseballController();

        boolean isContinue = Boolean.TRUE;
        while(isContinue) {
            baseballController.startGame();
            isContinue = askIsContinue();
        }
    }

    private static boolean askIsContinue() {
        System.out.println(GameMessage.CREATE_NEW_GAME_OR_NOT.getMessage());
        final String input = Console.readLine();
        final InputValidator inputValidator = new InputValidator();
        inputValidator.validateIsContinue(input);
        return Integer.parseInt(input) == CONTINUE_GAME;
    }
}
