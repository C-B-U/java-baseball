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
    private int strikeCheck = 0;
    private boolean isStrike;
    private boolean isBall;

    private static int VAILDBALLCOUNT = 3;
    public static StringBuilder sb;

    public void makeBall() {
        computer = new ArrayList<>();
        while (computer.size() < VAILDBALLCOUNT) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }
    }

    public void inputBall() {
        user = new ArrayList<>();
        String input = Console.readLine();
        input = input.trim();
        if (input.length() != VAILDBALLCOUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INPUTWRONGCOUNT.getMessage());
        }
        for (int i = 0; i < VAILDBALLCOUNT; i++) {
            int num = input.charAt(i) - '0';
            if (user.contains(num)) {
                throw new IllegalArgumentException(ExceptionMessage.INPUTDUPLICATENUMBER.getMessage());
            }
            if (!ValidRangeCheck.VALIDNUMBERRANGE.checkValidRange(num)) {
                throw new IllegalArgumentException(ExceptionMessage.INPUTWRONGNUMBER.getMessage());
            }
            user.add(num);
        }
    }

    public boolean checkNothing() {
        strike = 0;
        ball = 0;
        sb = new StringBuilder();
        isStrike = checkStrike();
        isBall = checkBall();
        strikeBallCount();
        return !(isStrike || isBall);
    }

    public boolean checkStrike() {
        copyList();
        for (int i = 0; i < VAILDBALLCOUNT; i++) {
            if (computer.get(i).equals(check.get(i))) {
                check.set(i, strikeCheck);
                strike++;
            }
        }
        return strike > 0;
    }

    private void copyList() {
        check = new ArrayList<>();
        check.addAll(user);
    }

    public boolean checkBall() {
        for (int i = 0; i < VAILDBALLCOUNT; i++) {
            if (computer.contains(check.get(i))) {
                ball++;
            }
        }
        return ball > 0;
    }

    public void strikeBallCount(){
        if (ball > 0) {
            sb.append(ball + BallCheck.BALL.getMessage()).append(" ");
        }
        if (strike > 0) {
            sb.append(strike + BallCheck.STRIKE.getMessage());
        }
    }

    public boolean checkResult() {
        if (strike == VAILDBALLCOUNT) {
            return true;
        }
        return false;
    }

    public boolean gameStatus() {
        String input = Console.readLine();
        input = input.trim();
        if (input.equals(GameCheck.RESTART.getMessage())) {
            return true;
        } else if (input.equals(GameCheck.QUIT.getMessage())) {
            return false;
        } else {
            throw new IllegalArgumentException(ExceptionMessage.INPUTWRONGNUMBER.getMessage());
        }
    }
}
