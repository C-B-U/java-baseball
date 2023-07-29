package BaseballNumberTest;

import baseball.computer.dto.StrikeAndBallDTO;
import baseball.computer.repository.ComputerNumber;
import baseball.computer.repository.ComputerRepository;
import baseball.computer.service.ResultMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


public class BaseballResultTest {

    ComputerRepository computerRepository = mock(ComputerRepository.class);

    @Test
    @DisplayName("1스트라이크")
    void checkOneStrike(){

        //given
        given(computerRepository.makeRandomNumber()).willReturn(List.of(2,4,7));
        ComputerNumber computerNumber = new ComputerNumber(List.of(2,4,7));

        //when
        Long strike = computerNumber.checkBaseballStrike(List.of(2,5,3));

        //then
        assertEquals(1, strike);

    }

    @Test
    @DisplayName("2볼")
    void checkTwoBall(){

        //given
        given(computerRepository.makeRandomNumber()).willReturn(List.of(2,4,7));
        ComputerNumber computerNumber = new ComputerNumber(List.of(2,4,7));

        //when
        Long ball = computerNumber.checkBaseballBall(List.of(4,7,9));

        //then
        assertEquals(2, ball);
    }

    @Test
    @DisplayName("1볼 1스트라이크")
    void checkOneBallOneStrike(){

        //given
        given(computerRepository.makeRandomNumber()).willReturn(List.of(2,4,7));
        ComputerNumber computerNumber = new ComputerNumber(List.of(2,4,7));

        //when
        Long ball = computerNumber.checkBaseballBall(List.of(4,5,7));
        Long strike = computerNumber.checkBaseballStrike(List.of(4,5,7));

        //then
        assertEquals(1, ball);
        assertEquals(1, strike);
    }

    @Test
    @DisplayName("3스트라이크")
    void checkThreeStrike(){

        //given
        given(computerRepository.makeRandomNumber()).willReturn(List.of(2,4,7));
        ComputerNumber computerNumber = new ComputerNumber(List.of(2,4,7));

        //when
        Long strike = computerNumber.checkBaseballStrike(List.of(2,4,7));

        //then
        assertEquals(3, strike);
    }

    @Test
    @DisplayName("스트라이크와 볼 DTO로 전달")
    void giveStrikeAndBallToDTO(){

        //given
        given(computerRepository.makeRandomNumber()).willReturn(List.of(2,4,7));
        ComputerNumber computerNumber = new ComputerNumber(List.of(2,4,7));
        Long ball = computerNumber.checkBaseballBall(List.of(457));
        Long strike = computerNumber.checkBaseballStrike(List.of(457));

        //when
        StrikeAndBallDTO strikeAndBallDTO = new StrikeAndBallDTO(ball, strike);

        //then
        assertThat(strikeAndBallDTO.getBall()).isEqualTo(ball);
        assertThat(strikeAndBallDTO.getStrike()).isEqualTo(strike);

    }

    @Test
    @DisplayName("스트라이크,볼 결과 메시지 확인")
    void strikeAndBallResultMessage(){

        //given
        StrikeAndBallDTO strikeAndBallDTO = new StrikeAndBallDTO(2L, 1L);
        ResultMessage resultMessage = new ResultMessage();

        //when
        String result = resultMessage.toString(strikeAndBallDTO.getStrike(), strikeAndBallDTO.getBall());

        //then
        assertThat(result).isEqualTo("1볼 2스트라이크");

    }


}
