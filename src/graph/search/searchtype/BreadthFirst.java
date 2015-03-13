package graph.search.searchtype;

import graph.Node;
import graph.search.Search;
import graph.search.datatype.SearchQueue;
import maybe.Maybe;

public class BreadthFirst<A> {

    final SearchQueue<Node<A>> searchQueue;

    public BreadthFirst() {
        searchQueue = new SearchQueue();

    }

    public Maybe<Node<A>> findNodeFrom(Node<A> startPos, Node<A> goalPos) {
        return new Search().findNodeFrom(startPos, goalPos, searchQueue);
    }

    public Maybe<Node<A>> findPathFrom(Node<A> startPos, Node<A> goalPos) {
        return new Search().findPathFrom(startPos, goalPos, searchQueue);
    }
}
