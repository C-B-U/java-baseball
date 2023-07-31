package baseball.user.controller;

import baseball.user.exeption.InputValidator;
import baseball.user.service.UserService;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class UserController {

    private static final String INPUT_USER_NUMBER = "숫자를 입력해주세요 : ";
    private final UserService userService;
    private final InputValidator inputValidator;

    public UserController(){
        this.userService = new UserService();
        this.inputValidator = new InputValidator();
    }

    public List<Integer> inputNumber(){
        System.out.print(INPUT_USER_NUMBER);
        String userNumber = inputValidator.validateUserNumberCorrect(Console.readLine());
        return userService.userNumberIntegerList(userNumber);
    }
}
