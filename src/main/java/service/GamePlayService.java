package service;

import baseball.BallCheck;
import baseball.GameCheck;
import baseball.GameMessage;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GamePlayService {
    private static List<Integer> computer;
    private static List<Integer> user;
    private static List<Integer> check;
    private int strike;
    private int ball;
    private int STRIKECHECK = 0;

    public void gameStart() {
        System.out.println(GameMessage.START_MESSAGE.getMessage());
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

    private void inputBall() {
        System.out.print(GameMessage.INPUT_MESSAGE.getMessage());
        user = new ArrayList<>();
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 개수의 숫자를 입력했습니다.");
        }

        for (int i = 0; i < 3; i++) {
            int num = input.charAt(i) - '0';
            if (user.contains(num)) {
                throw new IllegalArgumentException("중복된 숫자를 입력했습니다.");
            } else if (num < 1 || num > 9) {
                throw new IllegalArgumentException("잘못된 숫자를 입력했습니다.");
            }
            user.add(num);
        }

    }

    public void continueGame() {
        while (true) {
            inputBall();
            checkResult();
            if (checkResult()) {
                break;
            }
        }
        gameStatus();
    }

    private boolean checkResult() {
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
            System.out.println(GameMessage.SUCCESS_MESSAGE.getMessage());
        } else if (strike > 0 && ball > 0) {
            System.out.println(ball + BallCheck.BALL.getMessage() + " " + strike + BallCheck.STRIKE.getMessage());
        } else if (strike > 0) {
            System.out.println(strike + BallCheck.STRIKE.getMessage());
        } else if (ball > 0) {
            System.out.println(ball + BallCheck.BALL.getMessage());
        } else {
            System.out.println(BallCheck.NOTHING.getMessage());
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
        check = new ArrayList<>();
        check.addAll(user);
        for (int i = 0; i < 3; i++) {
            if (check.get(i).equals(computer.get(i))) {
                check.set(i, STRIKECHECK);
                strike++;
            }
        }
    }

    public boolean gameStatus() {
        System.out.println(GameMessage.GAMESTATUS_MESSAGE.getMessage());
        String input = Console.readLine();
        input = input.trim();
        if (input.equals(GameCheck.RESTART.getGameCheck())){
            return true;
        } else if (input.equals(GameCheck.QUIT.getGameCheck())) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
        }
    }
}
