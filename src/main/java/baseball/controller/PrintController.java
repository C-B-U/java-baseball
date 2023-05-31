package baseball.controller;

public class PrintController {
    private static final String ASK_RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";

    public void askGameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    public void successGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printResult(String reply) {
        System.out.println(reply);
    }
}
