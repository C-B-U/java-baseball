package baseball;

public class BaseballController {
    private static final int CONTINUE_COMMAND = 1;
    private static final int ATTEMPT_SUCCESS = 3;
    private final BaseballService baseballService;
    private final OutputWriter outputWriter;
    private final InputReader inputReader;

    public BaseballController(
            final BaseballService baseballService,
            final OutputWriter outputWriter,
            final InputReader inputReader) {

        this.baseballService = baseballService;
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
    }

    public void startGame() {
        boolean isContinue = true;
        while (isContinue) {
            outputWriter.writeWithLine(GameMessage.GAME_START);
            baseballService.saveAnswer();
            playGame();
            isContinue = askIsContinue();
        }
    }

    private boolean askIsContinue() {
        outputWriter.writeWithLine(GameMessage.CREATE_NEW_GAME_OR_NOT);
        final String input = inputReader.readIsContinue();
        return Integer.parseInt(input) == CONTINUE_COMMAND;
    }

    private void playGame() {
        boolean isContinue = true;
        while (isContinue) {
            final String userAttempt = getUserAttempt();
            final Result result = getResult(userAttempt);

            if (result.getStrikeNum() == ATTEMPT_SUCCESS) {
                outputWriter.writeWithLine(GameMessage.GAME_FINISH);
                isContinue = false;
            }
        }
    }

    private String getUserAttempt() {
        outputWriter.write(GameMessage.INPUT_NEXT_NUMBER);
        return inputReader.readUserAttempt();
    }

    private Result getResult(final String userAttempt) {
        final Result result = baseballService.calculateResult(userAttempt);
        outputWriter.writeWithFormat(result);
        return result;
    }
}
