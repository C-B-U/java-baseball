package baseball;

public enum RandomNumberRange {
    MIN(1),
    MAX(9),
    CIPHER(3);

    private final Integer num;

    RandomNumberRange(final Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }
}
