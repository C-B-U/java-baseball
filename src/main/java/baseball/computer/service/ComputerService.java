package baseball.computer.service;

import baseball.computer.dto.StrikeAndBallDTO;
import baseball.computer.repository.ComputerRepository;

import java.util.List;

public class ComputerService {

    private final ComputerRepository computerRepository;
    private final ResultMessage resultMessage;

    public ComputerService(){
        this.computerRepository = new ComputerRepository();
        this.resultMessage = new ResultMessage();
    }

    public void remakeRandomNumber(){
        computerRepository.remakeComputerNumber();
    }

    public String getNumberResult(List<Integer> userNumber){
        StrikeAndBallDTO strikeAndBall = computerRepository.getStrikeAndBallDTO(userNumber);
        return resultMessage.toString(strikeAndBall.getStrike(), strikeAndBall.getBall());
    }



}
