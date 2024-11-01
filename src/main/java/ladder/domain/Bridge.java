package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Bridge {
    private final List<Boolean> connections;

    public Bridge() {
        connections = new ArrayList<>();
    }

    public void connectSteps(int participantCount, ConnectionStrategy strategy) {
        IntStream.range(0, participantCount - 1)
                .forEach(index -> {
                    if (index > 0 && !connections.isEmpty() && connections.get(index - 1)) {
                        connections.add(false);
                        return;
                    }
                    connections.add(strategy.connect());
                });
    }

    public List<Boolean> getConnections() {
        return Collections.unmodifiableList(connections);
    }

}
