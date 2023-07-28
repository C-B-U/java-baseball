package baseball.computer.service;

import baseball.computer.dto.StrikeAndBallDTO;
import baseball.computer.repository.ComputerRepository;

import java.util.List;

public class ComputerService {

    private final static String THREE_STRIKE = "3스트라이크";
    private final static String THREE_STRIKE_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String START_GAME_OR_STOP_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final ComputerRepository computerRepository;
    private final Message message;

    public ComputerService(ComputerRepository computerRepository, Message message){
        this.computerRepository = computerRepository;
        this.message = message;
    }

    public void makeRandomNumber(){
        computerRepository.makeRandomNumber();
    }

    public void getNumberResult(List<Integer> userNumber){
        StrikeAndBallDTO strikeAndBall = computerRepository.getStrikeAndBallDTO(userNumber);
        String strikeAndBallToString = message.toString(strikeAndBall.getStrike(), strikeAndBall.getBall());
        System.out.println(strikeAndBallToString);
        checkCorrectNumber(strikeAndBallToString);
    }

    private void checkCorrectNumber(String strikeAndBallToString){
        if (strikeAndBallToString.equals(THREE_STRIKE)){
            System.out.println(THREE_STRIKE_GAME_OVER);
            System.out.println(START_GAME_OR_STOP_GAME);
        }

    }

}
