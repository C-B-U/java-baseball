package baseball.service;

import baseball.PlayResult;

import java.util.Map;

public class StringReplyService {

    private static final int ZERO = 0;


    public String makeStringReply(Map<PlayResult, Integer> mapReply) {
        StringBuilder sb = new StringBuilder();
        if (mapReply.containsKey(PlayResult.NOTHING)) {
            return PlayResult.NOTHING.getPlayResult();
        }
        sb.append(makeBallString(mapReply));
        sb.append(makeStrikeString(mapReply));
        return sb.toString();
    }

    private String makeBallString(Map<PlayResult, Integer> mapReply) {
        if (mapReply.get(PlayResult.BALL) != ZERO) {
            return mapReply.get(PlayResult.BALL).toString() + PlayResult.BALL.getPlayResult() + " ";
        }
        return "";
    }
    private String makeStrikeString(Map<PlayResult, Integer> mapReply) {
        if (mapReply.get(PlayResult.STRIKE) != ZERO) {
            return mapReply.get(PlayResult.STRIKE).toString() + PlayResult.STRIKE.getPlayResult();
        }
        return "";
    }

}
