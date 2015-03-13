package graph.search.searchtype;

import graph.Coordinate;
import graph.Graph;
import graph.Node;
import graph.search.function.Distance;
import graph.search.function.Heuristic;
import graph.search.function.PriorityQueueCompare;
import ilist.Cons;
import ilist.IList;
import ilist.Nil;
import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;

import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class AStar<A> {

    public static void main(String args[]) {
        Graph<Coordinate> graph = Graph.getGraph();
        final Coordinate startCoord = new Coordinate(0, 0);
        final Coordinate goalCoord = new Coordinate(5, 5);
        final Node<Coordinate> startPos = graph.nodeWith(startCoord);
        final Node<Coordinate> goalPos = graph.nodeWith(goalCoord);

        AStar<Coordinate> aStar = new AStar<Coordinate>();
        System.out.println(aStar.findNodeFrom(startPos, goalPos, Heuristic.manhattan, Distance.manhattan));
        System.out.println(aStar.findPathFrom(startPos, goalPos, Heuristic.manhattan, Distance.manhattan));
    }

    public Maybe<Node<A>> findNodeFrom(Node<A> startPos, Node<A> goalPos, Heuristic heuristicFunction, Distance distanceFunction) {
        Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
        Queue<Node<A>> pending = new PriorityQueue<Node<A>>(new PriorityQueueCompare<A>());

        startPos.setHeuristic(heuristicFunction.apply(startPos, goalPos)); // Apply heuristic to initial position
        startPos.setCost(0); // First position will always have a cost of zero

        pending.add(startPos); // Add the starting node of the graph to the queue

        while (!pending.isEmpty()) { // Run until there's no other nodes to check
            Node<A> current = pending.poll();

            if (!visited.contains(current)) {

                if (current.contentsEquals(goalPos.getContents()))
                    return new Just<Node<A>>(current); // Return node matching the goal
                visited.add(current); // Add node to visited so that it's not checked again

                for (Node<A> successor : current.getSuccessors()) {
                    if (!pending.contains(successor)) {
                        successor.setCost(current.getCost() + distanceFunction.apply(current, successor)); // Calculate and set the cost of traveling from current to successor
                        successor.setHeuristic(heuristicFunction.apply(successor, goalPos)); // Set the heuristic value to the successor for traveling to the goal
                        pending.add(successor); // Add successors to the current node to the queue to be checked
                    }
                }
            }
        }
        return new Nothing<Node<A>>(); // No node found matching goal
    }

    public Maybe<IList<Node<A>>> findPathFrom(Node<A> startPos, Node<A> goalPos, Heuristic heuristicFunction, Distance distanceFunction) {
        Set<Node<A>> visited = new LinkedHashSet<Node<A>>();
        Queue<Node<A>> pending = new PriorityQueue<Node<A>>(new PriorityQueueCompare<A>());
        IList<Node<A>> path = new Nil<Node<A>>();

        if (startPos.contentsEquals(goalPos.getContents()))
            return new Nothing<IList<Node<A>>>();

        startPos.setHeuristic(heuristicFunction.apply(startPos, goalPos)); // Apply heuristic to initial position
        startPos.setCost(0); // First position will always have a cost of zero

        pending.add(startPos); // Add the starting node of the graph to the queue

        while (!pending.isEmpty()) { // Run until there's no other nodes to check
            Node<A> current = pending.poll();

            if (!visited.contains(current)) {
                path = new Cons<Node<A>>(current, path); // Add the current node to the path

                if (current.contentsEquals(goalPos.getContents())) {
                    return new Just<IList<Node<A>>>(path.reverse()); // Return path since we've reached the goal
                }

                visited.add(current); // Add node to visited so that it's not checked again

                for (Node<A> successor : current.getSuccessors()) {
                    if (!pending.contains(successor)) {
                        successor.setCost(current.getCost() + distanceFunction.apply(current, successor)); // Calculate and set the cost of traveling from current to successor
                        successor.setHeuristic(heuristicFunction.apply(successor, goalPos)); // Set the heuristic value to the successor for traveling to the goal
                        pending.add(successor); // Add successors to the current node to the queue to be checked
                    }
                }
            }
        }
        return new Nothing<IList<Node<A>>>(); // No path found, return a path of Nothing
    }
}
