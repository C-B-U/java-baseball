package baseball.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class AnswerRepositoryTest {

    private static AnswerRepository repository;

    @BeforeEach
    void setUp() {
        repository = new AnswerRepository();
    }

    @Test
    void correctAnswer() {
        List<Integer> answer = repository.makeAnswer();
        for (int ans : answer) {
            assertThat(ans > 0 && ans < 10);
        }
    }

    @Test
    void stringToListUserAnswer() {
        String userTry = "926";
        List<Integer> answer = repository.setUerAnswer(userTry);
        List<Integer> expected = Arrays.asList(9, 2, 6);
        assertThat(answer.equals(expected));
    }


}