package baseball;

import baseball.Model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelTest {

    @Test
    void 랜덤_숫자_생성() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Numbers computerNumbers = randomNumberGenerator.getRandomNumbers();
        assertThat(computerNumbers.hasSize(3)).isTrue();
    }

    @Test
    void 사용자_입력() {
        List<Integer> userInput = List.of(1, 2, 3);
        Numbers numbers = new Numbers(userInput);
        User user = new User(numbers);
        Numbers userNumber = user.getUserInputNumber();
        assertThat(userNumber.getNumbers()).isEqualTo(userInput);
    }

    @Test
    void 스트라이크_확인_기능() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Numbers userInput = randomNumberGenerator.getRandomNumbers();
        User user = new User(userInput);
        StrikeAndBallCount strikeAndBallCount = new StrikeAndBallCount(randomNumberGenerator, user);

        GameResult result = strikeAndBallCount.calculateBallAndStrikeCount();

        assertThat(result.isNotThreeStrike()).isFalse();
    }
}
