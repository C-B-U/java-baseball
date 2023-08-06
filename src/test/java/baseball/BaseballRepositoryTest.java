package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BaseRepository의")
class BaseballRepositoryTest {
    private final BaseballRepository baseballRepository =  new BaseballRepository();

    @Test
    @DisplayName("저장후 조회 로직이 수행되는가")
    void saveAnswerAndGet() {
        //given
        final Answer answer = Answer.createAnswer();

        //when
        baseballRepository.saveAnswer(answer);
        final Answer currentAnswer = baseballRepository.findCurrentAnswer();

        //then
        assertThat(answer).isEqualTo(currentAnswer);
    }
}
