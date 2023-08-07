package baseball.computer.service;

public enum BaseballMessage {

    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    BLANK(" ");

    private final String description;

    BaseballMessage(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return this.description;
    }

}
