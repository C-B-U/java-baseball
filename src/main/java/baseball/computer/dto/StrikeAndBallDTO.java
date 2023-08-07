package baseball.computer.dto;

public class StrikeAndBallDTO {

    private final Long strike;
    private final Long ball;

    public StrikeAndBallDTO(Long strike, Long ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Long getStrike() {
        return strike;
    }

    public Long getBall() {
        return ball;
    }
}
