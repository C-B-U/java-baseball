package baseball;

import baseball.Model.Computer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelTest {

    @Test
    void 랜덤_숫자_생성_테스트() {
        Computer computer = new Computer();
        assertThat(computer.getRandomNumbers()).hasSize(3);
    }
}
