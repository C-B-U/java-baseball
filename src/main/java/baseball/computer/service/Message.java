package baseball.computer.service;

public class Message {

    private StringBuilder resultMessage;

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
            resultMessage.append("볼 ");
        }
    }

    private void isStrike(Long strike){
        if(strike != 0){
            resultMessage.append(strike);
            resultMessage.append("스트라이크\n");
        }
    }

    private void isNothing(Long strike, Long ball){
        if(strike == 0 && ball == 0){
            resultMessage.append("낫싱");
        }
    }
}
