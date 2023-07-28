package baseball.computer.controller;

import baseball.computer.service.ComputerService;
import baseball.user.controller.User;
import baseball.user.service.UserService;
import camp.nextstep.edu.missionutils.Console;
public class BaseballNumber {
    private final static String THREE_STRIKE = "3스트라이크";
    private final static String THREE_STRIKE_GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String START_GAME_OR_STOP_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final ComputerService computerService;

    public BaseballNumber(){
        this.computerService = new ComputerService();
    }

    public void gameStart(){
        computerService.makeRandomNumber();
        User user = new User(new UserService());
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean startGame = true;
        while (startGame){
            String strikeAndBallToString = computerService.getNumberResult(user.userNumber());
            startGame = checkCorrectNumber(strikeAndBallToString);
        }

    }

    private boolean checkCorrectNumber(String strikeAndBallToString){
        if (strikeAndBallToString.equals(THREE_STRIKE)){
            System.out.println(THREE_STRIKE_GAME_OVER);
            System.out.println(START_GAME_OR_STOP_GAME);
        }
        return isRestartGame(Console.readLine());
    }

    private boolean isRestartGame(String userStatus){
        return userStatus.equals("1");
    }


}
