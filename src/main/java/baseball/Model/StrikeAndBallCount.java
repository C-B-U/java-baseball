package baseball.Model;

public class StrikeAndBallCount {

    private final RandomNumberGenerator randomNumberGenerator;
    private final User user;
    private final static Integer NUMBERS_LENGTH = 3;


    public StrikeAndBallCount(RandomNumberGenerator randomNumberGenerator, User user) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.user = user;
    }

    public GameResult calculateBallAndStrikeCount() {
        GameResult result = new GameResult();
        for (int position = 0; position < NUMBERS_LENGTH; position++) {
            BallStatus ballStatus = decideBallStatus(position);
            int ballCount = result.getPlusOne(ballStatus);
            result.set(ballStatus, ballCount);
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
        Numbers computerNumber = randomNumberGenerator.getRandomNumbers();
        int userNumber = user.getByPosition(position);
        return computerNumber.contains(userNumber);
    }

    private boolean isSamePosition(int position) {
        int computerNumber = randomNumberGenerator.getByPosition(position);
        int userNumber = user.getByPosition(position);
        return computerNumber == userNumber;
    }
}
