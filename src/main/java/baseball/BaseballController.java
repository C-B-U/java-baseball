package baseball;

public class BaseballController {
    private static final int CONTINUE_COMMAND = 1;
    private final BaseballService baseballService;
    private final InputValidator inputValidator;
    private final OutputWriter outputWriter;
    private final InputReader inputReader;

    public BaseballController(
            final BaseballService baseballService,
            final InputValidator inputValidator,
            final OutputWriter outputWriter,
            final InputReader inputReader) {

        this.baseballService = baseballService;
        this.inputValidator = inputValidator;
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public void startGame() {
        boolean isContinue = true;
        while(isContinue) {
            outputWriter.printWithLine(GameMessage.GAME_START);
            baseballService.saveAnswer();
            playGame();
            isContinue = askIsContinue();
        }
    }

    private boolean askIsContinue() {
        outputWriter.printWithLine(GameMessage.CREATE_NEW_GAME_OR_NOT);
        final String input = inputReader.read();
        inputValidator.validateIsContinue(input);
        return Integer.parseInt(input) == CONTINUE_COMMAND;
    }

    private void playGame() {
        boolean isContinue = true;
        while(isContinue) {
            final String userAttempt = getUserAttempt();
            final BallCount result = getResult(userAttempt);

            if (result == BallCount.THREE_STRIKE) {
                outputWriter.printWithLine(GameMessage.GAME_FINISH);
                isContinue = false;
            }
        }
    }

    private String getUserAttempt() {
        outputWriter.print(GameMessage.INPUT_NEXT_NUMBER);
        final String userAttempt = inputReader.read();
        validateUserAttempt(userAttempt);
        return userAttempt;
    }

    private BallCount getResult(final String userAttempt) {
        final BallCount result = baseballService.calculateResult(userAttempt);
        outputWriter.printWithLine(result);
        return result;
    }

    private void validateUserAttempt(final String userAttempt) {
        inputValidator.validateUserAttempt(userAttempt);
    }
}
