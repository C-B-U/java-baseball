package baseball.Model;

import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private final Map<BallStatus, Integer> result;
    private static final int FULL_STRIKE = 3;

    public GameResult() {
        this.result = new HashMap<>();
    }

    public Integer get(BallStatus key) {
        return result.getOrDefault(key, 0);
    }

    public void set(BallStatus key, Integer value) {
        result.put(key, value);
    }

    public boolean isNotThreeStrike() {
        return result.getOrDefault(BallStatus.STRIKE, 0) != FULL_STRIKE;
    }
}