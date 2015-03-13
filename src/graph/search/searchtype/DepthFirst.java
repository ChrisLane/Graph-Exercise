package graph.search.searchtype;

import graph.Node;
import graph.search.Search;
import graph.search.datatype.SearchStack;
import maybe.Maybe;

import java.util.ArrayDeque;
import java.util.Queue;

public class DepthFirst<A> {

    SearchStack<Node<A>> searchStack;

    public DepthFirst() {
        Queue<Node<A>> queue = new ArrayDeque<Node<A>>();
        searchStack = new SearchStack<Node<A>>();

    }

    public Maybe<Node<A>> findNodeFrom(Node<A> startPos, Node<A> goalPos) {
        return new Search().findNodeFrom(startPos, goalPos, searchStack);
    }

    public Maybe<Node<A>> findPathFrom(Node<A> startPos, Node<A> goalPos) {
        return new Search().findPathFrom(startPos, goalPos, searchStack);
    }
}
