package graph;

import ilist.IList;
import maybe.Maybe;

import java.util.function.Predicate;

public class Node<A> {
    private A nodeContent;
    private IList<Node<A>> successors;

    Maybe<Node<A>> findNodeFrom(Node<A> x, Predicate<A> p) {

    }
}
