package graph.search.datatype;

import graph.Node;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SearchPriorityQueue<A> implements StorageType{
    Queue<Node<A>> priorityQueue;

    public SearchPriorityQueue(Comparator comparator) {
        priorityQueue =new PriorityQueue<Node<A>>(comparator);
    }

    @Override
    public Node getHead() {
        return priorityQueue.poll();
    }

    @Override
    public void add(Node element) {
        priorityQueue.add(element);
    }

    @Override
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    @Override
    public boolean contains(Node element) {
        return priorityQueue.contains(element);
    }
}
