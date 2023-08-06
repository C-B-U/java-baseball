package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("InputValidator의")
class InputValidatorTest {
    private final InputValidator inputValidator = new InputValidator();

    @Nested
    @DisplayName("유저의 시도 검증 중")
    class ValidateUserAttempt {
        @Test
        @DisplayName("입력값 길이 검증이 수행되는가")
        void validateLength() {
            assertThatThrownBy(() -> inputValidator.validateUserAttempt("1234"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복 값 검증이 수행되는가")
        void validateDuplicate() {
            assertThatThrownBy(() -> inputValidator.validateUserAttempt("122"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("빈 값 검증이 수행되는가")
        void validateBlank() {
            assertThatThrownBy(() -> inputValidator.validateUserAttempt(""))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("정상 입력값 검증이 수행되는가")
        void validate() {
            inputValidator.validateUserAttempt("123");
            inputValidator.validateUserAttempt("275");
        }
    }

    @Nested
    @DisplayName("게임 이어서 하기 여부 검증 중")
    class ValidateIsContinue {
        @Test
        @DisplayName("입력값 길이 검증이 수행되는가")
        void validateLength() {
            assertThatThrownBy(() -> inputValidator.validateIsContinue("1234"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("입력값 범위 검증이 수행되는가")
        void validateRange() {
            assertThatThrownBy(() -> inputValidator.validateIsContinue("3"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("정상 입력값 검증이 수행되는가")
        void validate() {
            inputValidator.validateIsContinue("1");
            inputValidator.validateIsContinue("2");
        }
    }
}
