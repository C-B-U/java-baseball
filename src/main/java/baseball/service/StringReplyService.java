package baseball.service;

import baseball.PlayResult;

import java.util.Map;

import static baseball.PlayResult.*;
import static baseball.PlayResult.STRIKE;

public class StringReplyService {

    public String makeStringReply(Map<PlayResult, Integer> mapReply) {
        StringBuilder sb = new StringBuilder();
        if (mapReply.containsKey(NOTHING)) {
            return NOTHING.toString();
        }
        sb.append(makeBallString(mapReply));
        sb.append(makeStrikeString(mapReply));
        return sb.toString();
    }

    private String makeBallString(Map<PlayResult, Integer> mapReply) {
        if (mapReply.get(BALL) != 0) {
            return mapReply.get(BALL).toString() + BALL + " ";
        }
        return "";
    }
    private String makeStrikeString(Map<PlayResult, Integer> mapReply) {
        if (mapReply.get(STRIKE) != 0) {
            return mapReply.get(STRIKE).toString() + STRIKE;
        }
        return "";
    }

}
