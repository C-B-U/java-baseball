package baseball;

public class OutputWriter {
    private final ResultOutputFormatter resultOutputFormatter;

    public OutputWriter(final ResultOutputFormatter resultOutputFormatter) {
        this.resultOutputFormatter = resultOutputFormatter;
    }

    public void writeWithLine(final GameMessage gameMessage) {
        System.out.println(gameMessage);
    }

    public void write(final GameMessage gameMessage) {
        System.out.print(gameMessage);
    }

    public void writeWithFormat(final Result result) {
        System.out.println(resultOutputFormatter.format(result));
    }
}
