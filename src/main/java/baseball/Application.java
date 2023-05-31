package baseball;


public class Application {

    Computer computer = new Computer();
    public static void main(String[] args) {
        // 게임 시작
        BaseballGame baseball = new BaseballGame();
        baseball.gameStart();

    }
}

