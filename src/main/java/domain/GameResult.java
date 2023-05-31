package domain;

public class GameResult {
    // enum으로 게임 결과 도출
    enum GameResultMessage {
        GAME_OUT_MESSAGE("낫싱");

        private final String getGameResult;

        GameResultMessage(String gameResultMessage) {
            getGameResult = gameResultMessage;
        }

    }

    private int strike;
    private int ball;
    private static String NOTHING = "낫싱";

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isGameSuccess() {
        return strike == 3;
    }

    // 게임 결과
    public static String makeGameResult(GameResult gameResult) {
        String output = "";
        if (gameResult.getStrike() == 0 && gameResult.getBall() == 0) {
            return NOTHING;
        }
        if (gameResult.getStrike() != 0) {
            output = gameResult.getStrike() + "스트라이크";
        }
        if (gameResult.getBall() > 0) {
            output = gameResult.getBall() + "볼 " + output;
        }
        return output.trim();
    }

    public static void gameResultMessage(GameResult gameResult) {
        System.out.println(makeGameResult(gameResult));
    }

}
