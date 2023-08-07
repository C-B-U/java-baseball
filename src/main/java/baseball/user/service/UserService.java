package baseball.user.service;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    public List<Integer> userNumberIntegerList(String userNumber){
        return userNumber.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
