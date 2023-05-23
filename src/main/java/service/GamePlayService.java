package service;

import baseball.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class GamePlayService {
    private List<Integer> computer;
    private List<Integer> user;
    private List<Integer> check;

    private int strike;
    private int ball;
    private String input;
    private int inputNum;

    public StringBuilder sb;

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

    public void inputBall() {
        user = new ArrayList<>();
        input = Console.readLine().trim();
        for (int i = 0; i < validBallCount; i++) {
            inputNum = input.charAt(i) - '0';
            if (checkValidation()) {
                user.add(inputNum);
            }
        }
    }

    private boolean checkValidation() {
        return validateCount() && validateDuplication() && validateRange();
    }

    private boolean validateCount() {
        if (input.length() != validBallCount) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_WRONG_COUNT.getMessage());
        }
        return true;
    }

    private boolean validateDuplication() {
        if (user.contains(inputNum)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_DUPLICATE_NUMBER.getMessage());
        }
        return true;
    }

    private boolean validateRange() {
        if (ValidRangeCheck.VALID_NUMBER_RANGE.checkInvalidRange(inputNum)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_WRONG_NUMBER.getMessage());
        }
        return true;
    }

    public boolean checkResult() {
        strike = ball = 0;
        sb = new StringBuilder();
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

    public void strikeBallCount() {
        hasBall();
        hasStrike();
        isNothing();
    }

    private void hasBall() {
        if (ball > 0) {
            sb.append(ball).append(BallCheck.BALL.getMessage()).append(" ");
        }
    }

    private void hasStrike() {
        if (strike > 0) {
            sb.append(strike).append(BallCheck.STRIKE.getMessage());
        }
    }

    private void isNothing() {
        if (strike == 0 && ball == 0) {
            sb.append(BallCheck.NOTHING.getMessage());
        }
    }

    public boolean gameStatus() {
        input = Console.readLine().trim();
        int status = Integer.parseInt(input.trim());
        if (ValidRangeCheck.VALID_GAME_STATUS_RANGE.checkInvalidRange(status)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_WRONG_NUMBER.getMessage());
        }
        return input.equals(GameCheck.RESTART.getMessage());
    }
}
