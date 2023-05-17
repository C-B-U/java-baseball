package baseball;

import controller.Controller;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현
        Controller controller = new Controller();
        controller.startGame();
    }
}
