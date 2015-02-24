package graph.search;

import graph.Coordinate;
import graph.Graph;
import graph.Node;
import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;
import maybe.Predicate;

import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.Set;

public class BFS<A> {

    public static void main(String args[]) {
        Graph<Coordinate> graph = new Graph<Coordinate>();
        final Coordinate startPos = new Coordinate(1, 1);
        final Coordinate goalPos = new Coordinate(5, 5);
        Node<Coordinate> x = graph.nodeWith(startPos);
        Predicate<Coordinate> p = new Predicate<Coordinate>() {
            @Override
            public boolean holds(Coordinate f) {
                return f.equals(goalPos);
            }
        };

        BFS<Coordinate> bfs = new BFS<Coordinate>();
        System.out.println(bfs.findNodeFrom(x, p));
    }

    public Maybe<Node<A>> findNodeFrom(Node<A> x, Predicate<A> p) {

        Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
        Queue<Node<A>> queue = new ArrayDeque<Node<A>>();

        queue.add(x);

        while (!queue.isEmpty()) {
            Node<A> current = queue.poll();

            if (visited.contains(current)) {
                if (p.holds(current.getContents()))
                    return new Just<Node<A>>(current);
                visited.add(current);
                for (Node<A> successor : current.getSuccessors()) {
                    queue.add(successor);
                }
            }
        }
        return new Nothing<Node<A>>();
    }
}