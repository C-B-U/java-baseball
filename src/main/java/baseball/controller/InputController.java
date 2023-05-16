package baseball.controller;

import baseball.repository.AnswerRepository;
import baseball.service.BaseballService;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    private final AnswerRepository answerRepository = new AnswerRepository();
    private final BaseballService baseballService = new BaseballService();

    public void requireAnswer() {
        answerRepository.makeAnswer();
    }

    public void recieveUserAnswer() {
        String userAns = Console.readLine();
        answerRepository.setUerAnswer(userAns);
    }
    public String checkCorrect() {
        return baseballService.makeReply(answerRepository.getAnswer(), answerRepository.getUserAnswer());
    }



}
