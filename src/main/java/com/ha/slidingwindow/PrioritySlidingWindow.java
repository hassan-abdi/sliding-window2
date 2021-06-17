package com.ha.slidingwindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrioritySlidingWindow<T extends Comparable<T>> {
    private final int length;
    private final Queue<T> queue;

    public PrioritySlidingWindow(int length) {
        this.length = length;
        queue = new PriorityBlockingQueue<>();
    }

    public void add(T node) {
        queue.add(node);
    }

    public Stream<List<T>> sliding() {
        List<T> nodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            nodes.add(queue.remove());
        }
        return sliding(nodes, length);
    }

    private Stream<List<T>> sliding(List<T> list, int size) {
        if (size > list.size())
            return Stream.empty();
        return IntStream.range(0, list.size() - size + 1)
                .mapToObj(start -> list.subList(start, start + size));
    }
}