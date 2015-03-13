package graph.search.searchtype;

import graph.Coordinate;
import graph.Node;
import graph.search.Search;
import graph.search.datatype.SearchQueue;
import maybe.Maybe;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirst<A> {

    SearchQueue<Node<A>> searchQueue;

    public BreadthFirst() {
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
