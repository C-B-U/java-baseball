package baseball.computer.controller;

import baseball.computer.service.ComputerService;
import baseball.user.controller.User;
import baseball.user.service.UserService;
import camp.nextstep.edu.missionutils.Console;
public class BaseballNumber {
    private final ComputerService computerService;

    public BaseballNumber(){
        this.computerService = new ComputerService();
    }

    public void gameStart(){
        User user = new User(new UserService());
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean startGame = true;
        while (startGame){
            String strikeAndBallToString = computerService.getNumberResult(user.inputNumber());
            System.out.println(strikeAndBallToString);
            startGame = checkCorrectNumber(strikeAndBallToString);
        }

    }

    private boolean checkCorrectNumber(String strikeAndBallToString){
        if (strikeAndBallToString.equals(GameMessage.THREE_STRIKE.toString())){
            System.out.println(GameMessage.THREE_STRIKE_GAME_OVER);
            System.out.println(GameMessage.START_GAME_OR_STOP_GAME);
            return isRestartGame(Console.readLine());
        }
        return true;
    }

    private boolean isRestartGame(String userStatus){
        if (userStatus.equals("1")){
            computerService.remakeRandomNumber();
            return true;
        }
        return false;
    }


}
