package baseball.computer.controller;

import baseball.computer.service.ComputerService;
import baseball.user.controller.User;
import baseball.user.service.UserService;

public class GameStart {

    private final ComputerService computerService;

    public GameStart (ComputerService computerService){
        this.computerService = computerService;
    }

    User user = new User(new UserService());
    public void gameStart(){
        computerService.makeRandomNumber();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true){
            computerService.getNumberResult(user.userNumber());
        }

    }


}
