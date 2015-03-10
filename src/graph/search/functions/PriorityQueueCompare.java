package graph.search.functions;

import graph.Node;

import java.util.Comparator;

public class PriorityQueueCompare<A> implements Comparator<Node<A>> {
    @Override
    public int compare(Node<A> node1, Node<A> node2) {
        return (int) (node1.getF() - node2.getF());
    }
}
