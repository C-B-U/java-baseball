package BaseballNumberTest;

import baseball.computer.repository.ComputerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

class RandomNumberTest {



    @Test
    @DisplayName("랜덤된 3자리 숫자가 제대로 생성이 되는지")
    void makeRandomNumber(){
        //given
        ComputerRepository computerRepository = new ComputerRepository();

        //when
        List<Integer> randomNumber =  computerRepository.makeRandomNumber();

        //then
        assertThat(randomNumber.size()).isEqualTo(3);
    }

}
