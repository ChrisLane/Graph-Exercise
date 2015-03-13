package graph.search.datatype;

import graph.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class SearchQueue<A> implements StorageType{
    Queue<Node<A>> queue;

    public SearchQueue() {
        this.queue = new ArrayDeque<Node<A>>();
    }

    @Override
    public Node<A> getHead() {
        return queue.poll();
    }

    @Override
    public void add(Node element) {
        queue.add(element);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
