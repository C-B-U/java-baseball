package baseball;

import baseball.controller.GameProcessController;
import baseball.controller.InputController;
import baseball.controller.PrintController;

public class Application {
    public static void main(String[] args) {
        GameProcessController gameProcessController = new GameProcessController(new InputController(), new PrintController());
        System.out.println("숫자 야구 게임을 시작합니다.");
        gameProcessController.makeGameAnswer();
    }
}
