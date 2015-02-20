package graph;

import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.function.Predicate;

public class BFS<A> {

    public Maybe<Node<A>> findNodeFrom(Node<A> x, Predicate<A> p) {
        Set<Node<A>> visited = new HashSet<>();
        Queue<Node<A>> queue = new ArrayDeque<>();

        queue.add(x);

        while (!queue.isEmpty()) {
            Node<A> current = queue.poll();

            if (visited.contains(current)) {
                if (current.getNodeContent() == p)
                    return new Just<>(current);
                visited.add(current);
                for (int i = 0; i < current.getSuccessors().size(); i++) {
                    queue.add(current.getSuccessors().head());
                }
            }
        }
        return new Nothing<>();
    }
}
