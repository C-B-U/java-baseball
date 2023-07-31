package baseball.computer.controller;

import baseball.computer.service.ComputerService;
import baseball.user.controller.UserController;
import camp.nextstep.edu.missionutils.Console;
public class GameController {
    private static final String RESTART_GAME = "1";
    private final ComputerService computerService;
    private final UserController user;

    public GameController(){
        this.computerService = new ComputerService();
        this.user = new UserController();
    }

    public void gameStart(){
        System.out.println(GameMessage.START_GAME);
        boolean isStartGame = true;
        while (isStartGame){
            String strikeAndBallToString = computerService.getNumberResult(user.inputNumber());
            System.out.println(strikeAndBallToString);
            isStartGame = checkCorrectNumber(strikeAndBallToString);
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
        if (userStatus.equals(RESTART_GAME)){
            computerService.remakeRandomNumber();
            return true;
        }
        return false;
    }


}
