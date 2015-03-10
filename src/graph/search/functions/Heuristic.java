package graph.search.functions;

import graph.Coordinate;
import graph.Node;
import ilist.Function2;

public interface Heuristic<A> extends Function2<Node<A>, Node<A>, Double> {
    Heuristic<Coordinate> manhattan = new Heuristic<Coordinate>() {
        @Override
        public Double apply(Node<Coordinate> a, Node<Coordinate> b) {
            return Math.sqrt((a.getContents().x - b.getContents().x) ^ 2 + ((a.getContents().y - b.getContents().y ^ 2)));
        }
    };

    @Override
    Double apply(Node<A> a, Node<A> b);
}
