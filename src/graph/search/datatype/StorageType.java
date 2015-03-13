package graph.search.datatype;

import graph.Node;

public interface StorageType<A> {

    Node<A> getHead();

    void add(Node<A> element);

    boolean isEmpty();

    boolean contains(Node<A> element);
}