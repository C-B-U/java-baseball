package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGame {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String FINISH_MESSAGE = "게임을 종료합니다.";

    private Computer computer;
    private Player player;
    private List<Integer> playNumber;

    private void initGame() {
        System.out.println(START_MESSAGE);
        computer = new Computer();
        player = new Player();
    }

    public void startGame() {
        initGame();
        while(true) {
            playNumber = player.playerInput();
            System.out.println(computer.compareWithUserNumber(playNumber));
            if (computer.compareWithUserNumber(playNumber).equals("3스트라이크")) {
                System.out.println(STRIKE_MESSAGE+"\n"+RESTART_MESSAGE);
                if (Console.readLine().equals("1")) {
                    restartGame();
                    continue;
                }
                finishGame();
                break;
            }
        }
    }

    public void finishGame() {
        System.out.println(FINISH_MESSAGE);
    }

    public void restartGame() {
        startGame();
    }
}