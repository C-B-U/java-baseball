package baseball.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrikeAndBallCount {

    private final Computer computer;
    private final User user;
    private final static Integer NUMBERS_LENGTH = 3;


    public StrikeAndBallCount(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public Map<BallStatus, Integer> calculateBallAndStrikeCount() {
        Map<BallStatus, Integer> result = new HashMap<>();
        for (int position = 0; position < NUMBERS_LENGTH; position++) {
            BallStatus ballStatus = decideBallStatus(position);
            int ballCount = result.getOrDefault(ballStatus, 0);
            result.put(ballStatus, ballCount+1);
        }
        return result;
    }

    private BallStatus decideBallStatus(int position) {
        if (hasNumber(position)) {
            return decideBallOrStrike(position);
        }
        return BallStatus.NOTHING;
    }

    private BallStatus decideBallOrStrike(int position) {
        if(isSamePosition(position)) {
            return BallStatus.STRIKE;
        }
        return BallStatus.BALL;
    }
    private boolean hasNumber(int position) {
        List<Integer> computerNumber = computer.getRandomNumbers();
        int userNumber = user.getByPosition(position);
        return computerNumber.contains(userNumber);
    }

    private boolean isSamePosition(int position) {
        int computerNumber = computer.getByPosition(position);
        int userNumber = user.getByPosition(position);
        return computerNumber == userNumber;
    }

    public boolean isThreeStrike(Map<BallStatus, Integer> map) {
        return map.getOrDefault(BallStatus.STRIKE, 0) == 3;
    }
}
