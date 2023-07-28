package baseball.computer.service;

public class ResultMessage {

    private StringBuilder resultMessage;

    public ResultMessage() {
        resultMessage = null;
    }


    public String toString(Long strike, Long ball){
        resultMessage = new StringBuilder();
        isNothing(strike,ball);
        isBall(ball);
        isStrike(strike);
        return resultMessage.toString();
    }

    private void isBall(Long ball){
        if (ball != 0){
            resultMessage.append(ball);
            resultMessage.append(BaseballMessage.BALL);
        }
    }

    private void isStrike(Long strike){
        if(strike != 0){
            resultMessage.append(strike);
            resultMessage.append(BaseballMessage.STRIKE);
        }
    }

    private void isNothing(Long strike, Long ball){
        if(strike == 0 && ball == 0){
            resultMessage.append(BaseballMessage.NOTHING);
        }
    }
}
