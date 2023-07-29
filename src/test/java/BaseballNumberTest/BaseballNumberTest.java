package BaseballNumberTest;


import baseball.user.exeption.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseballNumberTest {

    InputValidator inputValidator = new InputValidator();
    private static final String CHECK_USER_NUMBER = "숫자야구는 중복 안 되는 1~9 까지의 3글자 입니다.";

    @Test
    @DisplayName("4글자 이상 숫자를 입력했을 때")
    void inputOverThreeNumber(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () ->  inputValidator.validateUserNumberCorrect("1234"));
        assertEquals(CHECK_USER_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 문자열을 입력했을 때")
    void inputNotNumber(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateUserNumberCorrect("박준수"));
        assertEquals(CHECK_USER_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("중복된 숫자를 입력했을 때")
    void inputDuplicateNumber(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateUserNumberCorrect("111"));
        assertEquals(CHECK_USER_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("0이 포함된 숫자를 입력했을 때")
    void inputZeroInNumber(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> inputValidator.validateUserNumberCorrect("109"));
        assertEquals(CHECK_USER_NUMBER, exception.getMessage());
    }


}
