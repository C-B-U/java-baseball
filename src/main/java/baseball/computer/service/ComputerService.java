package baseball.computer.service;

import baseball.computer.dto.StrikeAndBallDTO;
import baseball.computer.repository.ComputerRepository;

import java.util.List;

public class ComputerService {

    private final ComputerRepository computerRepository;

    public ComputerService(ComputerRepository computerRepository){
        this.computerRepository = computerRepository;
    }

    public void makeRandomNumber(){
        computerRepository.makeRandomNumber();
    }

    public void getNumberResult(List<Integer> userNumber){
        StrikeAndBallDTO strikeAndBall =  computerRepository.getStrikeAndBallDTO(userNumber);
    }

}
