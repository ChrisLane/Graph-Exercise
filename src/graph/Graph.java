package graph;

import java.util.LinkedHashMap;
import java.util.Map;

// We represent a graph as table of pairs (getContents, node with that getContents).
// This assumes that each node has a unique getContents.
// This is a minimal class so that a graph can be created.

public class Graph<A> {

    static Graph<Coordinate> defaultGraph;
    private static final int[][] graphData = {
            {0, 0, 1, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 2},
            {0, 2, 0, 3, 0, 1},
            {0, 3, 0, 2, 0, 4},
            {0, 4, 0, 3, 0, 5},
            {0, 5, 0, 6, 1, 5, 0, 4},
            {0, 6, 1, 6, 0, 5},
            {1, 0, 0, 0, 1, 1, 2, 0},
            {1, 1, 1, 2, 2, 1, 1, 0, 0, 1},
            {1, 2, 2, 2, 1, 1, 1, 3},
            {1, 3, 1, 2, 1, 4, 2, 3},
            {1, 4, 2, 4, 1, 5, 1, 3},
            {1, 5, 1, 4, 2, 5, 1, 6, 0, 5},
            {1, 6, 0, 6, 1, 5, 2, 6},
            {2, 0, 3, 0, 2, 1, 1, 0},
            {2, 1, 2, 2, 1, 1, 2, 0, 3, 1},
            {2, 2, 1, 2, 2, 1, 2, 3, 3, 2},
            {2, 3, 2, 2, 2, 4, 3, 3, 1, 3},
            {2, 4, 1, 4, 2, 5, 2, 3, 3, 4},
            {2, 5, 2, 4, 1, 5, 2, 6, 3, 5},
            {2, 6, 3, 6, 2, 5, 1, 6},
            {3, 0, 2, 0, 3, 1},
            {3, 1, 3, 0, 4, 1, 2, 1, 3, 2},
            {3, 2, 2, 2, 4, 2, 3, 1},
            {3, 3, 2, 3, 3, 4},
            {3, 4, 2, 4, 3, 3},
            {3, 5, 3, 6, 2, 5, 4, 5},
            {3, 6, 2, 6, 3, 5},
            {4, 0},
            {4, 1, 4, 2, 5, 1, 3, 1},
            {4, 2, 4, 1, 5, 2, 3, 2},
            {4, 3},
            {4, 4},
            {4, 5, 5, 5, 3, 5},
            {4, 6},
            {5, 0},
            {5, 1, 4, 1, 5, 2, 6, 1},
            {5, 2, 4, 2, 5, 1, 6, 2},
            {5, 3},
            {5, 4},
            {5, 5, 4, 5, 6, 5},
            {5, 6},
            {6, 0, 7, 0, 6, 1},
            {6, 1, 6, 0, 5, 1, 6, 2, 7, 1},
            {6, 2, 5, 2, 6, 1, 7, 2},
            {6, 3, 7, 3, 6, 4},
            {6, 4, 6, 3, 7, 4},
            {6, 5, 5, 5, 6, 6, 7, 5},
            {6, 6, 7, 6, 6, 5},
            {7, 0, 6, 0, 7, 1, 8, 0},
            {7, 1, 8, 1, 7, 0, 6, 1, 7, 2},
            {7, 2, 7, 3, 8, 2, 6, 2, 7, 1},
            {7, 3, 6, 3, 7, 2, 7, 4, 8, 3},
            {7, 4, 7, 3, 8, 4, 6, 4, 7, 5},
            {7, 5, 8, 5, 7, 6, 7, 4, 6, 5},
            {7, 6, 6, 6, 7, 5, 8, 6},
            {8, 0, 8, 1, 7, 0, 9, 0},
            {8, 1, 8, 2, 9, 1, 7, 1, 8, 0},
            {8, 2, 8, 1, 7, 2, 8, 3},
            {8, 3, 8, 2, 7, 3, 8, 4},
            {8, 4, 8, 5, 8, 3, 7, 4},
            {8, 5, 9, 5, 8, 4, 7, 5, 8, 6},
            {8, 6, 8, 5, 7, 6, 9, 6},
            {9, 0, 9, 1, 8, 0},
            {9, 1, 8, 1, 9, 2, 9, 0},
            {9, 2, 9, 1, 9, 3},
            {9, 3, 9, 2, 9, 4},
            {9, 4, 9, 5, 9, 3},
            {9, 5, 8, 5, 9, 4, 9, 6},
            {9, 6, 9, 5, 8, 6}
    };
    // Keep the implementation of maps open, by using the Map interface:
    private final Map<A, Node<A>> nodes;


    // Constructs the empty graph:
    public Graph() {
        // Choose any implementation of sets you please, but you need to
        // choose one.
        nodes = new LinkedHashMap<A, Node<A>>();
    }

    // Builds sample graph for testing:
    public static void main(String args[]) {
        // Done. We have the graph. Now we print it back to be sure this worked:
        for (Map.Entry<Coordinate, Node<Coordinate>> e : defaultGraph.nodes.entrySet()) {
            Coordinate c = e.getKey();
            Node<Coordinate> node = e.getValue();
            assert (c.equals(node.getContents()));
            System.out.print("(" + c.x + "," + c.y + "): ");
            for (Node<Coordinate> s : node.getSuccessors()) {
                System.out.print("(" + s.getContents().x + "," + s.getContents().y + "), ");
            }
            System.out.println();
        }
    }

    /**
     * Generates the default "nick's graph"
     */
    public static void generateGraph() {
        defaultGraph = new Graph<Coordinate>();

        for (int[] aNick : graphData) {
            // What we are going to do relies on the two following facts
            // about nick:
            assert (aNick.length >= 2);       // (1)
            assert (aNick.length % 2 == 0);   // (2)

            int x = aNick[0]; // Can't get array out of bounds
            int y = aNick[1]; // because of assertion (1).
            Coordinate c = new Coordinate(x, y);

            // Find or create node:
            Node<Coordinate> node = defaultGraph.nodeWith(c);

            // And next add the node's getSuccessors. We rely on assertion
            // (2) again to avoid array out of bounds. Now we start from
            // position 2, as positions 0 and 1 have already been looked at
            // (they are x and y). Notice that we need to increment by 2.

            for (int j = 2; j < aNick.length; j = j + 2) {
                int sx = aNick[j];
                int sy = aNick[j + 1];
                Coordinate sc = new Coordinate(sx, sy);
                // Find or create successor node, and then add it
                Node<Coordinate> s = defaultGraph.nodeWith(sc);
                node.addSuccessor(s);
            }
        }
    }

    /**
     * Returns the default "nick's graph"
     *
     * @return The default "nick's graph"
     */
    public static Graph<Coordinate> getGraph() {
        if (defaultGraph == null)
            generateGraph();
        return defaultGraph;
    }

    // Find or create node with a given getContents c:
    public Node<A> nodeWith(A c) {
        Node<A> node; // Deliberately uninitialized.
        if (nodes.containsKey(c)) {
            node = nodes.get(c);
        } else {
            node = new Node<A>(c);
            nodes.put(c, node);
        }
        return node;
    }

    // Get method:
    public Map<A, Node<A>> nodes() {
        return nodes;
    }
}
