package baseball;

import java.util.stream.Stream;

@FunctionalInterface
public interface CountProvider {
    Integer countOf(Stream<StrikeBall> strikeBall);
}
