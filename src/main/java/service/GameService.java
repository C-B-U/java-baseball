package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.GameResult;

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
    public GameResult outputGameResult(String inputNumber, List<Integer> computerNumbers) {
        int strike = 0, ball = 0;

        List<Integer> inputNumbers = Arrays.asList(inputNumber.split("")).stream().map(Integer::parseInt).collect(Collectors.toList());
        for(int i = 0; i < 3; i++) {
            // if ~ else문 함수로 바꾸기
            if (computerNumbers.get(i).equals(inputNumbers.get(i))) {
                strike++;
            }
            else if (inputNumbers.get(i).equals(computerNumbers.get((i + 1) % 3)) || inputNumbers.get(i) == computerNumbers.get((i + 2) % 3)) {
                ball++;
            }
        }
        return new GameResult(strike, ball);
    }

    // 게임 재시작
    public boolean isRestartGame(String inputNum) {
        inputNum = inputNum.trim();
        if(!(inputNum.equals("1") || inputNum.equals("2")))
            throw new IllegalArgumentException();
        return inputNum.equals("1");
    }
}
