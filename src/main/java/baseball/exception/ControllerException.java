package baseball.exception;

public class ControllerException {

    public void rightResponse(int response) {
        if(response != 1 && response != 2) {
            throw new IllegalArgumentException("Continue game signal is not supported");
        }
    }
}
