package baseball.user.exeption;

import java.util.Set;
import java.util.stream.Collectors;

public class InputValidator {

    private static final String CHECK_USER_NUMBER = "숫자야구는 중복 안 되는 3글자 입니다.";
    private static final int USER_NUMBER_SiZE = 3;

    public String validateUserNumberCorrect(String userNumber){
        validateUserNumberSize(andDuplicate(userNumber));
        return userNumber;
    }

    private void validateUserNumberSize(Set<Character> userNumber){
        if(userNumber.size() != USER_NUMBER_SiZE){
            throw new IllegalArgumentException(CHECK_USER_NUMBER);
        }
    }

    private Set<Character> andDuplicate(String userNumber) {
        return userNumber.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toSet());
    }
}
