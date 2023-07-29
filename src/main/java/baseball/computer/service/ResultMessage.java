package baseball.computer.service;

public class ResultMessage {

    private final static int NO_EVENT = 0;
    private StringBuilder resultMessage;

    public ResultMessage() {
        this.resultMessage = null;
    }


    public String toString(Long strike, Long ball){
        resultMessage = new StringBuilder();
        isNothing(strike,ball);
        isBall(ball);
        isStrike(strike);
        return resultMessage.toString();
    }

    private void isBall(Long ball){
        if (ball != NO_EVENT){
            resultMessage.append(ball);
            resultMessage.append(BaseballMessage.BALL);
        }
    }

    private void isStrike(Long strike){
        if(strike != NO_EVENT){
            resultMessage.append(strike);
            resultMessage.append(BaseballMessage.STRIKE);
        }
    }

    private void isNothing(Long strike, Long ball){
        if(strike == NO_EVENT && ball == NO_EVENT){
            resultMessage.append(BaseballMessage.NOTHING);
        }
    }
}
