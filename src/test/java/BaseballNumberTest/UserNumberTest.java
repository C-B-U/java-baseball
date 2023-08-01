package BaseballNumberTest;

import baseball.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserNumberTest {

    @Test
    @DisplayName("String 문자열을 List<Integer>로 변환")
    void userNameStringToListInteger(){
        //given
        UserService userService = new UserService();
        String numString = "123";
        List<Integer> numListInteger = List.of(1,2,3);

        //when
        List<Integer> result = userService.userNumberIntegerList(numString);

        //then
        assertThat(result).isEqualTo(numListInteger);

    }

}
