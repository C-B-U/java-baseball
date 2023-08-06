package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("BaseballService 의")
class BaseballServiceTest {
    private final BaseballRepository baseballRepository = new BaseballRepository();
    private final BaseballService baseballService = new BaseballService(baseballRepository);


    @Test
    @DisplayName("정답 저장 로직이 수행되는가")
    void saveAnswer() {
        //given

        //when
        baseballService.saveAnswer();

        //then
        final Answer currentAnswer = baseballRepository.findCurrentAnswer();
        assertThat(currentAnswer).isNotNull();
    }

    @Nested
    @DisplayName("결과 계산 로직 중")
    class CalculateResult {
        @Test
        @DisplayName("3스트라이크 결과 반환이 수행되는가")
        void threeStrike() {
            //given
            baseballService.saveAnswer();
            final Answer currentAnswer = baseballRepository.findCurrentAnswer();
            final Integer first = currentAnswer.findByIndex(0);
            final Integer second = currentAnswer.findByIndex(1);
            final Integer third = currentAnswer.findByIndex(2);

            //when
//            final BallCount ballCount = baseballService.calculateResult(Integer.toString(first) + Integer.toString(second) + Integer.toString(third));

            //then
//            assertThat(ballCount).isEqualTo(BallCount.THREE_STRIKE);
        }

        @Test
        @DisplayName("3볼 결과 반환이 수행되는가")
        void threeBall() {
            //given
            baseballService.saveAnswer();
            final Answer currentAnswer = baseballRepository.findCurrentAnswer();
            final Integer first = currentAnswer.findByIndex(0);
            final Integer second = currentAnswer.findByIndex(1);
            final Integer third = currentAnswer.findByIndex(2);

            //when
//            final BallCount ballCount = baseballService.calculateResult(Integer.toString(third) + Integer.toString(first) + Integer.toString(second));

            //then
//            assertThat(ballCount).isEqualTo(BallCount.THREE_BALL);
        }

        @Test
        @DisplayName("2볼 1스트라이크 결과 반환이 수행되는가")
        void oneStrikeTwoBall() {
            //given
            baseballService.saveAnswer();
            final Answer currentAnswer = baseballRepository.findCurrentAnswer();
            final Integer first = currentAnswer.findByIndex(0);
            final Integer second = currentAnswer.findByIndex(1);
            final Integer third = currentAnswer.findByIndex(2);

            //when
//            final BallCount ballCount = baseballService.calculateResult(Integer.toString(first) + Integer.toString(third) + Integer.toString(second));

            //then
//            assertThat(ballCount).isEqualTo(BallCount.TWO_BALL_ONE_STRIKE);
        }
    }
}
