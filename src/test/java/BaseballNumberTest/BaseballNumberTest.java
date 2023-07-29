package BaseballNumberTest;


import baseball.user.exeption.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseballNumberTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("4글자 이상 숫자를 입력했을 때")
    void inputOverThreeNumber(){
        Exception exception = assertThrows(IllegalArgumentException.class,
                () ->  inputValidator.validateUserNumberCorrect("1234"));
        assertEquals("숫자야구는 중복 안 되는 3글자 입니다.", exception.getMessage());
    }
}
