package ladder.domain;

@FunctionalInterface
public interface ConnectionStrategy {
    boolean isConnect();
}
