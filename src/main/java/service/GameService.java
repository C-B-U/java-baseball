package service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameService {

    // 컴퓨터 번호 설정
    public List<Integer> setComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
    // 사용자 번호 검증
    public String validateInputNumber(String inputNumber) {
        inputNumber = inputNumber.trim();

        boolean matches = inputNumber.matches("[1-9]{3}");
        Set<String> collect = Arrays.asList(inputNumber.split("")).stream().collect(Collectors.toSet());

        if(!matches || collect.size() != 3) {
            throw new IllegalArgumentException();
        }
        return inputNumber;
    }

    // 결과 도출

    // 게임 재시작
}
