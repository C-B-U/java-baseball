package BaseballNumberTest;


import baseball.user.exeption.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
class InputValidateTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("4글자 이상 숫자를 입력했을 때")
    void inputOverThreeNumber(){
        assertThatThrownBy(() -> inputValidator.validateUserNumberCorrect("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 문자열을 입력했을 때")
    void inputNotNumber(){
        assertThatThrownBy(() -> inputValidator.validateUserNumberCorrect("박준수"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 숫자를 입력했을 때")
    void inputDuplicateNumber(){
        assertThatThrownBy(() -> inputValidator.validateUserNumberCorrect("151"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("0이 포함된 숫자를 입력했을 때")
    void inputZeroInNumber(){
        assertThatThrownBy(() -> inputValidator.validateUserNumberCorrect("109"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
