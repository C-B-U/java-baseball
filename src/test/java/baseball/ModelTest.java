package baseball;

import baseball.Model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelTest {

    @Test
    void 랜덤_숫자_생성_테스트() {
        Computer computer = new Computer();
        assertThat(computer.getRandomNumbers()).hasSize(3);
    }

    @Test
    void 사용자_입력_테스트() {
        List<Integer> userInput = new ArrayList<>();
        userInput.add(1);
        userInput.add(3);
        userInput.add(5);
        User user = new User(userInput);
        assertThat(user.getUserInputNumber()).isEqualTo(userInput);
    }

    @Test
    void 스트라이크_확인_기능_테스트() {
        Computer computer = new Computer();
        List<Integer> userInput = computer.getRandomNumbers();
        User user = new User(userInput);
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(computer, user);

        GameResult result = strikeAndBallCount.calculateBallAndStrikeCount();

        assertThat(result.isNotThreeStrike()).isTrue();
    }
}
