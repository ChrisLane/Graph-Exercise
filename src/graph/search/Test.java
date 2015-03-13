package graph.search;

import graph.Coordinate;
import graph.Graph;
import graph.Node;
import graph.search.function.Distance;
import graph.search.function.Heuristic;
import graph.search.searchtype.AStar;
import graph.search.searchtype.BreadthFirst;
import graph.search.searchtype.DepthFirst;

public class Test {
    public static void main(String[] args) {

        Graph<Coordinate> graph = Graph.getGraph();
        Coordinate startCoord = new Coordinate(0, 0);
        Coordinate goalCoord = new Coordinate(5, 5);
        Node<Coordinate> startPos = graph.nodeWith(startCoord);
        Node<Coordinate> goalPos = graph.nodeWith(goalCoord);

        BreadthFirst breadthFirst = new BreadthFirst();
        DepthFirst depthFirst = new DepthFirst();
        AStar aStar = new AStar();

        System.out.println(breadthFirst.findNodeFrom(startPos, goalPos));
        System.out.println(breadthFirst.findPathFrom(startPos, goalPos));
        System.out.println();
        System.out.println(depthFirst.findNodeFrom(startPos, goalPos));
        System.out.println(depthFirst.findPathFrom(startPos, goalPos));
        System.out.println();
        System.out.println(aStar.findNodeFrom(startPos, goalPos, Heuristic.manhattan, Distance.manhattan));
        System.out.println(aStar.findPathFrom(startPos, goalPos, Heuristic.manhattan, Distance.manhattan));
    }
}
