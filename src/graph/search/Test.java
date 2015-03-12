package graph.search;

import graph.Coordinate;
import graph.Graph;
import graph.Node;

public class Test {
    public static void main(String[] args) {

        Graph<Coordinate> graph = Graph.getGraph();
        final Coordinate startCoord = new Coordinate(0, 0);
        final Coordinate goalCoord = new Coordinate(5, 5);
        final Node<Coordinate> startPos = graph.nodeWith(startCoord);
        final Node<Coordinate> goalPos = graph.nodeWith(goalCoord);
        BFS bfs = new BFS();
        DFS dfs = new DFS();

        System.out.println(bfs.findNodeFrom(startPos, goalPos));
        System.out.println(bfs.findPathFrom(startPos, goalPos));
        System.out.println();
        System.out.println(dfs.findNodeFrom(startPos, goalPos));
        System.out.println(dfs.findPathFrom(startPos, goalPos));
    }
}
