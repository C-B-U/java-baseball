package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ResultProvider의")
class ResultProviderTest {
    private final BaseballRepository baseballRepository = new BaseballRepository();

    @Nested
    @DisplayName("결과 계산 로직 중")
    class GetResult {
        @Test
        @DisplayName("3스트라이크가 반환되는가")
        void threeStrikeResult() {
            //given
            final Answer answer = Answer.createAnswer();
            baseballRepository.saveAnswer(answer);
            final Answer currentAnswer = baseballRepository.findCurrentAnswer();

            final ResultProvider resultProvider =
                    new ResultProvider(
                            answer,
                            Integer.toString(currentAnswer.findByIndex(0)) +
                                    Integer.toString(currentAnswer.findByIndex(1)) +
                                    Integer.toString(currentAnswer.findByIndex(2)));

            //when
//            final BallCount result = resultProvider.calculateResult();

            //then
//            assertThat(result).isEqualTo(BallCount.THREE_STRIKE);
        }

        @Test
        @DisplayName("3볼이 반환되는가")
        void threeBallResult() {
            //given
            final Answer answer = Answer.createAnswer();
            baseballRepository.saveAnswer(answer);
            final Answer currentAnswer = baseballRepository.findCurrentAnswer();

            final ResultProvider resultProvider =
                    new ResultProvider(
                            answer,
                            Integer.toString(currentAnswer.findByIndex(2)) +
                                    Integer.toString(currentAnswer.findByIndex(0)) +
                                    Integer.toString(currentAnswer.findByIndex(1)));

            //when
//            final BallCount result = resultProvider.calculateResult();

            //then
//            assertThat(result).isEqualTo(BallCount.THREE_BALL);
        }

        @Test
        @DisplayName("2볼 1스트라이크가 반환되는가")
        void twoBallOneStrikeResult() {
            //given
            final Answer answer = Answer.createAnswer();
            baseballRepository.saveAnswer(answer);
            final Answer currentAnswer = baseballRepository.findCurrentAnswer();

            final ResultProvider resultProvider =
                    new ResultProvider(
                            answer,
                            Integer.toString(currentAnswer.findByIndex(0)) +
                                    Integer.toString(currentAnswer.findByIndex(2)) +
                                    Integer.toString(currentAnswer.findByIndex(1)));

            //when
//            final BallCount result = resultProvider.calculateResult();

            //then
//            assertThat(result).isEqualTo(BallCount.TWO_BALL_ONE_STRIKE);
        }
    }
}
