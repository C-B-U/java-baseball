package baseball.computer.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class ComputerService {

    private List<Integer> computerNumber;

    public void makeRandomNumber(){
        computerNumber = Randoms.pickUniqueNumbersInRange(1,9,3);
    }
}
