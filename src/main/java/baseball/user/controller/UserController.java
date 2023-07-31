package baseball.user.controller;

import baseball.user.exeption.InputValidator;
import baseball.user.service.UserService;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserController {

    private final UserService userService;

    public UserController(){
        this.userService = new UserService();
    }

    public List<Integer> inputNumber(){
        InputValidator inputValidator = new InputValidator();
        System.out.print("숫자를 입력해주세요 : ");
        String userNumber = inputValidator.validateUserNumberCorrect(Console.readLine());
        return userService.userNumberIntegerList(userNumber);
    }
}
