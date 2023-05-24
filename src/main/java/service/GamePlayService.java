package service;

import baseball.*;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class GamePlayService {
    private List<Integer> computer;
    private List<Integer> user;
    private List<Integer> check;

    private int strike;
    private int ball;


    private static final int strikeChecked = 0;
    private static final int validBallCount = 3;

    public void makeBall() {
        computer = new ArrayList<>();
        while (computer.size() < validBallCount) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }
    }

    public void inputBall(String input) {
        user = new ArrayList<>();
        for (int i = 0; i < validBallCount; i++) {
            int inputNum = input.charAt(i) - '0';
            checkValidation(input, inputNum);
            user.add(inputNum);
        }
    }

    private void checkValidation(String input, int inputNum) {
        validateCount(input);
        validateDuplication(inputNum);
        validateRange(inputNum);
    }

    private void validateCount(String input) {
        if (input.length() != validBallCount) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_WRONG_COUNT.getMessage());
        }
    }

    private void validateDuplication(int inputNum) {
        if (user.contains(inputNum)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateRange(int inputNum) {
        if (ValidRangeCheck.VALID_NUMBER_RANGE.checkInvalidRange(inputNum)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_WRONG_NUMBER.getMessage());
        }
    }

    public boolean checkResult() {
        strike = ball = 0;
        checkStrike();
        checkBall();
        return strike == validBallCount;
    }

    private void checkStrike() {
        copyList();
        for (int i = 0; i < validBallCount; i++) {
            if (computer.get(i).equals(check.get(i))) {
                check.set(i, strikeChecked);
                strike++;
            }
        }
    }

    private void copyList() {
        check = new ArrayList<>();
        check.addAll(user);
    }

    private void checkBall() {
        for (int i = 0; i < validBallCount; i++) {
            if (computer.contains(check.get(i))) {
                ball++;
            }
        }
    }

    public void strikeBallCount(StringBuilder sb) {
        hasBall(sb);
        hasStrike(sb);
        isNothing(sb);
    }

    private void hasBall(StringBuilder sb) {
        if (ball > 0) {
            sb.append(ball).append(BallCheck.BALL.getMessage()).append(" ");
        }
    }

    private void hasStrike(StringBuilder sb) {
        if (strike > 0) {
            sb.append(strike).append(BallCheck.STRIKE.getMessage());
        }
    }

    private void isNothing(StringBuilder sb) {
        if (strike == 0 && ball == 0) {
            sb.append(BallCheck.NOTHING.getMessage());
        }
    }

    public boolean gameStatus(String input) {
        int status = Integer.parseInt(input);
        if (ValidRangeCheck.VALID_GAME_STATUS_RANGE.checkInvalidRange(status)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_WRONG_NUMBER.getMessage());
        }
        return input.equals(GameCheck.RESTART.getMessage());
    }
}
