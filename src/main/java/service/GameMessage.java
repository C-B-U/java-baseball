package service;

import domain.GameResult;

public class GameMessage {
    private static String START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    private static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    private static String OUT_MESSAGE = "낫싱";

    public static void startMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void inputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public static void gameEndMessage() {
        System.out.println(SUCCESS_MESSAGE);
    }

    public static void restartMessage() {
        System.out.println(RESTART_MESSAGE);
    }

    public static String gameResult(GameResult gameResult) {
        String output = "";
        if (gameResult.getStrike() == 0 && gameResult.getBall() == 0) {
            return OUT_MESSAGE;
        }

        if (gameResult.getStrike() != 0) {
            output = gameResult.getStrike() + "스트라이크";
        }
        if (gameResult.getBall() > 0) {
            output = gameResult.getBall() + "볼" + output;
        }
        return output.trim();
    }

    public static void output(GameResult gameResult) {
        System.out.println(gameResult(gameResult));
    }
}
