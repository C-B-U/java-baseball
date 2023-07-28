package baseball.computer.service;

import baseball.computer.dto.StrikeAndBallDTO;
import baseball.computer.repository.ComputerRepository;

import java.util.List;

public class ComputerService {

    private final ComputerRepository computerRepository;
    private final Message message;

    public ComputerService(){
        this.computerRepository = new ComputerRepository();
        this.message = new Message();
    }

    public void makeRandomNumber(){
        computerRepository.makeRandomNumber();
    }

    public String getNumberResult(List<Integer> userNumber){
        StrikeAndBallDTO strikeAndBall = computerRepository.getStrikeAndBallDTO(userNumber);
        return message.toString(strikeAndBall.getStrike(), strikeAndBall.getBall());
    }



}
