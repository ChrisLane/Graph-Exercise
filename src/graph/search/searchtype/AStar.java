package graph.search.searchtype;

import graph.Node;
import graph.search.Search;
import graph.search.datatype.SearchPriorityQueue;
import graph.search.function.Distance;
import graph.search.function.Heuristic;
import graph.search.function.PriorityQueueCompare;
import maybe.Maybe;

public class AStar<A> {

    final SearchPriorityQueue<Node<A>> searchPriorityQueue;

    public AStar() {
        searchPriorityQueue = new SearchPriorityQueue<Node<A>>(new PriorityQueueCompare());
    }

    public Maybe<Node<A>> findNodeFrom(Node<A> startPos, Node<A> goalPos) {
        return new Search().findNodeFrom(startPos, goalPos, searchPriorityQueue, Heuristic.euclidean, Distance.manhattan);
    }

    public Maybe<Node<A>> findPathFrom(Node<A> startPos, Node<A> goalPos) {
        return new Search().findPathFrom(startPos, goalPos, searchPriorityQueue, Heuristic.euclidean, Distance.manhattan);
    }
}
