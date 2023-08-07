package baseball.computer.controller;

import baseball.computer.service.ComputerService;
import baseball.user.controller.UserController;
import camp.nextstep.edu.missionutils.Console;
public class GameController {
    private static final String RESTART_GAME = "1";
    private final ComputerService computerService;
    private final UserController userController;

    public GameController(){
        this.computerService = new ComputerService();
        this.userController = new UserController();
    }

    public void gameStart(){
        System.out.println(GameMessage.START_GAME);
        boolean isStartGame = true;
        while (isStartGame){
            String strikeAndBallResultMessage = computerService.getNumberResult(userController.inputNumber());
            System.out.println(strikeAndBallResultMessage);
            isStartGame = isThreeStrike(strikeAndBallResultMessage);
        }

    }

    private boolean isThreeStrike(String strikeAndBallToString){
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
