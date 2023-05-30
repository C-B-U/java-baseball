package domain;

public enum GameMessage {

    // enum으로 안내 문구 설정
        GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
        INPUT_NUMBER_MESSAGE("숫자를 입력해 주세요 : "),
        GAME_SUCCESS_MESSAGE("3개의 숫자를 모두 맞히셨습니다!\n게임 종료"),
        GAME_RESTART_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        private final String getGameMessage;

        GameMessage(String gameMessage) {
            getGameMessage = gameMessage;
        }

        public String getGameMessage() {
            return getGameMessage;
        }
}
