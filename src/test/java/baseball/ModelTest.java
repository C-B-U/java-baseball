package baseball;

import baseball.Model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelTest {

    @Test
    void 랜덤_숫자_생성_테스트() {
        Computer computer = new Computer();
        Numbers computerNumbers = computer.getRandomNumbers();
        assertThat(computerNumbers.hasSize(3)).isTrue();
    }

    @Test
    void 사용자_입력_테스트() {
        List<Integer> userInput = List.of(1, 2, 3);
        Numbers numbers = new Numbers(userInput);
        User user = new User(numbers);
        Numbers userNumber = user.getUserInputNumber();
        assertThat(userNumber.getNumbers()).isEqualTo(userInput);
    }

    @Test
    void 스트라이크_확인_기능_테스트() {
        Computer computer = new Computer();
        Numbers userInput = computer.getRandomNumbers();
        User user = new User(userInput);
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(computer, user);

        GameResult result = strikeAndBallCount.calculateBallAndStrikeCount();

        assertThat(result.isNotThreeStrike()).isFalse();
    }
}
