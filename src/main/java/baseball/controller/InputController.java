package baseball.controller;

import baseball.repository.AnswerRepository;
import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Map;

public class InputController {

    private static final String NOTHING = "낫싱";


    private BaseballService baseballService = new BaseballService();
    private AnswerRepository answerRepository = new AnswerRepository();

    private static final String STRIKE = "스트라이크";

    public void continueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        int continueGame = Integer.parseInt(Console.readLine());
        if (continueGame == 1) {
            requireAnswer();
        }
        if (continueGame == 2) {
            return;
        }
    }

    public void requireAnswer() {
        baseballService.makeAnswer();
        recieveUserAnswer();
    }

    public void recieveUserAnswer() {
        System.out.print("숫자를 입력해주세요 : ");
        String userAnswer = Console.readLine();
        baseballService.makeUserAnswer(userAnswer);
        checkCorrect();
    }


    public void checkCorrect() {
        Map<String, Integer> result = baseballService.makeReply(answerRepository.getAnswer(), answerRepository.getUserAnswer());
        System.out.println(baseballService.makeStringReply(result));
        if (result.containsKey(STRIKE) && result.get(STRIKE).equals(3)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            continueGame();
            return;
        }
        recieveUserAnswer();
    }
}
