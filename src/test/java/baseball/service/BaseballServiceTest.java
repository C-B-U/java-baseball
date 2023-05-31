package baseball.service;

import baseball.repository.AnswerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballServiceTest {

    static AnswerRepository repository;
    static BaseballService service;


    @BeforeEach
    void setUp() {
        service = new BaseballService();
    }

    @Test
    void testStringReply() {
        List<Integer> answer = Arrays.asList(7, 1, 3);
        List<Integer> userTryList = Arrays.asList(1, 2, 3);
        String expected = "1볼 1스트라이크";
        Map<String, Integer> result = service.makeReply(answer, userTryList);
        assertThat(result.equals(Map.of("볼", 1, "스트라이크", 1)));

    }


}