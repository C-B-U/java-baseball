package baseball;

import java.util.function.Predicate;

public enum ValidRangeCheck {
    VALID_NUMBER_RANGE(num -> num >= 1 && num <= 9),
    VALID_GAME_STATUS_RANGE(num -> num.equals(1) || num.equals(2));

    private final Predicate<Integer> checkFunc;

    ValidRangeCheck(Predicate<Integer> checkFunc) {
        this.checkFunc = checkFunc;
    }

    public boolean checkInvalidRange(int num) {
        return !checkFunc.test(num);
    }
}
