package baseball;

public class OutputWriter {
    public void printWithLine(final GameMessage gameMessage) {
        System.out.println(gameMessage);
    }

    public void print(final GameMessage gameMessage) {
        System.out.print(gameMessage);
    }

    public void printWithLine(final BallCount ballCount) {
        System.out.println(ballCount);
    }
}
