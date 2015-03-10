package graph.search;

import graph.Coordinate;
import graph.Graph;
import graph.Node;
import ilist.Cons;
import ilist.IList;
import ilist.Nil;
import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;
import maybe.Predicate;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirst<A> {

    public static void main(String args[]) {
        Graph<Coordinate> graph = Graph.getGraph();
        final Coordinate startPos = new Coordinate(1, 1);
        final Coordinate goalPos = new Coordinate(5, 5);
        Node<Coordinate> x = graph.nodeWith(startPos);
        Predicate<Coordinate> p = new Predicate<Coordinate>() {
            @Override
            public boolean holds(Coordinate f) {
                return f.equals(goalPos);
            }
        };

        DepthFirst<Coordinate> depthFirst = new DepthFirst<Coordinate>();
        System.out.println(depthFirst.findNodeFrom(x, p));
        System.out.println(depthFirst.findPathFrom(x, p));
    }

    /**
     * Finds a given goal node in the form of predicate p from starting node x of a graph
     *
     * @param x The node of a graph to start the search from
     * @param p The predicate that must be met for a node to be returned
     * @return The node that matches the predicate p found from x if one was found
     */
    public Maybe<Node<A>> findNodeFrom(Node<A> x, Predicate<A> p) {

        Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
        Stack<Node<A>> stack = new Stack<Node<A>>();

        stack.push(x); // Add the starting node of the graph to the queue

        while (!stack.isEmpty()) {
            Node<A> current = stack.pop();

            if (!visited.contains(current)) {
                if (p.holds(current.getContents()))
                    return new Just<Node<A>>(current); // Return node matching the predicate
                visited.add(current);
                for (Node<A> successor : current.getSuccessors()) {
                    stack.add(successor);
                }
            }
        }
        return new Nothing<Node<A>>(); // No node found matching the predicate so return nothing
    }

    /**
     * Finds and returns the path to a node matching predicate p found from node x of a graph
     *
     * @param x The node of a graph to start the search from
     * @param p The predicate that must be met for a node to be returned
     * @return The path to a node that matches the predicate p found from x if one was found
     */
    public Maybe<IList<Node<A>>> findPathFrom(Node<A> x, Predicate<A> p) {
        Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
        Stack<Node<A>> stack = new Stack<Node<A>>();
        IList<Node<A>> path = new Nil<Node<A>>();

        stack.push(x); // Add the starting node of the graph to the queue

        while (!stack.isEmpty()) {
            Node<A> current = stack.pop();

            if (!visited.contains(current)) {
                path = new Cons<Node<A>>(current, path); // Add the current node to the path

                if (p.holds(current.getContents())) {
                    System.out.println(path.size());
                    return new Just<IList<Node<A>>>(path.reverse()); // Return node matching the predicate
                }

                visited.add(current);

                for (Node<A> successor : current.getSuccessors()) {
                    stack.add(successor);
                }
            }
        }
        return new Nothing<IList<Node<A>>>(); // No node found matching the predicate so return nothing
    }
}