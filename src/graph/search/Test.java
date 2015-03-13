package graph.search;

import graph.Coordinate;
import graph.Graph;
import graph.Node;
import graph.search.searchtype.BreadthFirst;
import graph.search.searchtype.DeapthFirst;

public class Test {
    public static void main(String[] args) {

        Graph<Coordinate> graph = Graph.getGraph();
        Coordinate startCoord = new Coordinate(0, 0);
        Coordinate goalCoord = new Coordinate(5, 5);
        Node<Coordinate> startPos = graph.nodeWith(startCoord);
        Node<Coordinate> goalPos = graph.nodeWith(goalCoord);
        BreadthFirst breadthFirst = new BreadthFirst();
        DeapthFirst deapthFirst = new DeapthFirst();

        System.out.println(breadthFirst.findNodeFrom(startPos, goalPos));
        System.out.println(breadthFirst.findPathFrom(startPos, goalPos));
        System.out.println();
        System.out.println(deapthFirst.findNodeFrom(startPos, goalPos));
        System.out.println(deapthFirst.findPathFrom(startPos, goalPos));
    }
}
