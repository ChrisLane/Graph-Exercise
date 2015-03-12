package graph.search;

import graph.Coordinate;
import graph.Node;
import graph.search.datatypes.SearchQueue;
import maybe.Maybe;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS<A> {

    SearchQueue<Node<A>> searchQueue;

    public BFS() {
        Queue<Node<A>> queue = new ArrayDeque<Node<A>>();
        searchQueue = new SearchQueue();

    }

    public Maybe<Node<A>> findNodeFrom(Node<Coordinate> startPos, Node<Coordinate> goalPos) {
        return new Search().findNodeFrom(startPos, goalPos, searchQueue);
    }

    public Maybe<Node<A>> findPathFrom(Node<Coordinate> startPos, Node<Coordinate> goalPos) {
        return new Search().findPathFrom(startPos, goalPos, searchQueue);
    }
}
