package baseball.computer.service;

public class ResultMessage {

    private static final int NO_COUNT = 0;

    public String toString(Long strike, Long ball){
        StringBuilder resultMessage = new StringBuilder();
        appendNothingMessage(strike, ball, resultMessage);
        appendBallMessage(ball, resultMessage);
        appendStrikeMessage(strike, resultMessage);
        return resultMessage.toString();
    }

    private void appendBallMessage(Long ball, StringBuilder resultMessage){
        if (ball != NO_COUNT){
            resultMessage.append(ball);
            resultMessage.append(BaseballMessage.BALL);
            resultMessage.append(BaseballMessage.BLANK);
        }
    }

    private void appendStrikeMessage(Long strike, StringBuilder resultMessage){
        if(strike != NO_COUNT){
            resultMessage.append(strike);
            resultMessage.append(BaseballMessage.STRIKE);
        }
    }

    private void appendNothingMessage(Long strike, Long ball, StringBuilder resultMessage){
        if(strike == NO_COUNT && ball == NO_COUNT){
            resultMessage.append(BaseballMessage.NOTHING);
        }
    }
}
