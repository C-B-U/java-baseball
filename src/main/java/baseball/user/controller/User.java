package baseball.user.controller;

import baseball.user.exeption.InputValidator;
import baseball.user.service.UserService;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {

    private final UserService userService;

    public User(UserService userService){
        this.userService = userService;
    }

    public List<Integer> userNumber(){
        InputValidator inputValidator = new InputValidator();
        System.out.println("숫자를 입력해주세요 : ");
        String userNumber = inputValidator.validateUserNumberCorrect(Console.readLine());
        return userService.userNumberIntegerList(userNumber);
    }
}
