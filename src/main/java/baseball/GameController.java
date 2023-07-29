package baseball;

import baseball.Model.Computer;
import baseball.Model.User;
import baseball.View.InputView;

public class GameController {

    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {

        System.out.println("숫자 야구 게임을 시작합니다.");
        Computer computer = new Computer();
        User user = new User(inputView.readUserInput());
    }
}
