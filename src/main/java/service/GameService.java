package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.GameResult;

import java.util.*;
import java.util.stream.Collectors;

public class GameService {

    public List<Integer> computerNumbers() {
        List<Integer> answers = new ArrayList<Integer>();
        while (answers.size() < 3) {
            int randNum = Randoms.pickNumberInRange(1, 9);
            if (!answers.contains(randNum)) {
                answers.add(randNum);
            }
        }
        return answers;
    }

    public String validateInput(String input) {
        input = input.trim();

        boolean matches = input.matches("[1-9]{3}");
        Set<String> collect =
                Arrays.asList(input.split("")).stream().collect(Collectors.toSet());
        if(!matches || collect.size() != 3) {
            throw new IllegalArgumentException();
        } else {
            return input;
        }
    }

    public GameResult gameResult(String input, List<Integer> answers) {
        int strike = 0;
        int ball = 0;

        List<Integer> inputNumbers =
            Arrays.asList(input.split("")).stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        for (int i = 0; i < 3; i++) {
            if (answers.get(i).equals(inputNumbers.get(i))) {
                strike += 1;
            } else if (inputNumbers.get(i).equals(answers.get((i + 1) % 3)) || inputNumbers.get(i) == answers.get((i + 1) % 3)) {
                ball += 1;
            }
        }
        return new GameResult(strike, ball);
    }

    public boolean isRestart(String input) {
        input = input.trim();
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }
        return input.equals("1");
    }
}
