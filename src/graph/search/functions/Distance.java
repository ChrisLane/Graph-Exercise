package graph.search.functions;

import graph.Coordinate;
import graph.Node;
import ilist.Function2;


public interface Distance<A> extends Function2<Node<A>, Node<A>, Double> {
    public static final Distance<Coordinate> manhattan = new Distance<Coordinate>() {
        @Override
        public Double apply(Node<Coordinate> a, Node<Coordinate> b) {
            return (double) (a.getContents().x - b.getContents().x + a.getContents().y - b.getContents().y);
        }
    };

    @Override
    public Double apply(Node<A> a, Node<A> b);
}
