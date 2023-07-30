package baseball.computer.controller;

public enum GameMessage {
    THREE_STRIKE("3스트라이크"),
    THREE_STRIKE_GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    START_GAME_OR_STOP_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String description;

    GameMessage(String description){
        this.description = description;
    }

    @Override
    public String toString(){
        return this.description;
    }

}
