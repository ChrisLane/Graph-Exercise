package graph.search;

import graph.Coordinate;
import graph.Node;
import graph.search.datatypes.SearchStack;
import maybe.Maybe;

import java.util.ArrayDeque;
import java.util.Queue;

public class DFS<A> {

    SearchStack<Node<A>> searchStack;

    public DFS() {
        Queue<Node<A>> queue = new ArrayDeque<Node<A>>();
        searchStack = new SearchStack<Node<A>>();

    }

    public Maybe<Node<A>> findNodeFrom(Node<Coordinate> startPos, Node<Coordinate> goalPos) {
        return new Search().findNodeFrom(startPos, goalPos, searchStack);
    }

    public Maybe<Node<A>> findPathFrom(Node<Coordinate> startPos, Node<Coordinate> goalPos) {
        return new Search().findPathFrom(startPos, goalPos, searchStack);
    }
}
