package service;

import baseball.BallCheck;
import baseball.GameCheck;
import baseball.GameMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GamePlayService {
    private List<Integer> computer;
    private List<Integer> user;
    private List<Integer> check;
    private int strike;
    private int ball;
    private int STRIKECHECK = 0;

    public void gameStart() {
        System.out.println(GameMessage.START_MESSAGE);
    }

    public void makeBall() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }
    }

    public void inputBall() {
        user = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int num = Integer.parseInt(Console.readLine());
            if (user.contains(num)) {
                throw new IllegalArgumentException("중복된 숫자를 입력했습니다.");
            }
            user.add(num);
        }
    }


    public void continueGame() {
        while (true) {
            System.out.print(GameMessage.INPUT_MESSAGE);
            inputBall();
            checkResult();
            if (checkResult()) {
                break;
            }
        }
        gameStatus();
    }


    public boolean checkResult() {
        strike = 0;
        ball = 0;

        checkStrike();
        checkBall();
        printResult();

        if (strike == 3) {
            return true;
        }

        return false;
    }

    private void printResult() {
        if (strike == 3) {
            System.out.println(GameMessage.SUCCESS_MESSAGE);
        } else if (strike > 0 && ball > 0) {
            System.out.println(ball + BallCheck.BALL.name() + " " + strike + BallCheck.STRIKE.name());
        } else if (strike > 0) {
            System.out.println(strike + BallCheck.STRIKE.name());
        } else if (ball > 0) {
            System.out.println(ball + BallCheck.BALL.name());
        } else {
            System.out.println(BallCheck.NOTHING);
        }
    }

    private void checkBall() {
        for (int i = 0; i < 3; i++) {
            if (computer.contains(check.get(i))) {
                ball++;
            }
        }
    }

    private void checkStrike() {
        Collections.copy(check, user);
        for (int i = 0; i < 3; i++) {
            if (check.get(i).equals(computer.get(i))) {
                check.set(i, STRIKECHECK);
                strike++;
            }
        }
    }

    public boolean gameStatus() {
        System.out.println(GameMessage.GAMESTATUS_MESSAGE);
        if (Console.readLine().equals(GameCheck.RESTART)) {
            return true;
        } else if (Console.readLine().equals(GameCheck.QUIT)) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }
}
