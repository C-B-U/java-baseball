package baseball;

import baseball.View.InputValidator;
import baseball.View.Message;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {


    @Test
    void 글자수_예외_테스트() {
        String userInput = "1234";
        assertThatThrownBy(() -> InputValidator.isCorrectInput(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.INCORRECT_LENGTH_EXCEPTION.getMessage());
    }

    @Test
    void 숫자이외_문자_입력_예외_테스트() {
        String userInput = "12A";
        assertThatThrownBy(() -> InputValidator.isCorrectInput(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.NON_NUMERIC_INPUT_EXCEPTION.getMessage());
    }

    @Test
    void 중복_숫자_예외_테스트() {
        String userInput = "122";
        assertThatThrownBy(() -> InputValidator.isCorrectInput(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.DUPLICATE_NUMBER_EXCEPTION.getMessage());
    }

    @Test
    void 재시작_예외_테스트() {
        String userInput = "3";
        assertThatThrownBy(() -> InputValidator.isCorrectRestartInput(userInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Message.RESTART_INPUT_EXCEPTION.getMessage());
    }
}