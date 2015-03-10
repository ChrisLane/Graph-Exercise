package graph.search.functions;

import graph.Coordinate;
import graph.Node;
import ilist.Function2;


public interface Distance<A> extends Function2<Node<A>, Node<A>, Double> {
    Distance<Coordinate> manhattan = new Distance<Coordinate>() {
        @Override
        public Double apply(Node<Coordinate> a, Node<Coordinate> b) {
            return (double) Math.abs(a.getContents().x - b.getContents().x) + Math.abs(a.getContents().y - b.getContents().y);
        }
    };

    @Override
    Double apply(Node<A> a, Node<A> b);
}
