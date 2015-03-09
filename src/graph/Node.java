package graph;

// Minimal class for a particular implementation of directed graphs.
// All we include is what is necessary to build a graph, in the class
// graph.

import java.util.LinkedHashSet;
import java.util.Set;

public class Node<A> {

    private A contents;
    // Keep the implementation of sets open, by using the Set interface:
    private Set<Node<A>> successors;

    private double heuristic;
    private double cost;

    // We can only build a node with an empty set of getSuccessors:
    public Node(A contents) {
        this.contents = contents;
        // Choose any implementation of sets you please, but you need to
        // choose one.
        this.successors = new LinkedHashSet<Node<A>>();
    }

    // Hence we need this:
    public void addSuccessor(Node<A> s) {
        successors.add(s);
    }

    public boolean contentsEquals(A c) {
        return contents.equals(c);
    }

    // Get methods:
    public A getContents() {
        return contents;
    }

    public Set<Node<A>> getSuccessors() {
        return successors;
    }

    @Override
    public String toString() {
        return "[Node] " + contents.toString();
    }

    public double getF() {
        return heuristic + cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(double heuristic) {
        this.heuristic = heuristic;
    }


}
