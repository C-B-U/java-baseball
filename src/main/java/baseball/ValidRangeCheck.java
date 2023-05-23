package baseball;

import java.util.function.Function;

public enum ValidRangeCheck {
    VALIDNUMBERRANGE(num -> num >= 1 && num <= 9);

    private final Function<Integer, Boolean> checkFunc;

    ValidRangeCheck(Function<Integer, Boolean> checkFunc) {
        this.checkFunc = checkFunc;
    }

    public boolean checkValidRange(int num) {
        if (checkFunc.apply(num)) {
            return true;
        }
        return false;
    }
}
